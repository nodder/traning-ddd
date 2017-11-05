package name.cdd.train.ddd.class_2;

public class AlwaysTrue implements Predication
{
    @Override
    public boolean predicate(int input)
    {
        return true;
    }

}
