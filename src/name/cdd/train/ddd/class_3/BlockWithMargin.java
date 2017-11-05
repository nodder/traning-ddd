package name.cdd.train.ddd.class_3;

import java.awt.Container;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;

public class BlockWithMargin implements Component
{
    private Component[] components;
    private int rowNum;
    private int colNum;
    private float hRatio;
    private float vRatio;

    public BlockWithMargin(Component[] components, int rowNum, int colNum, float hRatio, float vRatio)
    {
        this.components = components;
        this.rowNum = rowNum;
        this.colNum = colNum;
        this.hRatio = hRatio;
        this.vRatio = vRatio;
    }

    @Override
    public Component at(int x, int y, int width, int height)
    {
        return locate().at(x, y, width, height);
    }

    private Component locate()
    {
        Component[] result = toCenter() ;
        return new Block(result, rowNum, colNum);
    }

    private Component[] toCenter()
    {
        return FluentIterable.from(Lists.newArrayList(components)).transform(new Function<Component, Component>()
        {
            @Override
            public Component apply(Component com)
            {
                return new Center(com, hRatio, vRatio);
            }
        }).toArray(Component.class);
    }

    @Override
    public void in(Container container)
    {
        for(Component com : components)
        {
            com.in(container);
        }
    }

}
