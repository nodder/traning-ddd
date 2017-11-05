package name.cdd.train.ddd.selftrain.train_1;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests
{

    public static Test suite()
    {
        TestSuite suite = new TestSuite(AllTests.class.getName());
        //$JUnit-BEGIN$
        suite.addTestSuite(AtomicRuleTest.class);
        suite.addTestSuite(RuleSpecTest.class);
        //$JUnit-END$
        return suite;
    }

}
