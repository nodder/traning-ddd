package name.cdd.train.ddd.class_3;

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
        suite.addTestSuite(AboveTest.class);
        suite.addTestSuite(BesideTest.class);
        suite.addTestSuite(BlockTest.class);
        suite.addTestSuite(BlockWithMarginTest.class);
        suite.addTestSuite(CenterTest.class);
        suite.addTestSuite(VSeqTest.class);
        return suite;
    }
}
