package name.cdd.train.ddd.class_2;

import junit.framework.TestCase;

public class ToWhizzTest extends TestCase
{
    public void test_toWhizz()
    {
        ToWhizz toWhizz = new ToWhizz();
        assertEquals("Whizz", toWhizz.act(7));
        assertEquals("Whizz", toWhizz.act(14));
    }
}
