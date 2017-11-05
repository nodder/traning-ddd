package name.cdd.train.ddd.exercise;

public class RuleSpec
{
    public static Rule getRule()
    {
        return new RuleContain("3", "Fizz", 
                        new SequenceOfRule(divRule(3, "Fizz", ""), divRule(5, "Buzz", ""), divRule(7, "Whizz", "")));
    }

    private static Rule divRule(int divisor, String outputIfTrue, String outputIfFalse)
    {
        return new RuleDivisor(divisor, outputIfTrue, outputIfFalse);
    }
}
