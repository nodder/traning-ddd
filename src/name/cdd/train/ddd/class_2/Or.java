package name.cdd.train.ddd.class_2;

public class Or implements Rule
{
    private Rule r1;
    private Rule r2;

    public Or(Rule r1, Rule r2)
    {
        this.r1 = r1;
        this.r2 = r2;
    }

    @Override
    public Result apply(int input)
    {
        Result result = r1.apply(input);
        if(result.isSuccess())
        {
            return result;
        }
        
        return r2.apply(input);
    }

}
