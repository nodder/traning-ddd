package name.cdd.train.ddd.class_3;

import java.awt.Container;

public abstract class BaseComponent implements Component
{
    protected java.awt.Component com;

    public BaseComponent(java.awt.Component com)
    {
        this.com = com;
    }
    
    @Override
    public Component at(int x, int y, int width, int height)
    {
        com.setBounds(x, y, width, height);
        return this;
    }

    @Override
    public void in(Container container)
    {
        container.add(com);
    }
}
