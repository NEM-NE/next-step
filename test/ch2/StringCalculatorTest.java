package ch2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    private StringCalculator cal;

    @BeforeEach
    void beforeAll() {
        cal = new StringCalculator();
    }

    @Test
    void splitInput(){
        assertArrayEquals(new int[]{1, 2, 3}, cal.splitInput("1,2:3"));
        assertArrayEquals(new int[]{1, 2, 3}, cal.splitInput("1,2,3"));
        assertArrayEquals(new int[]{1, 2, 3}, cal.splitInput("1:2:3"));
    }

    @Test
    void detectDelimiter() {
        String[] result = cal.detectDelimiter("//;\n1;2;3");
        assertArrayEquals(new String[]{"1", "2", "3"}, result);

        result = cal.detectDelimiter("//!\n1!2!3");
        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

    @Test
    void calWithAdd() {
        assertEquals(6, cal.add("1,2:3"));
        assertEquals(6, cal.add("//;\n1;2;3"));
    }

}