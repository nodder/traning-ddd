package name.cdd.train.ddd.class_3;

import java.awt.Container;

import junit.framework.TestCase;

public class HSeqTest extends TestCase
{
    private static final int TOLERANCE = 1;
    
    private ComponentStub a;
    private ComponentStub b;
    private ComponentStub c;
    private HSeq hSeq;
    
    @Override
    protected void setUp() throws Exception
    {
        a = new ComponentStub();
        b = new ComponentStub();
        c = new ComponentStub();
        
        hSeq = new HSeq(a, b, c);
    }
    
    public void testAt()
    {
        hSeq.at(100, 10, 300, 60);
        
        assertWithTolerance(100, a.x);
        assertWithTolerance(10, a.y);
        assertWithTolerance(100, a.width);
        assertWithTolerance(60, a.height);
        
        assertWithTolerance(200, b.x);
        assertWithTolerance(10, b.y);
        assertWithTolerance(100, b.width);
        assertWithTolerance(60, b.height);
        
        assertWithTolerance(300, c.x);
        assertWithTolerance(10, c.y);
        assertWithTolerance(100, c.width);
        assertWithTolerance(60, c.height);
    }
    
    public void testIn()
    {
        Container container = new Container();
        hSeq.in(container);
        
        assertTrue(a.in);
        assertTrue(b.in);
        assertTrue(c.in);
    }
    
    private void assertWithTolerance(int expected, int actual)
    {
        assertTrue(Math.abs(actual - expected) <= TOLERANCE);
    }
}
