/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeworks.homework1.legacy;

import homeworks.homework1.legacy.FractionLegacy;
import homeworks.homework1.legacy.FractionLegacyException;
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
public class FractionLegacyTest {

    public FractionLegacyTest () {
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
        FractionLegacy.setFractionFormat(true);
        boolean expResult = true;
        boolean result = FractionLegacy.isFractionFormat();
        assertEquals(expResult, result);
        FractionLegacy.setFractionFormat(false);
        assertFalse(FractionLegacy.isFractionFormat());
        FractionLegacy.setFractionFormat(true);
        assertTrue(FractionLegacy.isFractionFormat());
    }

    /**
     * Test of Constructor, of class Fraction.
     * @throws FractionLegacyException
     */
    @Test
    public void testFraction_1() throws FractionLegacyException {
        System.out.println("Constructor");
        FractionLegacy instance = null;
        FractionLegacy expResult = null;
        FractionLegacy result = null;

        instance = new FractionLegacy();
        assertEquals(new FractionLegacy(0, 1), instance);
        assertEquals(new FractionLegacy(0), instance);
        instance = new FractionLegacy(12);
        expResult = new FractionLegacy(23.345);
        result = new FractionLegacy("12/15");
        assertEquals(new FractionLegacy(12.0), instance);
        assertEquals(new FractionLegacy(12, 1), instance);
        assertEquals(new FractionLegacy(4669, 200), expResult);
        assertEquals(new FractionLegacy("23.345"), expResult);
        assertEquals(new FractionLegacy(4, 5), result);
        assertEquals(new FractionLegacy(0.8), result);

    }

    @Test(expected = FractionLegacyException.class)
    public void testFraction_2() throws FractionLegacyException {
        System.out.println("Constructor2");
        FractionLegacy expResult = new FractionLegacy(5, 0);
    }

    @Test(expected = FractionLegacyException.class)
    public void testFraction_3() throws FractionLegacyException {
        System.out.println("Constructor3");
        FractionLegacy expResult = new FractionLegacy("");
    }

    /**
     * Test of add method, of class Fraction.
     * @throws FractionLegacyException
     */
    @Test
    public void testAdd() throws FractionLegacyException {
        System.out.println("add");
        FractionLegacy b = new FractionLegacy(0);
        FractionLegacy instance = new FractionLegacy();
        FractionLegacy result = null;
        FractionLegacy expResult = new FractionLegacy(0.0);

        result = instance.add(b);
        assertEquals(expResult, result);
        result = instance.add(new FractionLegacy(1));
        assertEquals(new FractionLegacy(1.0), result);
        result = instance.add(new FractionLegacy("1"));
        assertEquals(new FractionLegacy(1.0), result);
        assertEquals(new FractionLegacy(2.0), result.add(result));
        b = new FractionLegacy(12, 23);
        result = instance.add(b);
        assertEquals(new FractionLegacy(12, 23), result);
        result = b.add(new FractionLegacy(1));
        assertEquals(new FractionLegacy(35, 23), result);
        instance = new FractionLegacy(23, 35);
        b = new FractionLegacy(12, 40);
        result = instance.add(b);
        expResult = new FractionLegacy(67, 70);
        assertEquals(expResult, result);
        instance = new FractionLegacy(321, 56);
        b = new FractionLegacy(123, 27);
        result = instance.add(b);
        expResult = new FractionLegacy(5185, 504);
        assertEquals(expResult, result);

    }

    @Test(expected = FractionLegacyException.class)
    public void testAdd2() throws FractionLegacyException {
        System.out.println("add2");
        FractionLegacy instance = new FractionLegacy();
        FractionLegacy result = null;

        result = instance.add(result);
    }

    /**
     * Test of sub method, of class Fraction.
     * @throws FractionLegacyException
     */
    @Test
    public void testSub() throws FractionLegacyException {
        System.out.println("sub");
        FractionLegacy b = null;
        FractionLegacy instance = new FractionLegacy();
        FractionLegacy expResult = new FractionLegacy(-12.0);
        FractionLegacy result = null;

        assertEquals(instance.sub(instance), instance);
        assertEquals(new FractionLegacy(12), instance.sub(expResult));
        assertEquals(expResult, expResult.sub(instance));
        instance = new FractionLegacy(-12, -45);
        b = new FractionLegacy(-2.33);
        result = instance.sub(b);
        assertEquals(new FractionLegacy(779, 300), result);
        assertEquals(new FractionLegacy(0), instance.sub(instance));
        instance = new FractionLegacy(12345, -4545);
        b = new FractionLegacy(20);
        result = instance.sub(b);
        expResult = new FractionLegacy(6883, -303);
        assertEquals(expResult, result);
        expResult = instance.sub(expResult);
        assertEquals(expResult, new FractionLegacy(20));
        expResult = instance.sub(new FractionLegacy(12.321));
        assertEquals(expResult, new FractionLegacy(-4556263, 303000));
    }

    @Test(expected = FractionLegacyException.class)
    public void testSub2() throws FractionLegacyException {
        System.out.println("sub2");
        FractionLegacy b = null;
        FractionLegacy instance = new FractionLegacy();
        FractionLegacy result = null;

        result = instance.sub(b);
    }

    /**
     * Test of mul method, of class Fraction.
     * @throws FractionLegacyException
     */
    @Test
    public void testMul() throws FractionLegacyException {
        System.out.println("mul");
        FractionLegacy b = null;
        FractionLegacy instance = new FractionLegacy();
        FractionLegacy result;

        FractionLegacy expResult = new FractionLegacy(0, 1);
        result = instance.mul(expResult);
        assertEquals(expResult, result);
        result = instance.mul(new FractionLegacy(10, 2));
        assertEquals(instance, result);
        b = new FractionLegacy(-123, 345);
        instance = new FractionLegacy(234, -456);
        result = b.mul(instance);
        assertEquals(new FractionLegacy(1599, 8740), result);
        result = result.mul(instance);
        assertEquals(new FractionLegacy(62361, -664240), result);
    }

    @Test(expected = FractionLegacyException.class)
    public void testMul2() throws FractionLegacyException {
        System.out.println("mul2");
        FractionLegacy b = null;
        FractionLegacy instance = new FractionLegacy();
        FractionLegacy result;

        result = instance.mul(b);
    }

    /**
     * Test of div method, of class Fraction.
     * @throws FractionLegacyException
     */
    @Test
    public void testDiv() throws FractionLegacyException {
        System.out.println("div");
        FractionLegacy b = null;
        FractionLegacy instance = new FractionLegacy();
        FractionLegacy expResult = new FractionLegacy(1);
        FractionLegacy result;

        assertEquals(instance.div(expResult), instance);
        b = new FractionLegacy(23, 56);
        instance = new FractionLegacy(5);
        result = b.div(instance);
        expResult = new FractionLegacy(23, 280);
        assertEquals(expResult, result);
        result = expResult.div(b);
        assertEquals(new FractionLegacy(1, 5), result);

    }

    @Test(expected = FractionLegacyException.class)
    public void testDiv2() throws FractionLegacyException {
        System.out.println("div");
        FractionLegacy b = null;
        FractionLegacy instance = new FractionLegacy();
        FractionLegacy expResult = new FractionLegacy(1);
        FractionLegacy result;

        b = expResult.div(instance);
    }

    @Test(expected = FractionLegacyException.class)
    public void testDiv3() throws FractionLegacyException {
        System.out.println("div3");
        FractionLegacy b = null;
        FractionLegacy expResult = new FractionLegacy(1);
        FractionLegacy result;

        b = expResult.div(null);
    }

    /**
     * Test of pow method, of class Fraction.
     * @throws FractionLegacyException
     */
    @Test
    public void testPow() throws FractionLegacyException {
        System.out.println("pow");
        int e = 0;
        FractionLegacy instance = new FractionLegacy();
        FractionLegacy expResult = new FractionLegacy(1);

        FractionLegacy result = instance.pow(e);
        assertEquals(expResult, result);
        e = 10;
        result = instance.pow(e);
        assertEquals(instance, result);
        instance = new FractionLegacy(-12, 34);
        e = -3;
        result = instance.pow(e);
        assertEquals(new FractionLegacy(-4913, 216), result);
        e = 3;
        result = instance.pow(e);
        assertEquals(new FractionLegacy(-216, 4913), result);
        result = new FractionLegacy(2.45).pow(-5);
        assertEquals(new FractionLegacy(3200000, 282475249), result);

    }

    @Test(expected = FractionLegacyException.class)
    public void testPow2() throws FractionLegacyException {
        System.out.println("pow2");
        int e = 0;
        FractionLegacy instance = new FractionLegacy();
        e = -10;
        instance = instance.pow(e);
    }

    /**
     * Test of addThis method, of class Fraction.
     * @throws FractionLegacyException
     */
    @Test
    public void testAddThis() throws FractionLegacyException {
        System.out.println("addThis");
        FractionLegacy b = null;
        FractionLegacy instance = new FractionLegacy();
        FractionLegacy expResult = new FractionLegacy(1);

        instance.addThis(b);
        assertEquals(instance, new FractionLegacy());
        instance.addThis(expResult);
        assertEquals(expResult, instance);
        b = new FractionLegacy(12, 23);
        instance = new FractionLegacy();
        instance.addThis(b);
        assertEquals(new FractionLegacy(12, 23), instance);
        instance.addThis(new FractionLegacy(1));
        assertEquals(new FractionLegacy(35, 23), instance);
        instance = new FractionLegacy(23, 35);
        b = new FractionLegacy(12, 40);
        instance.addThis(b);
        expResult = new FractionLegacy(67, 70);
        assertEquals(expResult, instance);
        instance = new FractionLegacy(321, 56);
        b = new FractionLegacy(123, 27);
        instance.addThis(b);
        expResult = new FractionLegacy(5185, 504);
        assertEquals(expResult, instance);
    }

    /**
     * Test of subThis method, of class Fraction.
     * @throws FractionLegacyException
     */
    @Test
    public void testSubThis() throws FractionLegacyException {
        System.out.println("subThis");
        FractionLegacy b = null;
        FractionLegacy instance = new FractionLegacy();
        FractionLegacy expResult = new FractionLegacy(0);

        instance.subThis(b);
        assertEquals(expResult, instance);

        instance = new FractionLegacy();
        instance.subThis(expResult);
        assertEquals(expResult, instance);
        instance.subThis(expResult);
        assertEquals(expResult, instance);
        instance = new FractionLegacy(-12, -45);
        b = new FractionLegacy(-2.33);
        instance.subThis(b);
        assertEquals(new FractionLegacy(779, 300), instance);
        instance.subThis(instance);
        assertEquals(new FractionLegacy(0), instance);
        instance = new FractionLegacy(12345, -4545);
        b = new FractionLegacy(20);
        instance.subThis(b);
        expResult = new FractionLegacy(6883, -303);
        assertEquals(expResult, instance);
        instance = new FractionLegacy(12345, -4545);
        instance.subThis(expResult);
        assertEquals(instance, new FractionLegacy(20));
        instance = new FractionLegacy(12345, -4545);
        instance.subThis(new FractionLegacy(12.321));
        assertEquals(instance, new FractionLegacy(-4556263, 303000));
    }

    /**
     * Test of mulThis method, of class Fraction.
     * @throws FractionLegacyException
     */
    @Test
    public void testMulThis() throws FractionLegacyException {
        System.out.println("mulThis");
        FractionLegacy b = null;
        FractionLegacy instance = new FractionLegacy();
        FractionLegacy expResult = new FractionLegacy(0);

        instance.mulThis(b);
        assertEquals(expResult, instance);
        instance.mulThis(expResult);
        assertEquals(expResult, instance);
        instance = new FractionLegacy();
        expResult = new FractionLegacy(10, 2);
        expResult.mulThis(instance);
        assertEquals(instance, expResult);
        b = new FractionLegacy(-123, 345);
        instance = new FractionLegacy(234, -456);
        b.mulThis(instance);
        expResult = new FractionLegacy(1599, 8740);
        assertEquals(expResult, b);
        expResult.mulThis(instance);
        assertEquals(new FractionLegacy(62361, -664240), expResult);
    }

    /**
     * Test of divThis method, of class Fraction.
     * @throws FractionLegacyException
     */
    @Test
    public void testDivThis() throws FractionLegacyException {
        System.out.println("divThis");
        FractionLegacy b = null;
        FractionLegacy instance = new FractionLegacy();
        FractionLegacy expResult = new FractionLegacy(1);

        instance.divThis(b);
        assertEquals(instance, new FractionLegacy());
        instance.divThis(expResult);
        assertEquals(instance, new FractionLegacy());
        b = new FractionLegacy(23, 56);
        instance = new FractionLegacy(5);
        b.divThis(instance);
        expResult = new FractionLegacy(23, 280);
        assertEquals(expResult, b);
        expResult.divThis(new FractionLegacy(120, -69));
        assertEquals(new FractionLegacy(-529, 11200), expResult);

    }

    @Test(expected = FractionLegacyException.class)
    public void testDivThis2() throws FractionLegacyException {
        System.out.println("divThis2");
        FractionLegacy instance = new FractionLegacy();
        FractionLegacy expResult = new FractionLegacy(0);

        instance.divThis(expResult);
    }

    /**
     * Test of powThis method, of class Fraction.
     * @throws FractionLegacyException
     */
    @Test
    public void testPowThis() throws FractionLegacyException {
        System.out.println("powThis");
        int e = 0;
        FractionLegacy instance = new FractionLegacy();
        FractionLegacy expResult = new FractionLegacy(1);

        instance.powThis(e);
        assertEquals(expResult, instance);
        e = 10;
        instance = new FractionLegacy();
        instance.powThis(e);
        assertEquals(instance, new FractionLegacy(0));
        instance = new FractionLegacy(-12, 34);
        e = -3;
        instance.powThis(e);
        assertEquals(new FractionLegacy(-4913, 216), instance);
        e = 3;
        instance = new FractionLegacy(-12, 34);
        instance.powThis(e);
        assertEquals(new FractionLegacy(-216, 4913), instance);
        instance = new FractionLegacy(2.45);
        instance.powThis(-5);
        assertEquals(new FractionLegacy(3200000, 282475249), instance);

    }

    @Test(expected = FractionLegacyException.class)
    public void testPowThis2() throws FractionLegacyException {
        System.out.println("powThis2");
        int e = -10;
        FractionLegacy instance = new FractionLegacy();

        instance.powThis(e);
    }
    
    /**
     * Test of toString method, of class Fraction.
     * @throws FractionLegacyException
     */
    @Test
    public void testToString() throws FractionLegacyException {
        System.out.println("toString");
        FractionLegacy.setFractionFormat(true);
        FractionLegacy instance = new FractionLegacy();
        String expResult = "0/1";
        String result = instance.toString();
        assertEquals(expResult, result);
        instance = new FractionLegacy(-12, -45);
        assertEquals(instance.toString(), "4/15");
        FractionLegacy.setFractionFormat(false);
        assertEquals(instance.toString(), "0,267");
        instance = new FractionLegacy();
        assertEquals(instance.toString(), "0,000");
        instance = new FractionLegacy(-134);
        assertTrue(instance.toString().equals("-134,000"));
        FractionLegacy.setFractionFormat(true);
        assertTrue(instance.toString().equals("-134/1"));
        instance = new FractionLegacy(-12.45);
        assertEquals(instance.toString(), "-249/20");
        FractionLegacy.setFractionFormat(false);
        assertEquals(instance.toString(), "-12,450");
    }

    /**
     * Test of isFractionFormat method, of class Fraction.
     */
    @Test
    public void testIsFractionFormat() {
        System.out.println("isFractionFormat");
        FractionLegacy.setFractionFormat(true);
        boolean result = FractionLegacy.isFractionFormat();
        assertTrue(result);
        FractionLegacy.setFractionFormat(false);
        assertFalse(FractionLegacy.isFractionFormat());
    }

    
    /**
     * Test of equals method, of class Fraction.
     * @throws FractionLegacyException
     */
    @Test
    public void testEquals() throws FractionLegacyException {
        System.out.println("equals");
        assertEquals(new FractionLegacy(1), new FractionLegacy(1.000));
        assertEquals(new FractionLegacy("1"), new FractionLegacy("1/1"));
        assertEquals(new FractionLegacy("15/-12"), new FractionLegacy(-5, 4));
        assertEquals(new FractionLegacy("-1.25"), new FractionLegacy(5, -4));
        assertEquals(new FractionLegacy("-1.25"), new FractionLegacy(-1.2500));
    }

    /**
     * Test of greatestCommonFactor method, of class Fraction.
     */
    @Test
    public void testGreatestCommonFactor() {
        System.out.println("ggT");
        long result = FractionLegacy.greatestCommonFactor(-12234, 2445);
        assertEquals(3, result);
        assertEquals(FractionLegacy.greatestCommonFactor(-122345, -2445), 5);
        assertEquals(FractionLegacy.greatestCommonFactor(5731630053L, -5737911553L), 12563);
        assertEquals(FractionLegacy.greatestCommonFactor(256728, 2581918), 1126);
    }

    /**
     * Test of leastCommonMultiple method, of class Fraction.
     */
    @Test
    public void testLeastCommonMultiple() {
        System.out.println("kgV");
        assertEquals(FractionLegacy.leastCommonMultiple(-1234, -64), 39488);
        assertEquals(FractionLegacy.leastCommonMultiple(1234, -64), 39488);
        assertEquals(FractionLegacy.leastCommonMultiple(-1234, 64), 39488);
        assertEquals(FractionLegacy.leastCommonMultiple(12134, 624), 3785808);
        assertEquals(FractionLegacy.leastCommonMultiple(2134, 1), 2134);
    }

}
