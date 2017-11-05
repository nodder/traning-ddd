package name.cdd.train.ddd.class_2;

public class DefaultAction implements Action
{
    @Override
    public String act(int input)
    {
        return Integer.toString(input);
    }

}
