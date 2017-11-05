package name.cdd.train.ddd.class_2;

import junit.framework.TestCase;

public class TimesTest extends TestCase
{
    public void test_time_3()
    {
        Times time3 = new Times(3);

        assertEquals(true, time3.predicate(3));
        assertEquals(true, time3.predicate(6));
        assertEquals(false, time3.predicate(1));
    }
    
    public void test_time_5()
    {
        Times times5 = new Times(5);
        
        assertEquals(true, times5.predicate(5));
        assertEquals(true, times5.predicate(10));
        assertEquals(false, times5.predicate(1));
    }
    
    public void test_time_7()
    {
        Times times7 = new Times(7);
        
        assertEquals(true, times7.predicate(7));
        assertEquals(true, times7.predicate(14));
        assertEquals(false, times7.predicate(1));
    }
}
