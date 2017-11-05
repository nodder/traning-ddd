package name.cdd.train.ddd.class_3;

import java.awt.Container;

public class Beside implements Component
{
    private Component left;
    private Component right;
    private float ratio;

    public Beside(Component left, Component right, float ratio)
    {
        this.left = left;
        this.right = right;
        this.ratio = ratio;
    }

    @Override
    public Component at(int x, int y, int width, int height)
    {
        final int leftLength = (int)(width * ratio);
        
        left.at(x, y, leftLength, height);
        right.at(x + leftLength, y, width - leftLength, height);
        return this;
    }

    @Override
    public void in(Container container)
    {
        left.in(container);
        right.in(container);
    }

}
