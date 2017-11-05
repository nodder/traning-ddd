package name.cdd.train.ddd.class_3;

import java.awt.Container;

import junit.framework.TestCase;

public class BlockTest extends TestCase
{
    private static final int TOLERANCE = 1;
    
    private ComponentStub a;
    private ComponentStub b;
    private ComponentStub c;
    private ComponentStub d;
    
    private Block block;
    
    @Override
    protected void setUp() throws Exception
    {
        a = new ComponentStub();
        b = new ComponentStub();
        c = new ComponentStub();
        d = new ComponentStub();
        
        block = new Block(new Component[] {a, b, c, d}, 2, 3);
    }
    
    public void testAt()
    {
        block.at(100, 10, 300, 60);
        
        assertWithTolerance(100, a.x);
        assertWithTolerance(10, a.y);
        assertWithTolerance(100, a.width);
        assertWithTolerance(30, a.height);
        
        assertWithTolerance(200, b.x);
        assertWithTolerance(10, b.y);
        assertWithTolerance(100, b.width);
        assertWithTolerance(30, b.height);
        
        assertWithTolerance(300, c.x);
        assertWithTolerance(10, c.y);
        assertWithTolerance(100, c.width);
        assertWithTolerance(30, c.height);
        
        assertWithTolerance(100, d.x);
        assertWithTolerance(40, d.y);
        assertWithTolerance(100, d.width);
        assertWithTolerance(30, d.height);
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
