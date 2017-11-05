package name.cdd.train.ddd.selftrain.train_1.framework;

public class Result<T>
{
    private boolean isSuccess;
    private T result;

    public Result(boolean isSuccess, T result)
    {
        this.isSuccess = isSuccess;
        this.result = result;
    }

    public boolean isSuccess()
    {
        return isSuccess;
    }

    public T getResult()
    {
        return result;
    }
    
    public static <E> Result<E> successResult(E result)
    {
        return new Result<E>(true, result);
    }

    public static <E> Result<E> failResult()
    {
        return new Result<E>(false, null);
    }
}
