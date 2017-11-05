package name.cdd.train.ddd.class_3;

import java.awt.Container;

public class Above implements Component
{
    private Component a;
    private Component b;
    private float ratio;

    public Above(Component a, Component b, float ratio)
    {
        this.a = a;
        this.b = b;
        this.ratio = ratio;
    }

    @Override
    public Component at(int x, int y, int width, int height)
    {
        final int aHeight = (int)(height * ratio);
        
        this.a.at(x, y, width, aHeight);
        this.b.at(x, y + aHeight, width, height - aHeight);
        
        return this;
    }

    @Override
    public void in(Container container)
    {
        this.a.in(container);
        this.b.in(container);
    }

}
