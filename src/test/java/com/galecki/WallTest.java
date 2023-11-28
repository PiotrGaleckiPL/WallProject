package com.galecki;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Test cases for Wall")
class WallTest {

    private static Wall wall;
    private final static String RED = "red";
    private final static String GREY = "grey";
    private final static String BLACK = "black";
    private final static String WHITE = "white";
    private final static String YELLOW = "yellow";
    private final static String PINK = "pink";
    private final static String BRICK = "brick";
    private final static String CONCRETE = "concrete";
    private final static String WOOD = "wood";

    @BeforeAll
    static void setup(){

        //given - for all test cases
        Block block1 = new SimpleBlock(RED, BRICK);
        Block block2 = new SimpleBlock(GREY, CONCRETE);
        Block block3 = new SimpleBlock(BLACK, CONCRETE);

        ComplexBlock complexBlock = new ComplexBlock(Arrays.asList(
                new SimpleBlock(WHITE, CONCRETE),
                new SimpleBlock(YELLOW, BRICK)));

        List<Block> blocks = new ArrayList<>();
        blocks.add(block1);
        blocks.add(block2);
        blocks.add(block3);
        blocks.add(complexBlock);

        wall = new Wall(blocks);
    }

    @Test
    @DisplayName("Count should return current number of Blocks")
    void countShouldReturnCurrentNumberOfBlocks(){

        //when
        int currentNumberOfBlocks = wall.count();

        //then
        assertThat(currentNumberOfBlocks, is(equalTo(4)));
    }

    @Test
    @DisplayName("Finding blocks by material should return all blocks made by given material")
    void findingBlocksByMaterialShouldReturnAllBlocksMadeByGivenMaterial(){

        //when
        List<Block> resultList = wall.findBlocksByMaterial(CONCRETE);

        //then
        assertThat(resultList, hasSize(3));
        assertTrue(resultList.stream().allMatch(block -> block.getMaterial().equals(CONCRETE)));
    }

    @Test
    @DisplayName("Finding blocks by material should return an empty list for a nonexistence material")
    void findingBlocksByMaterialShouldReturnEmptyListForNonexistenceMaterial(){

        //when
        List<Block> resultList = wall.findBlocksByMaterial(WOOD);

        //then
        assertThat(resultList, is(empty()));
    }

    @Test
    @DisplayName("Finding block by color should return first block with given color")
    void findingBlockByColorShouldReturnFirstBlockWithGivenColor(){

        //when
        Optional<Block> resultBlock = wall.findBlockByColor(GREY);

        //then
        assertTrue(resultBlock.isPresent());
        assertThat(resultBlock.get().getColor(), is(GREY));
    }

    @Test
    @DisplayName("Finding block by color should return an empty Optional for nonexistence color")
    void findingBlockByColorShouldReturnEmptyOptionalForNonexistenceColor(){

        //when
        Optional<Block> resultBlock = wall.findBlockByColor(PINK);

        //then
        assertThat(resultBlock, is(Optional.empty()));
    }

}