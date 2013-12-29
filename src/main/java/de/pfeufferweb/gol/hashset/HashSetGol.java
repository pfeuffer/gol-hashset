package de.pfeufferweb.gol.hashset;

import java.util.Collection;
import java.util.HashSet;

import de.pfeufferweb.gol.benchmark.Gol;

public class HashSetGol implements Gol {
    private final Collection<Cell> aliveCells;

    private HashSetGol(Collection<Cell> aliveCells) {
        this.aliveCells = aliveCells;
    }

    public HashSetGol() {
        aliveCells = new HashSet<>();
    }

    @Override
    public void addCell(int x, int y) {
        aliveCells.add(new Cell(x, y));
    }

    @Override
    public HashSetGol next() {
        Collection<Cell> nextGenerationCells = computeCellsForNextGeneration();
        return new HashSetGol(nextGenerationCells);
    }

    private Collection<Cell> computeCellsForNextGeneration() {
        Collection<Cell> nextGenerationCells = new HashSet<>();
        for (Cell cell : aliveCells) {
            int aliveNeighbourCount = aliveNeighbourCount(cell);
            if (aliveNeighbourCount == 2 || aliveNeighbourCount == 3) {
                nextGenerationCells.add(cell);
            }
            for (Cell neighbour : neighbours(cell)) {
                if (aliveNeighbourCount(neighbour) == 3) {
                    nextGenerationCells.add(neighbour);
                }
            }
        }
        return nextGenerationCells;
    }

    private int aliveNeighbourCount(Cell cell) {
        int count = 0;
        for (Cell neighbour : neighbours(cell)) {
            if (aliveCells.contains(neighbour)) {
                ++count;
            }
        }
        return count;
    }

    private Collection<Cell> neighbours(Cell cell) {
        Collection<Cell> neighbours = new HashSet<>();
        for (int x = cell.x - 1; x <= cell.x + 1; ++x) {
            for (int y = cell.y - 1; y <= cell.y + 1; ++y) {
                Cell neighbour = new Cell(x, y);
                if (!neighbour.equals(cell)) {
                    neighbours.add(neighbour);
                }
            }
        }
        return neighbours;
    }

    public Collection<Cell> getCells() {
        return aliveCells;
    }
}
