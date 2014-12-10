package org.netbeans.apifest.booleval;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by John on 2014.12.07..
 */
class ExpressionFactory {

    public static Expression create(String operation, Stack<Expression> argumentStack) {
        if ("and".equals(operation)) {
            return new AndExpression(argumentStack.pop(), argumentStack.pop());
        } else if ("or".equals(operation)) {
            return new OrExpression(argumentStack.pop(), argumentStack.pop());
        } else if ("not".equals(operation)) {
            return new NotExpression(argumentStack.pop());
        } else {
            throw new UnsupportedOperationException(operation);
        }
    }

    private static Expression[] collectArguments(Stack<Expression> argumentStack) {
        ArrayList<Expression> result = new ArrayList<>();
        for (Expression argument : argumentStack) {
            result.add(argument);
        }
        argumentStack.clear();
        return result.toArray(new Expression[result.size()]);
    }

}
