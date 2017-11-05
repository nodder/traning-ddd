package name.cdd.train.ddd.class_3;

import java.awt.Container;

public class Empty implements Component
{
    @Override
    public Component at(int x, int y, int width, int height)
    {
        return this;
    }

    @Override
    public void in(Container container)
    {
    }
}
