package de.pfeufferweb.gol.hashset;

import static de.pfeufferweb.gol.hashset.CellLongConverter.cell;
import static de.pfeufferweb.gol.hashset.CellLongConverter.x;
import static de.pfeufferweb.gol.hashset.CellLongConverter.y;

import java.util.Collection;
import java.util.HashSet;

import de.pfeufferweb.gol.benchmark.Gol;

class HashSetGol implements Gol {
    private final Collection<Long> aliveCells;

    HashSetGol(Collection<Long> aliveCells) {
        this.aliveCells = aliveCells;
    }

    @Override
    public HashSetGol next() {
        Collection<Long> nextGenerationCells = computeCellsForNextGeneration();
        return new HashSetGol(nextGenerationCells);
    }

    private Collection<Long> computeCellsForNextGeneration() {
        Collection<Long> nextGenerationCells = new HashSet<>();
        for (Long cell : aliveCells) {
            int aliveNeighbourCount = aliveNeighbourCount(cell);
            if (aliveNeighbourCount == 2 || aliveNeighbourCount == 3) {
                nextGenerationCells.add(cell);
            }
        }
        for (Long neighbour : allNeighbours()) {
            if (aliveNeighbourCount(neighbour) == 3) {
                nextGenerationCells.add(neighbour);
            }
        }
        return nextGenerationCells;
    }

    private Collection<Long> allNeighbours() {
        Collection<Long> neighbours = new HashSet<>();
        for (Long cell : aliveCells) {
            neighbours.addAll(neighbours(cell));
        }
        return neighbours;
    }

    private int aliveNeighbourCount(Long cell) {
        int count = 0;
        for (Long neighbour : neighbours(cell)) {
            if (aliveCells.contains(neighbour)) {
                ++count;
            }
        }
        return count;
    }

    private Collection<Long> neighbours(Long cell) {
        Collection<Long> neighbours = new HashSet<>();
        for (int x = x(cell) - 1; x <= x(cell) + 1; ++x) {
            for (int y = y(cell) - 1; y <= y(cell) + 1; ++y) {
                long neighbour = cell(x, y);
                if (neighbour != cell) {
                    neighbours.add(neighbour);
                }
            }
        }
        return neighbours;
    }

    public Collection<Long> getCells() {
        return aliveCells;
    }

    @Override
    public boolean isAlive(int x, int y) {
        return aliveCells.contains(cell(x, y));
    }

    @Override
    public String toString() {
        return aliveCells.toString();
    }
}
