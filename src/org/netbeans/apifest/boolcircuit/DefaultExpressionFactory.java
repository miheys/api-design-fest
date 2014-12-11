package org.netbeans.apifest.boolcircuit;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by John on 2014.12.07..
 */
class DefaultExpressionFactory {

    private static Set<String> keywords = new HashSet<>();
    static {
        keywords.add("and");
        keywords.add("or");
        keywords.add("not");
    }

    public static Expression create(String operation, Stack<Expression> argumentStack) {
        if ("and".equals(operation)) {
            return new AndExpression(argumentStack.pop(), argumentStack.pop());
        } else if ("or".equals(operation)) {
            return new OrExpression(argumentStack.pop(), argumentStack.pop());
        } else if ("not".equals(operation)) {
            return new NotExpression(argumentStack.pop());
        }
        return createCustomExpression(operation, argumentStack);
    }

    private static Expression createCustomExpression(String operation, Stack<Expression> argumentStack) {
        for (ExpressionFactory expressionFactory : ExpressionFactories.get()) {
            Expression expression = expressionFactory.create(operation, argumentStack);
            if (expression != null) {
                return expression;
            }
        }
        return null;
    }

}
