package org.netbeans.apifest.boolcircuitday2;

import org.netbeans.apifest.boolcircuitday2.api.DoubleExpression;
import org.netbeans.apifest.boolcircuitday2.api.ExpressionFactory;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by Mihails Volkovs on 2014.12.07..
 */
class DefaultExpressionFactory {

    private static Set<String> keywords = new HashSet<>();
    static {
        keywords.add("and");
        keywords.add("or");
        keywords.add("not");
    }

    public static DoubleExpression create(String operation, Stack<DoubleExpression> argumentStack) {
        if ("and".equals(operation)) {
            return new AndExpression(argumentStack.pop(), argumentStack.pop());
        } else if ("or".equals(operation)) {
            return new OrExpression(argumentStack.pop(), argumentStack.pop());
        } else if ("not".equals(operation)) {
            return new NotExpression(argumentStack.pop());
        }
        return createCustomExpression(operation, argumentStack);
    }

    private static DoubleExpression createCustomExpression(String operation, Stack<DoubleExpression> argumentStack) {
        for (ExpressionFactory expressionFactory : ExpressionFactories.get()) {
            DoubleExpression expression = expressionFactory.createDouble(operation, argumentStack);
            if (expression != null) {
                return expression;
            }
        }
        return null;
    }

}
