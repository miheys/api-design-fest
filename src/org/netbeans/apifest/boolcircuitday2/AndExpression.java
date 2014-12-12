package org.netbeans.apifest.boolcircuitday2;

/**
 * Created by John on 2014.12.07..
 */
class AndExpression implements BooleanExpression, DoubleExpression {

    private DoubleExpression[] arguments;

    public AndExpression(DoubleExpression... arguments) {
        this.arguments = arguments;
    }

    @Override
    public boolean evaluate() {
        return DoubleInput.toBoolean(evaluateDouble());
    }

    @Override
    public double evaluateDouble() {
        double result = 1;
        for (DoubleExpression argument : arguments) {
            result = result * argument.evaluateDouble();
        }
        return result;
    }
}
