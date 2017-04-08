package testjunit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 通过注解方式创建TestSuit测试套件，更加方便
 * @author jikai
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ CalculatorTest.class, CalculatorTest2.class, CalculatorTestSuite.class })
public class CalculatorTestSuiteByAnnotation
{

}
