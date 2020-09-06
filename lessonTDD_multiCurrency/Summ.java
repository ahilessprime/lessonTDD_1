package lessonTDD_multiCurrency;

public class Summ implements Expression{
    public Expression augend;
    public Expression addend;

    public Summ(Expression augend, Expression addend){
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Bank bank, String to){
        int amount = augend.reduce(bank, to).amount
                + addend.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression added) {
        return new Summ(this,addend);
    }

    @Override
    public Expression times(int multiplier){
        return new Summ(augend.times(multiplier), addend.times(multiplier));
    }


}
