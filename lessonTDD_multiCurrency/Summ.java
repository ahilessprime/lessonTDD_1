package lessonTDD_multiCurrency;

public class Summ implements Expression{
    public Money augend;
    public Money addend;

    public Summ(Money augend, Money addend){
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(String to){
        int amount = augend.amount + addend.amount;
        return new Money(amount, to);
    }

}
