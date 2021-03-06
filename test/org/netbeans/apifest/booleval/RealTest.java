package org.netbeans.apifest.booleval;


import junit.framework.TestCase;
import org.netbeans.apifest.boolcircuitday2.ExpressionFactories;
import org.netbeans.apifest.boolcircuitday2.api.Circuit;
import org.netbeans.apifest.boolcircuitday2.api.CircuitFactory;
import org.netbeans.apifest.boolcircuitday2.custom.GteExpressionFactory;

// BEGIN: apitest.day2.RealTest

/**
 * This file contains the APIFest quest for day 2. Simply, turn the
 * boolean circuit into circuit that can compute with double
 * values from 0 to 1.
 * <p/>
 * This means that where ever a boolean was used to represent input or
 * output values, one can now use any double number from >= 0 and <= 1.
 * Still, to support backward compatibility, the operations with booleans
 * has to be kept available and have to work. In fact False shall be
 * treated as 0 and True as 1.
 * <p/>
 * The basic elements has to be modified to work on doubles
 * in the following way:
 * <ul>
 * <li>negation - neg(x) = 1 - x, this is correct extension as
 * neg(false)=neg(0)=1-0=1=true
 * <li>and - and(x,y) = x * y, again this is fine as
 * and(true,true)=1*1=true and also
 * and(false,true)=0*1=0=false
 * <li>or - or(x,y) = 1 - (1 - x) * (1 - y) and this is also ok as
 * or(false,false) = 1 - (1 - 0) * (1 - 0) = 1 - 1 = 0 = false
 * or(true,false) = 1 - (1 - 1)*(1 - 0) = 1 - 0 * 1 = 1 = true
 * </ul>
 * <p/>
 * However as the circuits with doubles are more rich than plain boolean
 * circuits, there is additional requirement to allow any user of your API
 * to write its own "element" type. This is all going to be exercise in
 * the tests bellow which you are supposed to implement.
 */
public class RealTest extends TestCase {

    public RealTest(String testName) {
        super(testName);
    }

    /**
     * First of all create a circuit which will evaluate
     * expression (X1 and X2) or not(x1). Hold the circuit
     * in some variable.
     * <p/>
     * Feed this circuit with x1=true, x2=false, assert result is false
     * <p/>
     * Feed the same circuit with x1=false, x2=true, assert result is
     * true
     * <p/>
     * Feed the same circuit with x1=0.0, x2=1.0, assert result is 1.0
     * <p/>
     * Feed the same circuit with x1=0.5, x2=0.5, assert result is 0.625
     * <p/>
     * Feed the same circuit with x1=0.0, x2=2.0, make sure it
     * throws an exception
     */
    public void testX1andX2orNotX1() {
        Circuit circuit = CircuitFactory.create("x1 x2 and x1 not or");

        circuit.setInput("x1", true);
        circuit.setInput("x2", false);
        assertFalse(circuit.evaluate());

        circuit.setInput("x1", false);
        circuit.setInput("x2", true);
        assertTrue(circuit.evaluate());

        circuit.setInput("x1", 0.0);
        circuit.setInput("x2", 1.0);
        assertEquals(1.0, circuit.evaluateDouble());

        circuit.setInput("x1", 0.5);
        circuit.setInput("x2", 0.5);
        assertEquals(0.625, circuit.evaluateDouble());

        circuit.setInput("x1", 0.0);
        try {
            circuit.setInput("x2", 2.0);
            fail();
        } catch (Exception e) {
            // ok
        }
    }

    /**
     * Ensure that one variable cannot be filled with two different
     * values. Create a circuit for x1 and x1. Make sure that for any
     * usage of your API that would not lead to x1 * x1 result, an
     * exception is thrown. For example if there was a way to feed the
     * circuit with two different values 0.3 and 0.5 an exception is
     * thrown indicating that this is improper use of the circuit.
     */
    public void testImproperUseOfTheCircuit() {
        Circuit circuit = CircuitFactory.create("x1 x1 and");
        circuit.setInput("x1", 0.3);
        try {
            circuit.setInput("x1", 0.5);
            fail();
        } catch(Exception e) {
            // ok
        }
    }

    /**
     * Write your own element type called "gte" that will have two
     * inputs and one output.
     * The output value will be 1 if x1 >= x2 and 0 otherwise.
     * <p/>
     * Create
     * circuit for following expression: (x1 and not(x1)) gte x1
     * <p/>
     * Feed the circuit with 0.5 and verify the result is 0
     * <p/>
     * Feed the same circuit with 1 and verify the result is 0
     * <p/>
     * Feed the same circuit with 0 and verify the result is 1
     */
    public void testGreaterThanEqualElement() {
        ExpressionFactories.registerCustom(new GteExpressionFactory());
        Circuit circuit = CircuitFactory.create("x1 x1 not and x1 gte");

        circuit.setInput("x1", 0.5);
        assertEquals(0.0, circuit.evaluateDouble());

        circuit.setInput("x1", 1);
        assertEquals(0.0, circuit.evaluateDouble());

        circuit.setInput("x1", 0);
        assertEquals(1.0, circuit.evaluateDouble());
    }
}


