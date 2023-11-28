package com.galecki;

import java.util.Collections;
import java.util.List;

public class ComplexBlock implements CompositeBlock{

    private final List<Block> blocks;

    public ComplexBlock(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public String getColor() {
        return blocks.isEmpty() ? "" : blocks.get(0).getColor();
    }

    @Override
    public String getMaterial() {
        return blocks.isEmpty() ? "" : blocks.get(0).getMaterial();
    }

    @Override
    public List<Block> getBlocks() {

        return Collections.unmodifiableList(blocks);
    }
}
