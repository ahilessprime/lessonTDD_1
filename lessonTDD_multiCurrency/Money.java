package lessonTDD_multiCurrency;

public abstract class Money {

    protected String currency;

    public abstract Money times(int multiplayer);


    protected int amount;

    public Money(int amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }


    @Override
    public boolean equals(Object object){
        Money money = (Money) object;
        return amount == money.amount
                && getClass().equals(money.getClass());

    }

    public  String currency(){
        return currency();
    }

    public static Money dollar(int amount){
        return new Dollar(amount, "USD");
    }
    public static Money franc(int amount){
        return new Franc(amount, "CHF");
    }
}
