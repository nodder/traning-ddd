package name.cdd.train.ddd.selftrain.train_1.framework;

public interface UnaryRule<T> extends Rule<T, T>
{
    default UnaryRule<T> applyIfSuccess(UnaryRule<T> otherRule)
    {
        return input -> {
            Result<T> result1 = apply(input);
            if(!result1.isSuccess())
            {
                return result1;
                
            }
            
            Result<T> result2 = otherRule.apply(result1.getResult());
            if(!result2.isSuccess())
            {
                return result1;
            }
            
            return result2;
        };
    }
    
    default <E> UnaryRule<T> orElse(UnaryRule<T> otherRule)
    {
        return input -> {
            Result<T> result = this.apply(input);
            if(result.isSuccess())
            {
                return result;
            }

            return otherRule.apply(input);
        };
    }
}
