/*
 * The contents of this file are subject to the terms of the Common Development
 * and Distribution License (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at http://www.netbeans.org/cddl.html
 * or http://www.netbeans.org/cddl.txt.
 *
 * When distributing Covered Code, include this CDDL Header Notice in each file
 * and include the License file at http://www.netbeans.org/cddl.txt.
 * If applicable, add the following below the CDDL Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * The Original Software is NetBeans. The Initial Developer of the Original
 * Software is Sun Microsystems, Inc. Portions Copyright 1997-2006 Sun
 * Microsystems, Inc. All Rights Reserved.
 */

package org.netbeans.apifest.boolcircuitday2;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.netbeans.apifest.boolcircuitday2.api.Circuit;
import org.netbeans.apifest.boolcircuitday2.api.DoubleExpression;

import java.util.*;

import static org.netbeans.apifest.boolcircuitday2.api.ConvertUtils.toBoolean;
import static org.netbeans.apifest.boolcircuitday2.api.ConvertUtils.toDouble;

/**
 */
public final class CircuitImpl implements Circuit {

    private List<DoubleInput> inputs = Lists.newArrayList();

    private Stack<DoubleExpression> stack = new Stack<>();

    private Map<String, DoubleInput> variables = Maps.newHashMap();

    private DoubleExpression expression;

    public CircuitImpl(String expressionString) {
        String[] atoms = expressionString.split("\\s");
        for (String atom : atoms) {
            DoubleExpression expression = DefaultExpressionFactory.create(atom, stack);
            if (expression != null) {
                stack.push(expression);
            } else {
                DoubleInput input = variables.get(atom);
                if (input == null) {
                    input = new DoubleInput();
                    variables.put(atom, input);
                }
                inputs.add(input);
                stack.push(input);
            }
        }
        this.expression = stack.peek();
    }

    @Deprecated
    public void setInputs(boolean... values) {
        String errorMessage = String.format("Circuit contains %s inputs, but was provided %s", inputs.size(), values.length);
        Preconditions.checkArgument(inputs.size() == values.length, errorMessage);
        int i = 0;
        for (DoubleInput input : inputs) {
            input.setValue(values[i++] ? 1 : 0);
        }
    }

    public void setInput(String variableName, boolean value) {
        setInput(variableName, toDouble(value));
    }

    public void setInput(String variableName, double value) {
        String errorMessage = String.format("There is no such variable as %s among %s.", variableName, variables.keySet());
        Preconditions.checkArgument(variables.containsKey(variableName), errorMessage);
        Preconditions.checkArgument(value >= 0 && value <= 1, "Only values [0.0..1.1] are allowed");
        Preconditions.checkState(!variables.get(variableName).isSet(), String.format("Variable %s has already been set", variableName));
        variables.get(variableName).setValue(value);
    }

    public boolean evaluate() {
        return toBoolean(evaluateDouble());
    }

    public double evaluateDouble() {
        double result = expression.evaluateDouble();
        for (DoubleInput input : variables.values()){
            input.reset();
        }
        return result;
    }

}
