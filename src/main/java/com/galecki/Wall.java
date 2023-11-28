package com.galecki;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {

    private List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        for (Block block : blocks){
            if(block.getColor().equals(color)){
                return Optional.of(block);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> blockList = new ArrayList<>();
        for(Block block : blocks){
            if(block.getMaterial().equals(material)){
                blockList.add(block);
            }
        }
        return blockList;
    }

    @Override
    public int count() {
        return blocks.size();
    }
}
