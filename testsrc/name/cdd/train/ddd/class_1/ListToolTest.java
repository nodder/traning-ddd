package name.cdd.train.ddd.class_1;

import java.util.ArrayList;
import java.util.List;

import name.cdd.train.ddd.class_1.ListOper.Predication;
import name.cdd.train.ddd.class_1.ListTool.ElementNotFoundException;

import junit.framework.TestCase;

public class ListToolTest extends TestCase
{
    public void testFind()
    {
        int actualResult = ListTool.find(new OddPredication(), assembleList(1, 2, 3, 4));
        assertEquals(1, actualResult);
        
        try
        {
            actualResult = ListTool.find(new OddPredication(), assembleList(2, 4));
            assertTrue(false);
        }
        catch(ElementNotFoundException e)
        {
            assertTrue(true);
        }
    }
    
    public void testAll()
    {
        assertEquals(true, ListTool.all(new OddPredication(), assembleList(1, 3, 5)));
        assertEquals(false, ListTool.all(new OddPredication(), assembleList(1, 2, 5)));
        assertEquals(false, ListTool.all(new OddPredication(), assembleList(2, 4)));
        assertEquals(true, ListTool.all(new OddPredication(), assembleList(new Integer[0])));
    }
    
    public void testAll2()
    {
        assertEquals(true, ListTool.all2(new OddPredication(), assembleList(1, 3, 5)));
        assertEquals(false, ListTool.all2(new OddPredication(), assembleList(1, 2, 5)));
        assertEquals(false, ListTool.all2(new OddPredication(), assembleList(2, 4)));
        assertEquals(true, ListTool.all2(new OddPredication(), assembleList(new Integer[0])));
    }
    
    public void testAny()
    {
        assertEquals(true, ListTool.any(new OddPredication(), assembleList(1, 3, 5)));
        assertEquals(true, ListTool.any(new OddPredication(), assembleList(1, 2, 5)));
        assertEquals(false, ListTool.any(new OddPredication(), assembleList(2, 4)));
        assertEquals(false, ListTool.any(new OddPredication(), assembleList(new Integer[0])));
    }
    
    private <T> List<T> assembleList(T... inputs)
    {
        List<T> outputs = new ArrayList<T>();
        
        for(T input : inputs)
        {
            outputs.add(input);
        }
        
        return outputs;
    }
    
    private class OddPredication implements Predication<Integer>
    {
        @Override
        public boolean predicate(Integer element)
        {
            return element % 2 == 1;
        }
    }
}
