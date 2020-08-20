package Test;

import org.junit.Test;
import static org.junit.Assert.*;

import lessonTDD_multiCurrency.Dollar;

public class TestAddition {

    @Test
    public void testMultiplication(){
        Dollar five = new Dollar(5);
        five.times(2);
        assertEquals(10, five.amount);
    }

}
