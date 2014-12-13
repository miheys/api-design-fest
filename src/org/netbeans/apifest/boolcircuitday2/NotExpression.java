package org.netbeans.apifest.boolcircuitday2;

import org.netbeans.apifest.boolcircuitday2.api.BooleanExpression;
import org.netbeans.apifest.boolcircuitday2.api.DoubleExpression;

import static org.netbeans.apifest.boolcircuitday2.api.ConvertUtils.toBoolean;

/**
 * Created by John on 2014.12.07..
 */
class NotExpression implements BooleanExpression, DoubleExpression {

    private DoubleExpression argument;

    public NotExpression(DoubleExpression argument) {
        this.argument = argument;
    }

    @Override
    public boolean evaluate() {
        return toBoolean(evaluateDouble());
    }

    @Override
    public double evaluateDouble() {
        return 1 - argument.evaluateDouble();
    }

    @Override
    public String toString() {
        return "NOT";
    }
}
