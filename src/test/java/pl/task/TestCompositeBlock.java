package pl.task;

import java.util.List;

class TestCompositeBlock implements CompositeBlock {
    private List<Block> blocks;
    private String color;
    private String material;

    public TestCompositeBlock(List<Block> blocks) {
        this.blocks = blocks;
    }

    public TestCompositeBlock(List<Block> blocks, String material) {
        this.blocks = blocks;
        this.material = material;
    }

    public TestCompositeBlock(String color, List<Block> blocks) {
        this.blocks = blocks;
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }
}
