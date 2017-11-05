package name.cdd.train.ddd.selftrain.train_1.framework;

public interface Rule<F, T>
{
    Result<T> apply(F f);
    
    default <E> Rule<F, T> orElse(Rule<F, T> otherRule)
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
