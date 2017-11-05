package name.cdd.train.ddd.class_1;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @description 
 * @see    
 * @author      ChenDuoduo
 * @since       1.0
 * @date        
 */
public class TestAll
{
    public static Test suite()
    {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(ListAppTest.class);
        suite.addTestSuite(ListCalcTest.class);
        suite.addTestSuite(ListToolTest.class);
        return suite;
    }
}
