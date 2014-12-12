package org.netbeans.apifest.booleval;

import org.netbeans.apifest.boolcircuitday2.Circuit;
import junit.framework.TestCase;

// BEGIN: apifest.EvalTest

/** The initial quest for this APIFest is to create an API for boolean
 * circuits. Such API shall be able to compose a boolean circuit from
 * basic elements and evaluate the result given initial values for 
 * input variables.
 * <p>
 * The basic elements include:
 * <ul>
 *   <li>negation - has one input and one output and changes 0 on input to 
 *          on output 1 and 1 to 0
 *   <li>and - has two inputs and one output. The output is 1 only if both 
 *          inputs are 1, otherwise it is 0
 *   <li>or - has two inputs and one output. The output is 1 always, 
 *          except in the case when both inputs are 0
 * </ul>
 *
 * <p>
 * The boolean circuit can be used to represent boolean formulas and
 * compute the results for certain values of its inputs. The individual
 * tasks described as tests bellow.
 *
 * <p>
 * Links of interest:
 * <ul>
 *   <li>
 *      <a href="http://en.wikipedia.org/wiki/Truth_table">
 *          Truth table</a>
 *   <li>
 *      <a href="http://en.wikipedia.org/wiki/Tautology_(logic)">
 *          Taugology</a>
 * </ul>
 */
public class CircuitTest extends TestCase {

    /**
     * Create a circuit to evaluate x1 and x2 and then
     * verify that its result is false for input (false, true) and
     * it is true for input (true, true).
     */
    public void testX1andX2() {
        Circuit circuit = new Circuit("x1 x2 and");

        circuit.setInputs(false, true);
        assertFalse(circuit.evaluate());

        circuit.setInputs(true, true);
        assertTrue(circuit.evaluate());
    }
    
    /** 
     * Create a circuit to evaluate (x1 and x2) or x3 and then
     * verify that its result is false for input (false, true, false) and
     * it is true for input (false, false, true).
     */
    public void testX1andX2orX3() {
        Circuit circuit = new Circuit("x1 x2 and x3 or");

        circuit.setInputs(false, true, false);
        assertFalse(circuit.evaluate());

        circuit.setInputs(false, false, true);
        assertTrue(circuit.evaluate());
    }

    /** 
     * Create a circuit to evaluate (x1 or not(x1)) and then
     * verify that its result is true for all values of x1.
     */
    public void testAlwaysTrue() {
        Circuit circuit = new Circuit("x1 x2 not or");

        circuit.setInputs(true, true);
        assertTrue(circuit.evaluate());

        circuit.setInputs(false, false);
        assertTrue(circuit.evaluate());
    }
    
}
// END: apifest.EvalTest
