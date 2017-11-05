package name.cdd.train.ddd.class_3;

import static name.cdd.train.ddd.class_3.LayoutTool.beside;
import static name.cdd.train.ddd.class_3.LayoutTool.hSeq;

import java.awt.Container;

public class HSeq implements Component
{
    private Component[] components;

    public HSeq(Component...components)
    {
        this.components = components;
    }

    @Override
    public Component at(int x, int y, int width, int height)
    {
        return locate().at(x, y, width, height);
    }

    private Component locate()
    {
        if(components.length == 1)
        {
            return components[0];
        }
        
        return beside(components[0], hSeq(slice(components, 1, components.length - 1)), 1.0f/components.length);
    }

    private  Component[] slice(Component[] components, int start, int length)
    {
        Component[] destComponets = new Component[length];
        System.arraycopy(components, start, destComponets, 0, length);
        return destComponets;
    }

    @Override
    public void in(final Container container)
    {
        for(Component com : components)
        {
            com.in(container);
        }
    }
}
