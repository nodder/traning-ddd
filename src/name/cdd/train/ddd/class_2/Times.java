package name.cdd.train.ddd.class_2;

public class Times implements Predication
{
    private int times;

    public Times(int times)
    {
        this.times = times;
    }

    @Override
    public boolean predicate(int input)
    {
        return input % times == 0;
    }

}
