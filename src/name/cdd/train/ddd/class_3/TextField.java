package name.cdd.train.ddd.class_3;

import java.awt.Container;

import javax.swing.JTextField;

public class TextField implements Component
{
    private JTextField txt = new JTextField();

    @Override
    public Component at(int x, int y, int width, int height)
    {
        txt.setBounds(x, y, width, height);
        return this;
    }

    @Override
    public void in(Container container)
    {
        container.add(txt);
    }
}
