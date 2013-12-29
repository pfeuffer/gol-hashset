package de.pfeufferweb.gol.hashset;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HashSetGolTest {
    @Test
    public void emptyGolStaysEmpty() {
        assertTrue(new HashSetGol().next().getCells().isEmpty());
    }

    @Test
    public void addedCellStored() {
        HashSetGol underTest = new HashSetGol();
        underTest.addCell(0, 0);
        assertTrue(underTest.getCells().contains(new Cell(0, 0)));
    }

    @Test
    public void singleCellDies() {
        HashSetGol underTest = new HashSetGol();
        underTest.addCell(0, 0);
        HashSetGol nextGeneration = underTest.next();
        assertTrue(nextGeneration.getCells().isEmpty());
    }

    @Test
    public void staticCellBlockStayesAlive() {
        HashSetGol underTest = new HashSetGol();
        underTest.addCell(0, 0);
        underTest.addCell(1, 0);
        underTest.addCell(0, 1);
        underTest.addCell(1, 1);
        HashSetGol nextGeneration = underTest.next();
        assertTrue(nextGeneration.getCells().containsAll(
                asList(new Cell(0, 0), new Cell(1, 0), new Cell(0, 1),
                        new Cell(1, 1))));
    }
}
