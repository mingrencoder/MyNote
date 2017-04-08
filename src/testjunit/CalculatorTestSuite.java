package testjunit;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * 通过代码方式创建TestSuit测试套件
 * @author jikai
 *
 */
public class CalculatorTestSuite extends TestCase
{

    public static Test suite()
    {
        TestSuite suite = new TestSuite(CalculatorTestSuite.class.getName());
        //$JUnit-BEGIN$
        suite.addTest(new JUnit4TestAdapter(CalculatorTest.class));
        suite.addTest(new JUnit4TestAdapter(CalculatorTest2.class));
        //$JUnit-END$
        return suite;
    }

}
