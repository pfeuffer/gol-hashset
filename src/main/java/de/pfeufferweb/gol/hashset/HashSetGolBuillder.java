package de.pfeufferweb.gol.hashset;

import java.util.Collection;
import java.util.HashSet;

import de.pfeufferweb.gol.benchmark.GolBuilder;

public class HashSetGolBuillder implements GolBuilder {
    private final Collection<Cell> aliveCells = new HashSet<>();

    @Override
    public void addCell(int x, int y) {
        aliveCells.add(new Cell(x, y));
    }

    @Override
    public HashSetGol create() {
        return new HashSetGol(aliveCells);
    }

}
