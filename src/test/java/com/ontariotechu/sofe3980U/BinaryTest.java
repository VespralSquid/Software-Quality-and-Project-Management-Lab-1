package com.ontariotechu.sofe3980U;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for Binary class.
 */
public class BinaryTest 
{
    /**
     * Test The constructor with a valid binary vallue
     */
    @Test
    public void normalConstructor()
    {
		Binary binary=new Binary("1001001");
        assertTrue( binary.getValue().equals("1001001"));
    }
    /**
     * Test The constructor with an invalid binary value of out-of-range digits
     */
    @Test
    public void constructorWithInvalidDigits()
    {
		Binary binary=new Binary("1001001211");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * Test The constructor with an invalid binary value of alphabetic characters
     */
    @Test
    public void constructorWithInvalidChars()
    {
		Binary binary=new Binary("1001001A");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * Test The constructor with an invalid binary value that has a sign
     */
    @Test
    public void constructorWithNegativeSign()
    {
		Binary binary=new Binary("-1001001");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * T	est The constructor with a zero tailing valid binary value
     */
    @Test
    public void constructorWithZeroTailing()
    {
		Binary binary=new Binary("00001001");
        assertTrue( binary.getValue().equals("1001"));
    }
    /**
     * Test The constructor with an empty string
     */
    @Test
    public void constructorEmptyString()
    {
		Binary binary=new Binary("");
        assertTrue( binary.getValue().equals("0"));
    }
	/**
     * Test The add functions with two binary numbers of the same length
     */
    @Test
    public void add()
    {
		Binary binary1=new Binary("1000");
		Binary binary2=new Binary("1111");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("10111"));
    }
	/**
     * Test The add functions with two binary numbers, the length of the first argument is less than the second
     */
    @Test
    public void add2()
    {
		Binary binary1=new Binary("1010");
		Binary binary2=new Binary("11");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1101"));
    }
	/**
     * Test The add functions with two binary numbers, the length of the first argument is greater than the second
     */
    @Test
    public void add3()
    {
		Binary binary1=new Binary("11");
		Binary binary2=new Binary("1010");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1101"));
    }
	/**
     * Test The add functions with a binary numbers with zero
     */
    @Test
    public void add4()
    {
		Binary binary1=new Binary("0");
		Binary binary2=new Binary("1010");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1010"));
    }
	/**
     * Test The add functions with two zeros
     */
    @Test
    public void add5()
    {
		Binary binary1=new Binary("0");
		Binary binary2=new Binary("0");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("0"));
    }

    //Test code for the Design section starts here ---  

    //Series of tests for the OR function
    @Test
    public void orLengthEqual(){
        Binary x = new Binary("1100");
        Binary y = new Binary("1010");
        Binary result = Binary.OR(x, y);
        assertTrue("1110".equals(result.getValue()));
    }
    @Test
    public void orLengthDiff(){
        Binary x = new Binary("101");
        Binary y = new Binary("1010");
        Binary result = Binary.OR(x, y);
        assertTrue("1111".equals(result.getValue()));
    }

    @Test
    public void orWithZero(){
        Binary x = new Binary("0");
        Binary y = new Binary("1011");
        Binary result = Binary.OR(x, y);
        assertTrue("1011".equals(result.getValue()));
    }

    //Series of tests for the AND function
    @Test
    public void andLengthEqual(){
        Binary x = new Binary("1100");
        Binary y = new Binary("1010");
        Binary result = Binary.AND(x, y);
        assertTrue("1000".equals(result.getValue()));
    }

    @Test
    public void andLengthDiff(){
        Binary x = new Binary("101");
        Binary y = new Binary("1010");
        Binary result = Binary.AND(x, y);
        assertTrue("0".equals(result.getValue()));
    }

    @Test
    public void andWithZero(){
        Binary x = new Binary("0");
        Binary y = new Binary("1011");
        Binary result = Binary.AND(x, y);
        assertTrue("0".equals(result.getValue()));
    }

    //Series of tests for the Multiply function
    @Test
    public void MultiplyTest(){
        Binary x = new Binary("1010");
        Binary y = new Binary("1111");
        Binary result = Binary.Multiply(x, y);
        assertTrue(result.getValue().equals("10010110"));
    }

    @Test
    public void multiplyWithOne(){
        Binary x = new Binary("110101");
        Binary y = new Binary("1");
        Binary result = Binary.Multiply(x, y);
        assertTrue(result.getValue().equals("110101"));
    }

    @Test
    public void multiplyWithZero(){
        Binary x = new Binary("0");
        Binary y = new Binary("1011");
        Binary result = Binary.Multiply(x, y);
        assertTrue(result.getValue().equals("0"));
    }
}
