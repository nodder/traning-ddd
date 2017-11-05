package name.cdd.train.ddd.selftrain.train_1;

import java.util.function.BiPredicate;
import java.util.function.UnaryOperator;

import name.cdd.train.ddd.selftrain.train_1.framework.Result;
import name.cdd.train.ddd.selftrain.train_1.framework.UnaryRule;


public class UnaryAtomicRule implements UnaryRule<Float>
{
    private BiPredicate<UnaryParams, Float> pre;
    private UnaryOperator<Float> oper;
    private UnaryParams param;

    public UnaryAtomicRule(BiPredicate<UnaryParams, Float> pre, UnaryOperator<Float> oper, UnaryParams param)
    {
        this.pre = pre;
        this.oper = oper;
        this.param = param;
    }
    

    @Override
    public Result<Float> apply(Float input)
    {
        if(pre.test(param, input))
        {
            return new Result<Float>(true, oper.apply(input));
        }
        
        return Result.failResult();
    }
    
    
}
