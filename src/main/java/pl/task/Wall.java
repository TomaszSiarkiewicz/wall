package pl.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private List<Block> blocks;

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return findByColorSupport(color, blocks);
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return findByMaterialSupport(blocks, material);
    }

    @Override
    public int count() {
        return countSupport(blocks);
    }

    Optional<Block> findByColorSupport(String color, List<Block> blocks) {
        for (Block block : blocks) {
            if (color.equals(block.getColor())) return Optional.of(block);
            if (block instanceof CompositeBlock composite) {
                findByMaterialSupport(composite.getBlocks(), color);
            }
        }
        return Optional.empty();
    }

    List<Block> findByMaterialSupport(List<Block> blocks, String material) {
        List<Block> matchingBlocks = new ArrayList<>();

        for (Block block : blocks) {
            if (material.equals(block.getMaterial())) matchingBlocks.add(block);
            if (block instanceof CompositeBlock composite) {
                matchingBlocks.addAll(findByMaterialSupport(composite.getBlocks(), material));
            }
        }
        return matchingBlocks;
    }

    int countSupport(List<Block> blockList) {
        int counter = 0;
        for (Block block : blockList) {
            counter++;
            if ((block instanceof CompositeBlock composite))
                counter += countSupport(composite.getBlocks());
        }
        return counter;
    }
}
