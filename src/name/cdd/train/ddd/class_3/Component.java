package name.cdd.train.ddd.class_3;

import java.awt.Container;

public interface Component
{
    Component at(int x, int y, int width, int height);
    
    void in(Container container);
}
