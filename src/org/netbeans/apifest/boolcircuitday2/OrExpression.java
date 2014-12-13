package org.netbeans.apifest.boolcircuitday2;

import org.netbeans.apifest.boolcircuitday2.api.BooleanExpression;
import org.netbeans.apifest.boolcircuitday2.api.DoubleExpression;

import static org.netbeans.apifest.boolcircuitday2.api.ConvertUtils.toBoolean;

/**
 * Created by Mihails Volkovs on 2014.12.07..
 */
class OrExpression implements BooleanExpression, DoubleExpression {

    private DoubleExpression[] arguments;

    public OrExpression(DoubleExpression... arguments) {
        this.arguments = arguments;
    }

    @Override
    public boolean evaluate() {
        return toBoolean(evaluateDouble());
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

    @Override
    public String toString() {
        return "OR";
    }
}
