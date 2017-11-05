package name.cdd.train.ddd.class_2;

public class Result
{
    private boolean isSuccess;
    private String str;

    public Result(boolean isSuccess, String str)
    {
        this.isSuccess = isSuccess;
        this.str = str;
    }

    public boolean isSuccess()
    {
        return isSuccess;
    }

    public String getStr()
    {
        return str;
    }

    public static Result failedResult()
    {
        return new Result(false, "");
    }
    
    public static Result succeededResult(String str)
    {
        return new Result(true, str);
    }
}
