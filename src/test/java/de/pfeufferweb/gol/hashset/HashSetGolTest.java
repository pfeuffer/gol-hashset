package de.pfeufferweb.gol.hashset;

import static de.pfeufferweb.gol.hashset.CellLongConverter.cell;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HashSetGolTest {
    @Test
    public void emptyGolStaysEmpty() {
        assertTrue(new HashSetGolBuilder().create().next().getCells().isEmpty());
    }

    @Test
    public void addedCellStored() {
        HashSetGolBuilder builder = new HashSetGolBuilder();
        builder.addCell(0, 0);
        HashSetGol underTest = builder.create();
        assertTrue(underTest.getCells().contains(cell(0, 0)));
    }

    @Test
    public void singleCellDies() {
        HashSetGolBuilder builder = new HashSetGolBuilder();
        builder.addCell(0, 0);
        HashSetGol underTest = builder.create();
        HashSetGol nextGeneration = underTest.next();
        assertTrue(nextGeneration.getCells().isEmpty());
    }

    @Test
    public void staticCellBlockStayesAlive() {
        HashSetGolBuilder builder = new HashSetGolBuilder();
        builder.addCell(0, 0);
        builder.addCell(1, 0);
        builder.addCell(0, 1);
        builder.addCell(1, 1);
        HashSetGol underTest = builder.create();
        HashSetGol nextGeneration = underTest.next();
        assertTrue(nextGeneration.getCells().containsAll(
                asList(cell(0, 0), cell(1, 0), cell(0, 1), cell(1, 1))));
    }

    @Test
    public void cellWithTwoAliveNeighboursStayesAlive() {
        HashSetGolBuilder builder = new HashSetGolBuilder();
        builder.addCell(0, 0);
        builder.addCell(1, 0);
        builder.addCell(0, 1);
        HashSetGol underTest = builder.create();
        HashSetGol nextGeneration = underTest.next();
        assertTrue(nextGeneration.getCells().contains(cell(0, 0)));
    }

    @Test
    public void deadCellWithThreeAliveNeighboursComesToLive() {
        HashSetGolBuilder builder = new HashSetGolBuilder();
        builder.addCell(1, 0);
        builder.addCell(0, 1);
        builder.addCell(1, 1);
        HashSetGol underTest = builder.create();
        HashSetGol nextGeneration = underTest.next();
        assertTrue(nextGeneration.getCells().contains(cell(0, 0)));
    }
}
