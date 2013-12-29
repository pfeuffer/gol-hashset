package de.pfeufferweb.gol.hashset;

import org.junit.Test;

public class HashSetGolTest {
    @Test
    public void emptyGolStaysEmpty() {
        new HashSetGol().next().getCells().isEmpty();
    }
}
