package ch2;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator cal;

    @BeforeEach
    void beforeAll() {
        cal = new Calculator();
    }

    @Test
    void add() {
        assertEquals(9, cal.add(6, 3));
    }

    @Test
    void subtract() {
        assertEquals(3, cal.subtract(6, 3));
    }

    @Test
    void multiply() {
        assertEquals(18, cal.multiply(6, 3));
    }

    @Test
    void divide() {
        assertEquals(2, cal.divide(6, 3));
    }

    @Test
    void splitInput(){
        cal.setInput("1,2:3");
        assertArrayEquals(new int[]{1, 2, 3}, cal.splitInput());

        cal.setInput("1,2,3");
        assertArrayEquals(new int[]{1, 2, 3}, cal.splitInput());

        cal.setInput("1:2:3");
        assertArrayEquals(new int[]{1, 2, 3}, cal.splitInput());
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
        cal.setInput("1,2:3");
        assertEquals(6, cal.calWithAdd());

        cal.setInput("//;\n1;2;3");
        assertEquals(6, cal.calWithAdd());
    }


}