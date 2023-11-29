package com.galecki;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@DisplayName("Test cases for ComplexBlock")
class ComplexBlockTest {

    private final static String RED = "red";
    private final static String GREY = "grey";
    private final static String BRICK = "brick";
    private final static String CONCRETE = "concrete";
    private final static String EMPTY_STRING = "";

    @Test
    @DisplayName("Getting blocks should return list of blocks contained within the complex block")
    void gettingBlocksShouldReturnListOfBlocksContainedWithinTheComplexBlock(){

        //given
        Block block1 = new SimpleBlock(RED, BRICK);
        Block block2 = new SimpleBlock(GREY, CONCRETE);

        ComplexBlock complexBlock = new ComplexBlock(List.of(block1, block2));

        //when
        List<Block> resultList = complexBlock.getBlocks();

        //then
        assertThat(resultList, allOf(
                notNullValue(),
                is(not(emptyCollectionOf(Block.class))),
                hasSize(2)
        ));
    }
    @Test
    @DisplayName("Getting color should return color of the first block contained within the complex block")
    void gettingColorShouldReturnColorOfFirstBlockContainedWithinTheComplexBlock(){

        //given
        Block block1 = new SimpleBlock(RED, BRICK);
        Block block2 = new SimpleBlock(GREY, CONCRETE);

        ComplexBlock complexBlock = new ComplexBlock(List.of(block1, block2));

        //when
        String resultColor = complexBlock.getColor();

        //then
        assertThat(resultColor, is(RED));
    }

    @Test
    @DisplayName("Getting color should return empty string if there is no block contained within the complex block")
    void gettingColorShouldReturnEmptyStringIfThereIsNoBlockContainedWithinTheComplexBlock(){

        //given
        ComplexBlock complexBlock = new ComplexBlock(Collections.emptyList());

        //when
        String resultColor = complexBlock.getColor();

        //then
        assertThat(resultColor, is(EMPTY_STRING));
    }

    @Test
    @DisplayName("Getting material should return material of the first block contained within the complex block")
    void gettingMaterialShouldReturnMaterialOfFirstBlockContainedWithinTheComplexBlock(){

        //given
        Block block1 = new SimpleBlock(RED, BRICK);
        Block block2 = new SimpleBlock(GREY, CONCRETE);

        ComplexBlock complexBlock = new ComplexBlock(List.of(block1, block2));

        //when
        String resultColor = complexBlock.getMaterial();

        //then
        assertThat(resultColor, is(BRICK));
    }

    @Test
    @DisplayName("Getting material should return empty string if there is no block contained within the complex block")
    void gettingMaterialShouldReturnEmptyStringIfThereIsNoBlockContainedWithinTheComplexBlock(){

        //given
        ComplexBlock complexBlock = new ComplexBlock(Collections.emptyList());

        //when
        String resultColor = complexBlock.getMaterial();

        //then
        assertThat(resultColor, is(EMPTY_STRING));
    }
}