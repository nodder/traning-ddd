package name.cdd.train.ddd.selftrain.train_1;

import java.util.function.Function;
import java.util.function.Predicate;

import name.cdd.train.ddd.selftrain.train_1.UnaryParams.CardType;
import name.cdd.train.ddd.selftrain.train_1.framework.Result;
import name.cdd.train.ddd.selftrain.train_1.framework.Rule;


public class ResistorCompAtomicRule implements Rule<Float[], Float>
{
    private Predicate<ResistorCompParam> pre;
    private Function<Float[], Float> oper;
    private CardType cardType;

    public ResistorCompAtomicRule(Predicate<ResistorCompParam> pre, Function<Float[], Float> oper, CardType cardType)
    {
        this.pre = pre;
        this.oper = oper;
        this.cardType = cardType;
    }
    

    @Override
    public Result<Float> apply(Float[] floats)
    {
        ResistorCompParam param = new ResistorCompParam(cardType, floats[0], floats[1], floats[2]);
        
        if(pre.test(param))
        {
            return new Result<Float>(true, oper.apply(floats));
        }
        
        return Result.failResult();
    }
    
    
}
