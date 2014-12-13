package org.netbeans.apifest.boolcircuitday2.custom;

import org.netbeans.apifest.boolcircuitday2.api.BooleanExpression;
import org.netbeans.apifest.boolcircuitday2.api.DoubleExpression;
import org.netbeans.apifest.boolcircuitday2.api.ExpressionFactory;

import java.util.Stack;

import static org.netbeans.apifest.boolcircuitday2.api.ConvertUtils.toDouble;

/**
 * Created by Mihails Volkovs on 2014.12.13..
 */
public class GteExpressionFactory implements ExpressionFactory {

    @Override
    public BooleanExpression create(String operation, Stack<BooleanExpression> arguments) {
        if (operation.equals("gte")) {
            DoubleExpression arg2 = toDouble(arguments.pop());
            DoubleExpression arg1 = toDouble(arguments.pop());
            return new GteExpression(arg1, arg2);
        }
        return null;
    }

    @Override
    public DoubleExpression createDouble(String operation, Stack<DoubleExpression> arguments) {
        if (operation.equals("gte")) {
            DoubleExpression arg2 = arguments.pop();
            DoubleExpression arg1 = arguments.pop();
            return new GteExpression(arg1, arg2);
        }
        return null;
    }

}
