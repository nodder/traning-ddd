package name.cdd.train.ddd.class_2;

public class AtomicRule implements Rule
{
    private Predication predication;
    private Action action;

    public AtomicRule(Predication predication, Action action)
    {
        this.predication = predication;
        this.action = action;
    }

    @Override
    public Result apply(int input)
    {
        if(predication.predicate(input))
        {
            return new Result(true, action.act(input));
        }
        
        return new Result(false, "");
    }
}
