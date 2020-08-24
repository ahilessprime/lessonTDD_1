package lessonTDD_multiCurrency;

public class Money {

    protected String currency;
    private int amount;


    public Money(int amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }


    public  Money times(int multiplayer){
        return new Money(amount * multiplayer, currency);
    }


    @Override
    public boolean equals(Object object){
        Money money = (Money) object;
        return amount == money.amount
                && currency.equals(money.currency());

    }

    public  String currency(){
        return currency;
    }

    public static Money dollar(int amount){
        return new Money(amount, "USD");
    }
    public static Money franc(int amount){
        return new Money(amount, "CHF");
    }

    @Override
    public String toString(){
        return amount+" "+currency;
    }
}
