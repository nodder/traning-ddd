package name.cdd.train.ddd.class_3;

import java.awt.Container;

import junit.framework.TestCase;

public class CenterTest extends TestCase
{
    private static final int TOLERANCE = 1;
    
    private ComponentStub a;
    private Center center;
    
    @Override
    protected void setUp() throws Exception
    {
        a = new ComponentStub();
        center = new Center(a, 0.2f, 0.1f);
    }
    
    public void testAt()
    {
        center.at(100, 10, 300, 60);
        
        assertWithTolerance(160, a.x);
        assertWithTolerance(16, a.y);
        assertWithTolerance(180, a.width);
        assertWithTolerance(48, a.height);
    }
    
    public void testIn()
    {
        Container container = new Container();
        
        center.in(container);
        
        assertTrue(a.in);
    }
    
    private void assertWithTolerance(int expected, int actual)
    {
        assertTrue(Math.abs(actual - expected) <= TOLERANCE);
    }
}
