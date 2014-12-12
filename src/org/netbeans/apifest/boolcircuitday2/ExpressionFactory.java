package org.netbeans.apifest.boolcircuitday2;

import java.util.Stack;

/**
 * Created by John on 2014.12.10..
 */
public interface ExpressionFactory {

    BooleanExpression create(String operation, Stack<BooleanExpression> arguments);

    DoubleExpression createDouble(String operation, Stack<DoubleExpression> arguments);

}
