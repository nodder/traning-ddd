package name.cdd.train.ddd.class_2;

import junit.framework.TestCase;

public class ToHazzTest extends TestCase
{
    public void test_toFizz()
    {
        ToHazz toHazz = new ToHazz();
        assertEquals("Hazz", toHazz.act(1));
        assertEquals("Hazz", toHazz.act(8));
        assertEquals("Hazz", toHazz.act(16));
    }
}
