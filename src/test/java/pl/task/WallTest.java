package pl.task;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {
    @Test
    public void should_return_zero_count_when_list_empty() {
        Wall wall = new Wall();
        List<Block> blocks = List.of();

        assertEquals(0, wall.countSupport(blocks));
    }

    @Test
    public void should_return_4_count_for_given_mixed_blocklist() {
        Wall wall = new Wall();
        List<Block> blocks = List.of(
                new TestBlock("", ""),
                new TestCompositeBlock(
                        List.of(
                                new TestCompositeBlock(List.of(
                                )),
                                new TestBlock("", "")
                        )
                )
        );
        assertEquals(4, wall.countSupport(blocks));
    }

    @Test
    public void should_return_4_if_only_composite() {
        Wall wall = new Wall();
        List<Block> blocks = List.of(
                new TestCompositeBlock(List.of()),
                new TestCompositeBlock(
                        List.of(
                                new TestCompositeBlock(List.of(
                                )),
                                new TestCompositeBlock(List.of())
                        )
                )
        );
        assertEquals(4, wall.countSupport(blocks));
    }

    @Test
    public void should_return_empty_list() {
        Wall wall = new Wall();
        List<Block> blocks = List.of();

        assertTrue(wall.findByMaterialSupport(blocks, "").isEmpty());
    }

    @Test
    public void should_return_size_4_list() {
        Wall wall = new Wall();

        List<Block> blocks = List.of(
                new TestBlock("", "a"),
                new TestCompositeBlock(
                        List.of(
                                new TestCompositeBlock(List.of(
                                ), "a"),
                                new TestBlock("", "a")
                        ), "a"
                )
        );
        assertEquals(4, wall.findByMaterialSupport(blocks, "a").size());
    }

    @Test
    public void should_return_size_2_list() {
        Wall wall = new Wall();

        List<Block> blocks = List.of(
                new TestBlock("", ""),
                new TestCompositeBlock(
                        List.of(
                                new TestCompositeBlock(List.of(
                                ), ""),
                                new TestBlock("", "a")
                        ), "a"
                )
        );
        assertEquals(2, wall.findByMaterialSupport(blocks, "a").size());
    }

    @Test
    public void should_return_first_from_list() {
        Wall wall = new Wall();
        List<Block> blocks = List.of(
                new TestBlock("a", ""),
                new TestCompositeBlock(
                        "a", List.of(
                        new TestCompositeBlock("a", List.of(
                        )),
                        new TestBlock("a", "")
                ))
        );
        assertEquals(blocks.get(0),wall.findByColorSupport("a", blocks).get());
    }
}