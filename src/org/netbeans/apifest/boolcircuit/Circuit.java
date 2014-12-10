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

package org.netbeans.apifest.boolcircuit;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import java.util.*;

/**
 */
public class Circuit {

    private List<BooleanInput> inputs = Lists.newArrayList();

    private Stack<Expression> stack = new Stack<>();

    private Set<String> keywords = new HashSet<>();
    {
        keywords.add("and");
        keywords.add("or");
        keywords.add("not");
    }

    private Expression expression;

    public Circuit(String expression) {
        String[] atoms = expression.split("\\s");
        for (String atom : atoms) {
            if (keywords.contains(atom)) {
                stack.push(ExpressionFactory.create(atom, stack));
            } else {
                BooleanInput input = new BooleanInput();
                inputs.add(input);
                stack.push(input);
            }
        }
        this.expression = stack.peek();
    }

    public void setInputs(boolean... values) {
        String errorMessage = String.format("Circuit contains %s inputs, but was provided %s", inputs.size(), values.length);
        Preconditions.checkArgument(inputs.size() == values.length, errorMessage);
        int i = 0;
        for (BooleanInput input : inputs) {
            input.setValue(values[i++]);
        }
    }

    private void setInput(String variableName, boolean value) {
        // TODO: MVO: complete with map
    }

    public boolean evaluate() {
        return expression.evaluate();
    }

}
