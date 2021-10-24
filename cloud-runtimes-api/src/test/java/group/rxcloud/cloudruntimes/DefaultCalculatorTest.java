package group.rxcloud.cloudruntimes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultCalculatorTest {

    private DefaultCalculator calculator = new DefaultCalculator();

    @Test
    void add() {
        Assertions.assertEquals(4,calculator.add(2,2));
    }

    @Test
    void sub() {
        Assertions.assertEquals(0,calculator.sub(2,2));
    }

    @Test
    void multiple() {
        Assertions.assertEquals(4,calculator.multiple(2,2));
    }
}