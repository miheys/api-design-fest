package org.netbeans.apifest.boolcircuitday1;

import java.util.Stack;

/**
 * Created by John on 2014.12.10..
 */
public interface ExpressionFactory {

    Expression create(String operation, Stack<Expression> arguments);

}
