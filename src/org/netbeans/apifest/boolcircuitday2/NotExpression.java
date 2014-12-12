package org.netbeans.apifest.boolcircuitday2;

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
        return DoubleInput.toBoolean(evaluateDouble());
    }

    @Override
    public double evaluateDouble() {
        return 1 - argument.evaluateDouble();
    }
}
