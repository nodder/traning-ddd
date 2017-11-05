package name.cdd.train.ddd.class_3;

import java.awt.Container;

import junit.framework.TestCase;

public class BesideTest extends TestCase
{
    private static final int TOLERANCE = 1;
    
    private ComponentStub a;
    private ComponentStub b;

    private Beside beside;
    
    @Override
    protected void setUp() throws Exception
    {
        a = new ComponentStub();
        b = new ComponentStub();
        beside = new Beside(a, b, 0.8f);
    }
    
    public void testAt()
    {
        beside.at(10, 20, 300, 60);
        
        assertWithTolerance(10, a.x);
        assertWithTolerance(20, a.y);
        assertWithTolerance(240, a.width);
        assertWithTolerance(60, a.height);
        
        assertWithTolerance(250, b.x);
        assertWithTolerance(20, b.y);
        assertWithTolerance(60, b.width);
        assertWithTolerance(60, b.height);
    }

    public void testIn()
    {
        Container container = new Container();
        
        beside.in(container);
        
        assertTrue(a.in);
        assertTrue(b.in);
    }
    
    private void assertWithTolerance(int expected, int actual)
    {
        assertTrue(Math.abs(actual - expected) <= TOLERANCE);
    }
}
