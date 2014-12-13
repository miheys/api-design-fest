package org.netbeans.apifest.boolcircuitday2;

import org.netbeans.apifest.boolcircuitday2.api.BooleanExpression;
import org.netbeans.apifest.boolcircuitday2.api.DoubleExpression;

import static org.netbeans.apifest.boolcircuitday2.api.ConvertUtils.toBoolean;

/**
 * Created by Mihails Volkovs on 2014.12.07..
 */
class AndExpression implements BooleanExpression, DoubleExpression {

    private DoubleExpression[] arguments;

    public AndExpression(DoubleExpression... arguments) {
        this.arguments = arguments;
    }

    @Override
    public boolean evaluate() {
        return toBoolean(evaluateDouble());
    }

    @Override
    public double evaluateDouble() {
        double result = 1;
        for (DoubleExpression argument : arguments) {
            result = result * argument.evaluateDouble();
        }
        return result;
    }

    @Override
    public String toString() {
        return "AND";
    }
}
