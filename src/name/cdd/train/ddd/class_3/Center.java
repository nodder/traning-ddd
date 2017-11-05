package name.cdd.train.ddd.class_3;

import java.awt.Container;

import static name.cdd.train.ddd.class_3.LayoutTool.*;

public class Center implements Component
{
    private Component com;
    private float ratioWidth;
    private float ratioHeight;

    public Center(Component com, float ratioWidth, float ratioHeight)
    {
        this.com = com;
        this.ratioWidth = ratioWidth;
        this.ratioHeight = ratioHeight;
    }

    @Override
    public Component at(int x, int y, int width, int height)
    {
        return locate().at(x, y, width, height);
    }

    private Component locate()
    {
        Component widthCom = beside(empty(), beside(com, empty(),(1-2 * ratioWidth)/(1-ratioWidth)), ratioWidth);
        return above(empty(), above(widthCom, empty(),(1-2 * ratioHeight)/(1-ratioHeight)), ratioHeight);
    }

    @Override
    public void in(Container container)
    {
        com.in(container);
    }

}
