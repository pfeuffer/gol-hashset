package de.pfeufferweb.gol.hashset;

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
}
