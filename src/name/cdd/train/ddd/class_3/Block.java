package name.cdd.train.ddd.class_3;

import static name.cdd.train.ddd.class_3.LayoutTool.empty;
import static name.cdd.train.ddd.class_3.LayoutTool.hSeq;
import static name.cdd.train.ddd.class_3.LayoutTool.vSeq;

import java.awt.Container;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;

public class Block implements Component
{
    private Component[] components;
    private int rowNum;
    private int colNum;

    public Block(Component[] components, int rowNum, int colNum)
    {
        this.components = components;
        this.rowNum = rowNum;
        this.colNum = colNum;
    }

    @Override
    public Component at(int x, int y, int width, int height)
    {
        return locate().at(x, y, width, height);
    }

    private Component locate()
    {
        Component[][] completed = formalize(components);
        
        Component[] hSeqs = arrayWithHSeqs(completed);
        
        return vSeq(hSeqs);
    }
    
    private Component[][] formalize(Component[] components)
    {
        Component[][] result = new Component[rowNum][colNum];
        
        for(int i = 0; i < rowNum * colNum; i++)
        {
            int row = i / colNum;
            int col = i % colNum;
            
            result[row][col] = i < components.length ? components[i] : empty();
        }
        
        return result;
    }

    private Component[] arrayWithHSeqs(Component[][] components)
    {
        return FluentIterable.from(Lists.newArrayList(components)).transform(new Function<Component[], Component>()
        {
            @Override
            public Component apply(Component[] input)
            {
                return hSeq(input);
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
