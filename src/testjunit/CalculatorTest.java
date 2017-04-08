package testjunit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * TestCase测试用例类
 * @author jikai
 *
 */
public class CalculatorTest
{

    //定义Calculator对象
    Calculator cal;
    
    @Before
    public void init1()
    {
        cal = new Calculator();
        System.out.println("---------------------------");
        System.out.println("init!");
        assertNotNull(cal);
        System.out.println("notNull!");
    }

    @Test
    public void testAddPositive()
    {
        System.out.println(cal.add(10, 11));
        //两种方式判断结果是否正确
        assertEquals(Double.valueOf(21), cal.add(10, 11));
        assertTrue(21 == cal.add(10, 11));
    }
    
    @Test
    public void testAddNegetive()
    {
        System.out.println(cal.add(-10, -11));
        //两种方式判断结果是否正确
        assertEquals(Double.valueOf(-21), cal.add(-10, -11));
    }

    @Test
    public void testSubtract()
    {
        System.out.println(cal.subtract(10, 11));
    }

    /**
     * 为不影响其他测试，对测试对象清理
     */
    @After
    public void exit(){
        cal = null;
        System.out.println("exit!");
        System.out.println("---------------------------");
    }
}
