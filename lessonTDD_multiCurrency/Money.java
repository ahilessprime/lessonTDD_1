package lessonTDD_multiCurrency;

public class Money implements Expression{

    protected String currency;
    protected int amount;


    public Money(int amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }


    public  Money times(int multiplayer){
        return new Money(amount * multiplayer, currency);
    }

    public Money reduce(String to){
        return this;
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

    public Expression plus(Money addend){
        return new Summ(this, addend);
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
