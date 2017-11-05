package name.cdd.train.ddd.class_2;

public class And implements Rule
{
    private Rule r1;
    private Rule r2;

    public And(Rule r1, Rule r2)
    {
        this.r1 = r1;
        this.r2 = r2;
    }

    @Override
    public Result apply(int input)
    {
        Result result1 = r1.apply(input);
        if(!result1.isSuccess())
        {
            return result1;
        }
        
        Result result2 = r2.apply(input);
        if(!result2.isSuccess())
        {
            return result2;
        }
        
        return Result.succeededResult(result1.getStr() + result2.getStr());
    }

}
