package name.cdd.train.ddd.class_1;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class ListAppTest extends TestCase
{
    private ListApp listApp = null;
    
    @Override
    protected void setUp()
    {
        listApp = new ListApp();
    }
    
    public void testDouble()
    {
        List<Integer> expectedResult = assembleList(2, 4, 6);
        assertList(expectedResult, listApp.doubleElements(assembleList(1, 2, 3)));
    }
    
    public void testPresent()
    {
        List<String> expectedResult = assembleList("1", "2","3");
        assertList(expectedResult, listApp.presentElements(assembleList(1, 2, 3)));
    }
    
    public void testOdds()
    {
        List<Integer> expectedResult = assembleList(1, 3);
        assertList(expectedResult, listApp.pickoutOdds(assembleList(1, 2, 3, 4)));
    }
    
    public void testEvens()
    {
        List<Integer> expectedResult = assembleList(2, 4);
        assertList(expectedResult, listApp.pickoutEvens(assembleList(1, 2, 3, 4)));
    }
    
    public void testSum()
    {
        assertEquals(7, listApp.sumElements(assembleList(1, 2, 4)));
    }
    
    public void testProduct()
    {
        assertEquals(8, listApp.productElements(assembleList(1, 2, 4)));
    }

    private <T> void assertList(List<T> expected, List<T> actual)
    {
        assertEquals(expected.size(), actual.size());
        
        for(int i = 0; i < expected.size(); i++)
        {
            assertEquals(expected.get(i), actual.get(i));
        }
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
}
