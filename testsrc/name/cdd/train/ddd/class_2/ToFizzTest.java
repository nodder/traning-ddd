package name.cdd.train.ddd.class_2;

import junit.framework.TestCase;

public class ToFizzTest extends TestCase
{
    public void test_toFizz()
    {
        ToFizz toFizz = new ToFizz();
        assertEquals("Fizz", toFizz.act(3));
        assertEquals("Fizz", toFizz.act(6));
    }
}
