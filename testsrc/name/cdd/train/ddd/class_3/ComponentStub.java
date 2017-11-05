package name.cdd.train.ddd.class_3;

import java.awt.Container;

public class ComponentStub implements Component
{
    int x;
    int y;
    int width;
    int height;
    boolean in;

    @Override
    public Component at(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        return this;
    }

    @Override
    public void in(Container container)
    {
        this.in = true;
    }

}
