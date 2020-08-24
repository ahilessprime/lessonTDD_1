package Test;

import lessonTDD_multiCurrency.Money;
import org.junit.Test;
import static org.junit.Assert.*;



public class TestAddition {



    @Test
    public void testEquality(){

        assertTrue( Money.dollar(5).equals(( Money.dollar(5))));
        assertFalse( Money.dollar(5).equals(( Money.dollar(6))));

        assertFalse(Money.franc(5).equals(( Money.dollar(5))));

    }

    @Test
    public void testFrancMultiplication(){
        Money five = Money.franc(5);
        assertEquals( Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }

    @Test
    public void TestCurrency(){
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }


    @Test
    public void TestSimpleAddition(){
        Money sum = Money.dollar(5).plus(Money.dollar(5));
        assertEquals(Money.dollar(10), sum);
    }


}
