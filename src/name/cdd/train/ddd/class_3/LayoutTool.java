package name.cdd.train.ddd.class_3;

public class LayoutTool
{
    public static Button button()
    {
        return new Button();
    }
    
    public static TextField textField()
    {
        return new TextField();
    }
    
    public static Component beside(Component c1, Component c2, float ratio)
    {
        return new Beside(c1, c2, ratio);
    }
    
    public static Component above(Component c1, Component c2, float ratio)
    {
        return new Above(c1, c2, ratio);
    }
    
    public static Component empty()
    {
        return new Empty();
    }
    
    public static Component center(Component com, float ratioWidth, float ratioHeight)
    {
        return new Center(com, ratioWidth, ratioHeight);
    }
    
    public static Component hSeq(Component...components)
    {
        return new HSeq(components);
    }
    
    public static Component vSeq(Component...components)
    {
        return new VSeq(components);
    }
    
    public static Component block(Component[] components, int rowNum, int colNum)
    {
        return new Block(components, rowNum, colNum);
    }
    
    public static Component blockWithMargin(Component[] components, int rowNum, int colNum, float hRatio, float vRatio)
    {
        return new BlockWithMargin(components, rowNum, colNum, hRatio, vRatio);
    }
}
