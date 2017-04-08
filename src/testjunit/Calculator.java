package testjunit;

import org.junit.Test;

public class Calculator
{

    /**
     * 加法
     * @param a
     * @param b
     * @return
     */
    public Double add(double a, double b){
        return a + b;
    }
    
    /**
     * 减法
     * @param a
     * @param b
     * @return
     */
    public Double subtract(double a, double b){
        return a - b;
    }
    public static void main(String[] args)
    {
        Calculator c = new Calculator();
        System.out.println(c.add(-10, -11));
    }

}
