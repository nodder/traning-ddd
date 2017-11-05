package name.cdd.train.ddd.class_3;

import java.awt.Container;

import junit.framework.TestCase;

public class BlockWithMarginTest extends TestCase
{
    private static final int TOLERANCE = 1;
    
    private ComponentStub a;
    private ComponentStub b;
    private ComponentStub c;
    private ComponentStub d;
    
    private BlockWithMargin block;
    
    @Override
    protected void setUp() throws Exception
    {
        a = new ComponentStub();
        b = new ComponentStub();
        c = new ComponentStub();
        d = new ComponentStub();
        
        block = new BlockWithMargin(new Component[] {a, b, c, d}, 2, 3, 0.1f, 0.2f);
    }
    
    public void testAt()
    {
        block.at(100, 10, 300, 60);
        
        assertWithTolerance(110, a.x);
        assertWithTolerance(16, a.y);
        assertWithTolerance(80, a.width);
        assertWithTolerance(18, a.height);
        
        assertWithTolerance(210, b.x);
        assertWithTolerance(16, b.y);
        assertWithTolerance(80, b.width);
        assertWithTolerance(18, b.height);
        
        assertWithTolerance(310, c.x);
        assertWithTolerance(16, c.y);
        assertWithTolerance(80, c.width);
        assertWithTolerance(18, c.height);
        
        assertWithTolerance(110, d.x);
        assertWithTolerance(46, d.y);
        assertWithTolerance(80, d.width);
        assertWithTolerance(18, d.height);
    }
    
    public void testIn()
    {
        Container container = new Container();
        
        block.in(container);
        
        assertTrue(a.in);
        assertTrue(b.in);
        assertTrue(c.in);
        assertTrue(d.in);
    }
    
    private void assertWithTolerance(int expected, int actual)
    {
        assertTrue(Math.abs(actual - expected) <= TOLERANCE);
    }
}
