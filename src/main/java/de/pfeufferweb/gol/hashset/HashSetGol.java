package de.pfeufferweb.gol.hashset;

import java.util.Collection;
import java.util.Collections;

import de.pfeufferweb.gol.benchmark.Gol;

public class HashSetGol implements Gol {

    @Override
    public void addCell(int arg0, int arg1) {
    }

    @Override
    public HashSetGol next() {
        return this;
    }

    public Collection<Cell> getCells() {
        return Collections.emptySet();
    }
}
