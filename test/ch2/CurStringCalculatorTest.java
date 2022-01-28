package ch2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurStringCalculatorTest {
    private CurStringCalculator cal;

    @BeforeEach
    void beforeAll() {
        cal = new CurStringCalculator();
    }

    @Test
    public void add_null_또는_빈문자() {
        assertEquals(0, cal.add(null));
        assertEquals(0, cal.add(""));
    }

    @Test
    public void add_숫자하나() {
        assertEquals(0, cal.add("0"));
    }

    @Test
    public void add_쉼표구분자() {
        assertEquals(4, cal.add("3,1"));
    }

    @Test
    public void add_쉼표_또는_세미콜론_구분자() {
        assertEquals(8, cal.add("3,1:4"));
    }

    @Test
    public void add_커스텀구분자() {
        assertEquals(6, cal.add("//;\n1;2;3"));
    }

    @Test
    public void add_negative() {
        assertThrows(RuntimeException.class, () -> {
            cal.add("-1,2,3");
        });
    }
}