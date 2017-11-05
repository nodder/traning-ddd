package name.cdd.train.ddd.class_2;

import junit.framework.TestCase;

public class ToBuzzTest extends TestCase
{
    public void test_toBuzz()
    {
        ToBuzz toBuzz = new ToBuzz();
        assertEquals("Buzz", toBuzz.act(5));
        assertEquals("Buzz", toBuzz.act(10));
    }
}
