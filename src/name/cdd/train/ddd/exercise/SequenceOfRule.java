package name.cdd.train.ddd.exercise;

public class SequenceOfRule implements Rule
{
    private Rule[] rules;

    public SequenceOfRule(Rule... rules)
    {
        this.rules = rules;
    }

    @Override
    public String process(int input)
    {
        StringBuffer buf = new StringBuffer();
        
        for(Rule rule : rules)
        {
            buf.append(rule.process(input));
        }
        
        return buf.length() == 0 ? Integer.toString(input) : buf.toString();
    }
}
