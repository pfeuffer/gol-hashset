package de.pfeufferweb.gol.hashset;

import static de.pfeufferweb.gol.hashset.CellLongConverter.cell;
import static de.pfeufferweb.gol.hashset.CellLongConverter.x;
import static de.pfeufferweb.gol.hashset.CellLongConverter.y;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CellLongConverterTest {
    @Test
    public void conversionOf0_0Correct() {
        assertXY(0, 0);
    }

    @Test
    public void cellFor0_1() {
        assertEquals(1L, cell(0, 1));
    }

    @Test
    public void conversionOf1_1Correct() {
        assertXY(1, 1);
    }

    @Test
    public void conversionOfNegativesCorrect() {
        assertXY(-100, -100);
    }

    @Test
    public void conversionOfMaxValuesCorrect() {
        assertXY(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Test
    public void conversionOfMinValuesCorrect() {
        assertXY(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    private void assertXY(int x, int y) {
        assertEquals("y incorrect", y, y(cell(x, y)));
        assertEquals("x incorrect", x, x(cell(x, y)));
    }
}
