package name.cdd.train.ddd.class_3;

import java.awt.Container;

import junit.framework.TestCase;

public class AboveTest extends TestCase
{
    private static final int TOLERANCE = 1;
    
    private ComponentStub a;
    private ComponentStub b;

    private Above above;
    
    @Override
    protected void setUp() throws Exception
    {
        a = new ComponentStub();
        b = new ComponentStub();
        above = new Above(a, b, 0.5f);
    }
    
    public void testAt()
    {
        above.at(10, 20, 300, 60);
        
        assertFloat(10, a.x);
        assertFloat(20, a.y);
        assertFloat(300, a.width);
        assertFloat(30, a.height);
        
        assertFloat(10, b.x);
        assertFloat(50, b.y);
        assertFloat(300, b.width);
        assertFloat(30, b.height);
    } 
    
    public void testIn()
    {
        Container container = new Container();
        
        above.in(container);
        
        assertTrue(a.in);
        assertTrue(b.in);
    }
    
    private void assertFloat(int expected, int actual)
    {
        assertTrue(Math.abs(actual - expected) <= TOLERANCE);
    }
}
