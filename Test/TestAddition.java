package Test;

import lessonTDD_multiCurrency.Bank;
import lessonTDD_multiCurrency.Expression;
import lessonTDD_multiCurrency.Money;
import lessonTDD_multiCurrency.Summ;
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

        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    public void TestPlusReturnsSum(){

        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Summ sum = (Summ) result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }

    @Test
    public void TestReduceSumm(){
        Expression sum = new Summ(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }

    @Test
    public void TestReduceMoney(){
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void TestReduceMoneyDifferrentCurrency(){
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void TestIdentityRate(){
        assertEquals(1, new Bank().rate("USD","USD"));
    }

    @Test
    public void TestMixedAddition(){
        Expression fiveBucks = Money.dollar(5);
        Expression teenFranks = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(fiveBucks.plus(teenFranks), "USD");
        assertEquals(Money.dollar(10), result);
    }

    @Test
    public void TestSummPlusMoney(){
        Expression fiveBucks = Money.dollar(5);
        Expression teenFranks = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Summ(fiveBucks,teenFranks).plus(fiveBucks);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(15), result);
    }

    @Test
    public void TestSumTimes(){
        Expression fiveBucks = Money.dollar(5);
        Expression teenFranks = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Summ(fiveBucks,teenFranks).times(2);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(20), result);
    }

    
}
