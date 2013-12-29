package de.pfeufferweb.gol.hashset;

import java.util.Collection;
import java.util.HashSet;

import de.pfeufferweb.gol.benchmark.Gol;

public class HashSetGol implements Gol {
    Collection<Cell> cells = new HashSet<>();

    @Override
    public void addCell(int x, int y) {
        cells.add(new Cell(x, y));
    }

    @Override
    public HashSetGol next() {
        return new HashSetGol();
    }

    public Collection<Cell> getCells() {
        return cells;
    }
}
