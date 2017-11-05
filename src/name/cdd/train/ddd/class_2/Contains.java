package name.cdd.train.ddd.class_2;

public class Contains implements Predication
{
    private int key;

    public Contains(int key)
    {
        this.key = key;
    }

    @Override
    public boolean predicate(int input)
    {
        return Integer.toString(input).contains(Integer.toString(key));
    }

}
