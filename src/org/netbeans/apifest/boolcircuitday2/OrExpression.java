package org.netbeans.apifest.boolcircuitday2;

/**
 * Created by John on 2014.12.07..
 */
class OrExpression implements BooleanExpression, DoubleExpression {

    private DoubleExpression[] arguments;

    public OrExpression(DoubleExpression... arguments) {
        this.arguments = arguments;
    }

    @Override
    public boolean evaluate() {
        return DoubleInput.toBoolean(evaluateDouble());
    }

    @Override
    public double evaluateDouble() {
        double result = 0;
        for (DoubleExpression argument : arguments) {
            result = or(result, argument.evaluateDouble());
        }
        return result;
    }

    private double or(double value1, double value2) {
        return 1 - (1 - value1) * (1 - value2);
    }
}
