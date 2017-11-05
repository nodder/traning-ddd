package name.cdd.train.ddd.exercise;

public class RuleContain implements Rule
{
    private String key;
    private String outputIfTrue;
    private Rule outputIfFalse;

    public RuleContain(String key, String outputIfTrue, Rule outputIfFalse)
    {
        this.key = key;
        this.outputIfTrue = outputIfTrue;
        this.outputIfFalse = outputIfFalse;
    }

    @Override
    public String process(int input)
    {
        return Integer.toString(input).contains(key) ? outputIfTrue : outputIfFalse.process(input);
    }

}
