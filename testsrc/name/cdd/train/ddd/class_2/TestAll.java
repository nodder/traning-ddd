package name.cdd.train.ddd.class_2;

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
        suite.addTestSuite(TimesTest.class);
        suite.addTestSuite(ToBuzzTest.class);
        suite.addTestSuite(ToFizzTest.class);
        suite.addTestSuite(ToHazzTest.class);
        suite.addTestSuite(ToWhizzTest.class);
        suite.addTestSuite(RuleTest.class);
        return suite;
    }
}
