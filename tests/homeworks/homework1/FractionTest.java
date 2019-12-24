/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeworks.homework1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maus
 */
public class FractionTest {

    public FractionTest () {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setFractionFormat method, of class Fraction.
     */
    @Test
    public void testSetFractionFormat() {
        System.out.println("isFractionOrDecimal");
        //Startzustand
        Fraction.setFractionFormat(true);
        boolean expResult = true;
        boolean result = Fraction.isFractionFormat();
        assertEquals(expResult, result);
        Fraction.setFractionFormat(false);
        assertFalse(Fraction.isFractionFormat());
        Fraction.setFractionFormat(true);
        assertTrue(Fraction.isFractionFormat());
    }

    /**
     * Test of Constructor, of class Fraction.
     * @throws FractionException
     */
    @Test
    public void testFraction_1() throws FractionException {
        System.out.println("Constructor");
        Fraction instance = null;
        Fraction expResult = null;
        Fraction result = null;

        instance = new Fraction();
        assertEquals(new Fraction(0, 1), instance);
        assertEquals(new Fraction(0), instance);
        instance = new Fraction(12);
        expResult = new Fraction(23.345);
        result = new Fraction("12/15");
        assertEquals(new Fraction(12.0), instance);
        assertEquals(new Fraction(12, 1), instance);
        assertEquals(new Fraction(4669, 200), expResult);
        assertEquals(new Fraction("23.345"), expResult);
        assertEquals(new Fraction(4, 5), result);
        assertEquals(new Fraction(0.8), result);

    }

    @Test(expected = FractionException.class)
    public void testFraction_2() throws FractionException {
        System.out.println("Constructor2");
        Fraction expResult = new Fraction(5, 0);
    }

    @Test(expected = FractionException.class)
    public void testFraction_3() throws FractionException {
        System.out.println("Constructor3");
        Fraction expResult = new Fraction("");
    }

    /**
     * Test of add method, of class Fraction.
     * @throws FractionException
     */
    @Test
    public void testAdd() throws FractionException {
        System.out.println("add");
        Fraction b = new Fraction(0);
        Fraction instance = new Fraction();
        Fraction result = null;
        Fraction expResult = new Fraction(0.0);

        result = instance.add(b);
        assertEquals(expResult, result);
        result = instance.add(new Fraction(1));
        assertEquals(new Fraction(1.0), result);
        result = instance.add(new Fraction("1"));
        assertEquals(new Fraction(1.0), result);
        assertEquals(new Fraction(2.0), result.add(result));
        b = new Fraction(12, 23);
        result = instance.add(b);
        assertEquals(new Fraction(12, 23), result);
        result = b.add(new Fraction(1));
        assertEquals(new Fraction(35, 23), result);
        instance = new Fraction(23, 35);
        b = new Fraction(12, 40);
        result = instance.add(b);
        expResult = new Fraction(67, 70);
        assertEquals(expResult, result);
        instance = new Fraction(321, 56);
        b = new Fraction(123, 27);
        result = instance.add(b);
        expResult = new Fraction(5185, 504);
        assertEquals(expResult, result);

    }

    @Test(expected = FractionException.class)
    public void testAdd2() throws FractionException {
        System.out.println("add2");
        Fraction instance = new Fraction();
        Fraction result = null;

        result = instance.add(result);
    }

    /**
     * Test of sub method, of class Fraction.
     * @throws FractionException
     */
    @Test
    public void testSub() throws FractionException {
        System.out.println("sub");
        Fraction b = null;
        Fraction instance = new Fraction();
        Fraction expResult = new Fraction(-12.0);
        Fraction result = null;

        assertEquals(instance.sub(instance), instance);
        assertEquals(new Fraction(12), instance.sub(expResult));
        assertEquals(expResult, expResult.sub(instance));
        instance = new Fraction(-12, -45);
        b = new Fraction(-2.33);
        result = instance.sub(b);
        assertEquals(new Fraction(779, 300), result);
        assertEquals(new Fraction(0), instance.sub(instance));
        instance = new Fraction(12345, -4545);
        b = new Fraction(20);
        result = instance.sub(b);
        expResult = new Fraction(6883, -303);
        assertEquals(expResult, result);
        expResult = instance.sub(expResult);
        assertEquals(expResult, new Fraction(20));
        expResult = instance.sub(new Fraction(12.321));
        assertEquals(expResult, new Fraction(-4556263, 303000));
    }

    @Test(expected = FractionException.class)
    public void testSub2() throws FractionException {
        System.out.println("sub2");
        Fraction b = null;
        Fraction instance = new Fraction();
        Fraction result = null;

        result = instance.sub(b);
    }

    /**
     * Test of mul method, of class Fraction.
     * @throws FractionException
     */
    @Test
    public void testMul() throws FractionException {
        System.out.println("mul");
        Fraction b = null;
        Fraction instance = new Fraction();
        Fraction result;

        Fraction expResult = new Fraction(0, 1);
        result = instance.mul(expResult);
        assertEquals(expResult, result);
        result = instance.mul(new Fraction(10, 2));
        assertEquals(instance, result);
        b = new Fraction(-123, 345);
        instance = new Fraction(234, -456);
        result = b.mul(instance);
        assertEquals(new Fraction(1599, 8740), result);
        result = result.mul(instance);
        assertEquals(new Fraction(62361, -664240), result);
    }

    @Test(expected = FractionException.class)
    public void testMul2() throws FractionException {
        System.out.println("mul2");
        Fraction b = null;
        Fraction instance = new Fraction();
        Fraction result;

        result = instance.mul(b);
    }

    /**
     * Test of div method, of class Fraction.
     * @throws FractionException
     */
    @Test
    public void testDiv() throws FractionException {
        System.out.println("div");
        Fraction b = null;
        Fraction instance = new Fraction();
        Fraction expResult = new Fraction(1);
        Fraction result;

        assertEquals(instance.div(expResult), instance);
        b = new Fraction(23, 56);
        instance = new Fraction(5);
        result = b.div(instance);
        expResult = new Fraction(23, 280);
        assertEquals(expResult, result);
        result = expResult.div(b);
        assertEquals(new Fraction(1, 5), result);

    }

    @Test(expected = FractionException.class)
    public void testDiv2() throws FractionException {
        System.out.println("div");
        Fraction b = null;
        Fraction instance = new Fraction();
        Fraction expResult = new Fraction(1);
        Fraction result;

        b = expResult.div(instance);
    }

    @Test(expected = FractionException.class)
    public void testDiv3() throws FractionException {
        System.out.println("div3");
        Fraction b = null;
        Fraction expResult = new Fraction(1);
        Fraction result;

        b = expResult.div(null);
    }

    /**
     * Test of pow method, of class Fraction.
     * @throws FractionException
     */
    @Test
    public void testPow() throws FractionException {
        System.out.println("pow");
        int e = 0;
        Fraction instance = new Fraction();
        Fraction expResult = new Fraction(1);

        Fraction result = instance.pow(e);
        assertEquals(expResult, result);
        e = 10;
        result = instance.pow(e);
        assertEquals(instance, result);
        instance = new Fraction(-12, 34);
        e = -3;
        result = instance.pow(e);
        assertEquals(new Fraction(-4913, 216), result);
        e = 3;
        result = instance.pow(e);
        assertEquals(new Fraction(-216, 4913), result);
        result = new Fraction(2.45).pow(-5);
        assertEquals(new Fraction(3200000, 282475249), result);

    }

    @Test(expected = FractionException.class)
    public void testPow2() throws FractionException {
        System.out.println("pow2");
        int e = 0;
        Fraction instance = new Fraction();
        e = -10;
        instance = instance.pow(e);
    }

    /**
     * Test of addThis method, of class Fraction.
     * @throws FractionException
     */
    @Test
    public void testAddThis() throws FractionException {
        System.out.println("addThis");
        Fraction b = null;
        Fraction instance = new Fraction();
        Fraction expResult = new Fraction(1);

        instance.addThis(b);
        assertEquals(instance, new Fraction());
        instance.addThis(expResult);
        assertEquals(expResult, instance);
        b = new Fraction(12, 23);
        instance = new Fraction();
        instance.addThis(b);
        assertEquals(new Fraction(12, 23), instance);
        instance.addThis(new Fraction(1));
        assertEquals(new Fraction(35, 23), instance);
        instance = new Fraction(23, 35);
        b = new Fraction(12, 40);
        instance.addThis(b);
        expResult = new Fraction(67, 70);
        assertEquals(expResult, instance);
        instance = new Fraction(321, 56);
        b = new Fraction(123, 27);
        instance.addThis(b);
        expResult = new Fraction(5185, 504);
        assertEquals(expResult, instance);
    }

    /**
     * Test of subThis method, of class Fraction.
     * @throws FractionException
     */
    @Test
    public void testSubThis() throws FractionException {
        System.out.println("subThis");
        Fraction b = null;
        Fraction instance = new Fraction();
        Fraction expResult = new Fraction(0);

        instance.subThis(b);
        assertEquals(expResult, instance);

        instance = new Fraction();
        instance.subThis(expResult);
        assertEquals(expResult, instance);
        instance.subThis(expResult);
        assertEquals(expResult, instance);
        instance = new Fraction(-12, -45);
        b = new Fraction(-2.33);
        instance.subThis(b);
        assertEquals(new Fraction(779, 300), instance);
        instance.subThis(instance);
        assertEquals(new Fraction(0), instance);
        instance = new Fraction(12345, -4545);
        b = new Fraction(20);
        instance.subThis(b);
        expResult = new Fraction(6883, -303);
        assertEquals(expResult, instance);
        instance = new Fraction(12345, -4545);
        instance.subThis(expResult);
        assertEquals(instance, new Fraction(20));
        instance = new Fraction(12345, -4545);
        instance.subThis(new Fraction(12.321));
        assertEquals(instance, new Fraction(-4556263, 303000));
    }

    /**
     * Test of mulThis method, of class Fraction.
     * @throws FractionException
     */
    @Test
    public void testMulThis() throws FractionException {
        System.out.println("mulThis");
        Fraction b = null;
        Fraction instance = new Fraction();
        Fraction expResult = new Fraction(0);

        instance.mulThis(b);
        assertEquals(expResult, instance);
        instance.mulThis(expResult);
        assertEquals(expResult, instance);
        instance = new Fraction();
        expResult = new Fraction(10, 2);
        expResult.mulThis(instance);
        assertEquals(instance, expResult);
        b = new Fraction(-123, 345);
        instance = new Fraction(234, -456);
        b.mulThis(instance);
        expResult = new Fraction(1599, 8740);
        assertEquals(expResult, b);
        expResult.mulThis(instance);
        assertEquals(new Fraction(62361, -664240), expResult);
    }

    /**
     * Test of divThis method, of class Fraction.
     * @throws FractionException
     */
    @Test
    public void testDivThis() throws FractionException {
        System.out.println("divThis");
        Fraction b = null;
        Fraction instance = new Fraction();
        Fraction expResult = new Fraction(1);

        instance.divThis(b);
        assertEquals(instance, new Fraction());
        instance.divThis(expResult);
        assertEquals(instance, new Fraction());
        b = new Fraction(23, 56);
        instance = new Fraction(5);
        b.divThis(instance);
        expResult = new Fraction(23, 280);
        assertEquals(expResult, b);
        expResult.divThis(new Fraction(120, -69));
        assertEquals(new Fraction(-529, 11200), expResult);

    }

    @Test(expected = FractionException.class)
    public void testDivThis2() throws FractionException {
        System.out.println("divThis2");
        Fraction instance = new Fraction();
        Fraction expResult = new Fraction(0);

        instance.divThis(expResult);
    }

    /**
     * Test of powThis method, of class Fraction.
     * @throws FractionException
     */
    @Test
    public void testPowThis() throws FractionException {
        System.out.println("powThis");
        int e = 0;
        Fraction instance = new Fraction();
        Fraction expResult = new Fraction(1);

        instance.powThis(e);
        assertEquals(expResult, instance);
        e = 10;
        instance = new Fraction();
        instance.powThis(e);
        assertEquals(instance, new Fraction(0));
        instance = new Fraction(-12, 34);
        e = -3;
        instance.powThis(e);
        assertEquals(new Fraction(-4913, 216), instance);
        e = 3;
        instance = new Fraction(-12, 34);
        instance.powThis(e);
        assertEquals(new Fraction(-216, 4913), instance);
        instance = new Fraction(2.45);
        instance.powThis(-5);
        assertEquals(new Fraction(3200000, 282475249), instance);

    }

    @Test(expected = FractionException.class)
    public void testPowThis2() throws FractionException {
        System.out.println("powThis2");
        int e = -10;
        Fraction instance = new Fraction();

        instance.powThis(e);
    }
    
    /**
     * Test of toString method, of class Fraction.
     * @throws FractionException
     */
    @Test
    public void testToString() throws FractionException {
        System.out.println("toString");
        Fraction.setFractionFormat(true);
        Fraction instance = new Fraction();
        String expResult = "0/1";
        String result = instance.toString();
        assertEquals(expResult, result);
        instance = new Fraction(-12, -45);
        assertEquals(instance.toString(), "4/15");
        Fraction.setFractionFormat(false);
        assertEquals(instance.toString(), "0,267");
        instance = new Fraction();
        assertEquals(instance.toString(), "0,000");
        instance = new Fraction(-134);
        assertTrue(instance.toString().equals("-134,000"));
        Fraction.setFractionFormat(true);
        assertTrue(instance.toString().equals("-134/1"));
        instance = new Fraction(-12.45);
        assertEquals(instance.toString(), "-249/20");
        Fraction.setFractionFormat(false);
        assertEquals(instance.toString(), "-12,450");
    }

    /**
     * Test of isFractionFormat method, of class Fraction.
     */
    @Test
    public void testIsFractionFormat() {
        System.out.println("isFractionFormat");
        Fraction.setFractionFormat(true);
        boolean result = Fraction.isFractionFormat();
        assertTrue(result);
        Fraction.setFractionFormat(false);
        assertFalse(Fraction.isFractionFormat());
    }

    
    /**
     * Test of equals method, of class Fraction.
     * @throws FractionException
     */
    @Test
    public void testEquals() throws FractionException {
        System.out.println("equals");
        assertEquals(new Fraction(1), new Fraction(1.000));
        assertEquals(new Fraction("1"), new Fraction("1/1"));
        assertEquals(new Fraction("15/-12"), new Fraction(-5,4));
        assertEquals(new Fraction("-1.25"), new Fraction(5,-4));
        assertEquals(new Fraction("-1.25"), new Fraction(-1.2500));
    }

    /**
     * Test of greatestCommonFactor method, of class Fraction.
     */
    @Test
    public void testGreatestCommonFactor() {
        System.out.println("ggT");
        long result = Fraction.greatestCommonFactor(-12234, 2445);
        assertEquals(3, result);
        assertEquals(Fraction.greatestCommonFactor(-122345, -2445), 5);
        assertEquals(Fraction.greatestCommonFactor(5731630053L, -5737911553L), 12563);
        assertEquals(Fraction.greatestCommonFactor(256728, 2581918), 1126);
    }

    /**
     * Test of leastCommonMultiple method, of class Fraction.
     */
    @Test
    public void testLeastCommonMultiple() {
        System.out.println("kgV");
        assertEquals(Fraction.leastCommonMultiple(-1234, -64), 39488);
        assertEquals(Fraction.leastCommonMultiple(1234, -64), 39488);
        assertEquals(Fraction.leastCommonMultiple(-1234, 64), 39488);
        assertEquals(Fraction.leastCommonMultiple(12134, 624), 3785808);
        assertEquals(Fraction.leastCommonMultiple(2134, 1), 2134);
    }

}
