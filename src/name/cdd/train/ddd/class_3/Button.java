package name.cdd.train.ddd.class_3;

import javax.swing.JButton;

public class Button extends BaseComponent
{
    public Button()
    {
        super(new JButton());
    }
    
    public Component title(String text)
    {
        ((JButton)this.com).setText(text);
        return this;
    }
}
