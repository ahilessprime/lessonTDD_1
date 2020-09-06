package lessonTDD_multiCurrency;

public interface Expression {
    public Money reduce(Bank bank, String to);
    public Expression plus(Expression added);
}
