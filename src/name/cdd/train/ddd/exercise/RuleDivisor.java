package name.cdd.train.ddd.exercise;

public class RuleDivisor implements Rule
{
    private int divisor;
    private String outputIfTrue;
    private String outputIfFalse;

    public RuleDivisor(int divisor, String outputIfTrue, String outputIfFalse)
    {
        this.divisor = divisor;
        this.outputIfTrue = outputIfTrue;
        this.outputIfFalse = outputIfFalse;
    }

    @Override
    public String process(int input)
    {
        return isNumberDivisibleBy(input, divisor) ? outputIfTrue : outputIfFalse;
    }

    private boolean isNumberDivisibleBy(int input, int divisor)
    {
        return input % divisor == 0;
    }

}
