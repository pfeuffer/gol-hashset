package de.pfeufferweb.gol.hashset;

public class CellLongConverter {

    public static long cell(int x, int y) {
        return (long) x << 32 | y & 0xffffffffL;
    }

    public static int x(long cell) {
        return (int) (cell >> 32);
    }

    public static int y(long cell) {
        return (int) cell;
    }
}
