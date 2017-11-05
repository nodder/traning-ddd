package name.cdd.train.ddd.exercise;

import junit.framework.TestCase;

public class CountingProcessTest extends TestCase
{
    private CountingProcess cp = new CountingProcess();
    
    public void testSingleCount()
    {
        assertEquals("1", cp.processNumber(1));
        assertEquals("Fizz", cp.processNumber(3));
        assertEquals("Buzz", cp.processNumber(5));
        assertEquals("Whizz", cp.processNumber(7));

        assertEquals("FizzBuzz", cp.processNumber(15));
        assertEquals("FizzWhizz", cp.processNumber(21));
        assertEquals("BuzzWhizz", cp.processNumber(70));

        assertEquals("FizzBuzzWhizz", cp.processNumber(210));

        /** 测试“包含3则输出Fizz”的规则 */
        assertEquals("Fizz", cp.processNumber(13));
        assertEquals("Fizz", cp.processNumber(35));
    }
    
    public void test100Counts()
    {
        int[] inputs = assemble100Inputs();
        assertEquals(expectedOutputForCounting100(), cp.processNumbers(inputs));
    }

    private String expectedOutputForCounting100()
    {
        return "[1, 2, Fizz, 4, Buzz, Fizz, Whizz, 8, Fizz, Buzz, 11, Fizz, Fizz, Whizz, FizzBuzz, 16, 17, Fizz, 19, Buzz, "
              + "FizzWhizz, 22, Fizz, Fizz, Buzz, 26, Fizz, Whizz, 29, Fizz, Fizz, Fizz, Fizz, Fizz, Fizz, Fizz, Fizz, Fizz, Fizz, Buzz, "
              + "41, FizzWhizz, Fizz, 44, FizzBuzz, 46, 47, Fizz, Whizz, Buzz, Fizz, 52, Fizz, Fizz, Buzz, Whizz, Fizz, 58, 59, FizzBuzz, "
              + "61, 62, Fizz, 64, Buzz, Fizz, 67, 68, Fizz, BuzzWhizz, 71, Fizz, Fizz, 74, FizzBuzz, 76, Whizz, Fizz, 79, Buzz, "
              + "Fizz, 82, Fizz, FizzWhizz, Buzz, 86, Fizz, 88, 89, FizzBuzz, Whizz, 92, Fizz, 94, Buzz, Fizz, 97, Whizz, Fizz, Buzz]";
    }

    private int[] assemble100Inputs()
    {
        int[] rtnData = new int[100];
        for(int i = 0; i < rtnData.length; i++)
        {
            rtnData[i] = i + 1;
        }
        return rtnData;
    }
}
