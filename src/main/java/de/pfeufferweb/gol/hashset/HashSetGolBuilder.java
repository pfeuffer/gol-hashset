package de.pfeufferweb.gol.hashset;

import static de.pfeufferweb.gol.hashset.CellLongConverter.cell;

import java.util.Collection;
import java.util.HashSet;

import de.pfeufferweb.gol.benchmark.GolBuilder;

public class HashSetGolBuilder implements GolBuilder {
    private final Collection<Long> aliveCells = new HashSet<>();

    @Override
    public void addCell(int x, int y) {
        aliveCells.add(cell(x, y));
    }

    @Override
    public HashSetGol create() {
        return new HashSetGol(aliveCells);
    }

}
