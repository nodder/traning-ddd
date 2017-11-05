package name.cdd.train.ddd.class_1;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class ListCalcTest extends TestCase
{
    public void testSubSet()
    {
        assertEquals(true, ListCalc.isSubset(list(1, 3), list(1, 3, 5)));
        assertEquals(true, ListCalc.isSubset(list(1, 3, 5), list(1, 3, 5)));
        assertEquals(false, ListCalc.isSubset(list(1, 4), list(1, 5)));
        assertEquals(false, ListCalc.isSubset(list(1, 4, 6), list(1, 5, 6)));
        assertEquals(true, ListCalc.isSubset(list(new Integer[0]), list(1, 3, 5)));
        assertEquals(true, ListCalc.isSubset(list(new Integer[0]), list(new Integer[0])));
    }
    
    public void testSubSet2()
    {
        assertEquals(true, ListCalc.isSubset2(list(1, 3), list(1, 3, 5)));
        assertEquals(true, ListCalc.isSubset2(list(1, 3, 5), list(1, 3, 5)));
        assertEquals(false, ListCalc.isSubset2(list(1, 4), list(1, 5)));
        assertEquals(false, ListCalc.isSubset2(list(1, 4, 6), list(1, 5, 6)));
        assertEquals(true, ListCalc.isSubset2(list(new Integer[0]), list(1, 3, 5)));
        assertEquals(true, ListCalc.isSubset2(list(new Integer[0]), list(new Integer[0])));
    }
    
    public void testPermutate_elementLength0()
    {
        List<List<Integer>> expectedList = new ArrayList<List<Integer>>();
        assertList(expectedList, ListCalc.permutate(new ArrayList<Integer>(), 0));
    }
    
    @SuppressWarnings ("unchecked")
    public void testPermutate_elementLength1()
    {
        List<List<Integer>> expectedList = new ArrayList<List<Integer>>();
        assertList(expectedList, ListCalc.permutate(list(1), 0));
        
        expectedList = list(list(1));
        assertList(expectedList, ListCalc.permutate(list(1), 1));
    }
    
    @SuppressWarnings ("unchecked")
    public void testPermutate_elementLength2()
    {
        List<List<Integer>> expectedList = new ArrayList<List<Integer>>();
        assertList(expectedList, ListCalc.permutate(list(1, 3), 0));
        
        expectedList = list(list(1), list(3));
        assertList(expectedList, ListCalc.permutate(list(1, 3), 1));
        
        expectedList = list(list(3, 1), list(1, 3));
        assertList(expectedList, ListCalc.permutate(list(1, 3), 2));
    }
    
    @SuppressWarnings ("unchecked")
    public void testPermutate_elementLength3()
    {
        List<List<Integer>> expectedList = new ArrayList<List<Integer>>();
        assertList(expectedList, ListCalc.permutate(list(1, 3, 5), 0));
        
        expectedList = list(list(1), list(3), list(5));
        assertList(expectedList, ListCalc.permutate(list(1, 3, 5), 1));
        
        expectedList = list(list(3, 1), list(5, 1), 
                            list(1, 3), list(5, 3), 
                            list(1, 5), list(3, 5));
        assertList(expectedList, ListCalc.permutate(list(1, 3, 5), 2));
        
        expectedList = list(list(5, 3, 1), list(3, 5, 1), list(5, 1, 3), list(1, 5, 3), list(3, 1, 5), list(1, 3, 5));
        assertList(expectedList, ListCalc.permutate(list(1, 3, 5), 3));
    }
    
    @SuppressWarnings ("unchecked")
    public void testPermutate_elementLength4()
    {
        List<List<Integer>> expectedList = new ArrayList<List<Integer>>();
        assertList(expectedList, ListCalc.permutate(list(1, 3, 5, 7), 0));
        
        
        expectedList = list(list(1), list(3), list(5), list(7));
        assertList(expectedList, ListCalc.permutate(list(1, 3, 5, 7), 1));
        
        
        expectedList = list(list(3, 1), list(5, 1), list(7, 1), 
                            list(1, 3), list(5, 3), list(7, 3), 
                            list(1, 5), list(3, 5), list(7, 5),
                            list(1, 7), list(3, 7), list(5, 7));
        assertList(expectedList, ListCalc.permutate(list(1, 3, 5, 7), 2));
        
        
        expectedList = list(list(5, 3, 1), list(7, 3, 1), list(3, 5, 1), list(7, 5, 1), list(3, 7, 1), list(5, 7, 1),
                            list(5, 1, 3), list(7, 1, 3), list(1, 5, 3), list(7, 5, 3), list(1, 7, 3), list(5, 7, 3),
                            list(3, 1, 5), list(7, 1, 5), list(1, 3, 5), list(7, 3, 5), list(1, 7, 5), list(3, 7, 5),
                            list(3, 1, 7), list(5, 1, 7), list(1, 3, 7), list(5, 3, 7), list(1, 5, 7), list(3, 5, 7));
        assertList(expectedList, ListCalc.permutate(list(1, 3, 5, 7), 3));
        
        
        expectedList = list(list(7, 5, 3, 1), list(5, 7, 3, 1), list(7, 3, 5, 1), list(3, 7, 5, 1), list(5, 3, 7, 1), list(3, 5, 7, 1),
                            list(7, 5, 1, 3), list(5, 7, 1, 3), list(7, 1, 5, 3), list(1, 7, 5, 3), list(5, 1, 7, 3), list(1, 5, 7, 3),
                            list(7, 3, 1, 5), list(3, 7, 1, 5), list(7, 1, 3, 5), list(1, 7, 3, 5), list(3, 1, 7, 5), list(1, 3, 7, 5),
                            list(5, 3, 1, 7), list(3, 5, 1, 7), list(5, 1, 3, 7), list(1, 5, 3, 7), list(3, 1, 5, 7), list(1, 3, 5, 7));
        assertList(expectedList, ListCalc.permutate(list(1, 3, 5, 7), 4));
    }
    
    @SuppressWarnings ("unchecked")
    public void testCombinate()
    {
        List<List<Integer>> expectedList = new ArrayList<List<Integer>>();
        assertList(expectedList, ListCalc.combinate(list(1, 3, 5), 0));
        
        expectedList = list(list(1), list(3), list(5));
        assertList(expectedList, ListCalc.combinate(list(1, 3, 5), 1));
        
        expectedList = list(list(3, 1), list(5, 1), list(5, 3));
        assertList(expectedList, ListCalc.combinate(list(1, 3, 5), 2));
        
        expectedList = list(list(5, 3, 1));
        assertList(expectedList, ListCalc.combinate(list(1, 3, 5), 3));
    }
    
    private <T> List<T> list(T... inputs)
    {
        List<T> outputs = new ArrayList<T>();
        
        for(T input : inputs)
        {
            outputs.add(input);
        }
        
        return outputs;
    }
    
    private <T> void assertList(List<T> expected, List<T> actual)
    {
        assertEquals(expected.size(), actual.size());
        
        for(int i = 0; i < expected.size(); i++)
        {
            assertEquals(expected.get(i), actual.get(i));
        }
    }
}
