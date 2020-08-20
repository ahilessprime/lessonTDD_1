package Test;

import lessonTDD_multiCurrency.Dollar;

public class TestAddition {

    public void testMultiplication(){
        Dollar five = new Dollar(5);
        five.times(2);
        assertEquals(10, five.amount);
    }

}
