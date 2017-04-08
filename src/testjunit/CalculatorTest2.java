package testjunit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 创建TestSuit测试套件
 * @author jikai
 *
 */
public class CalculatorTest2
{

    @Before
    public void setUp() throws Exception
    {
        System.out.println("---------------------------");
        System.out.println("init!");
    }

    @After
    public void tearDown() throws Exception
    {
        System.out.println("exit!");
        System.out.println("---------------------------");
    }

    @Test
    public void test()
    {
    }

}
