package name.cdd.train.ddd.class_3;

import java.awt.Container;

import junit.framework.TestCase;

public class VSeqTest extends TestCase
{
    private static final int TOLERANCE = 1;
    
    private ComponentStub a;
    private ComponentStub b;
    private ComponentStub c;
    private VSeq vSeq;
    
    @Override
    protected void setUp() throws Exception
    {
        a = new ComponentStub();
        b = new ComponentStub();
        c = new ComponentStub();
        
        vSeq = new VSeq(a, b, c);
    }
    
    public void testAt()
    {
        vSeq.at(100, 10, 300, 60);
        
        assertWithTolerance(100, a.x);
        assertWithTolerance(10, a.y);
        assertWithTolerance(300, a.width);
        assertWithTolerance(20, a.height);
        
        assertWithTolerance(100, b.x);
        assertWithTolerance(30, b.y);
        assertWithTolerance(300, b.width);
        assertWithTolerance(20, b.height);
        
        assertWithTolerance(100, c.x);
        assertWithTolerance(50, c.y);
        assertWithTolerance(300, c.width);
        assertWithTolerance(20, c.height);
    }
    
    public void testIn()
    {
        Container container = new Container();
        vSeq.in(container);
        
        assertTrue(a.in);
        assertTrue(b.in);
        assertTrue(c.in);
    }
    
    private void assertWithTolerance(int expected, int actual)
    {
        assertTrue(Math.abs(actual - expected) <= TOLERANCE);
    }
}
