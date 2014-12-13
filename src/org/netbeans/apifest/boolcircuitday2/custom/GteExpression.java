package org.netbeans.apifest.boolcircuitday2.custom;

import org.netbeans.apifest.boolcircuitday2.api.BooleanExpression;
import org.netbeans.apifest.boolcircuitday2.api.DoubleExpression;

import static org.netbeans.apifest.boolcircuitday2.api.ConvertUtils.toBoolean;

/**
 * Created by Mihails Volkovs on 2014.12.13..
 */
public class GteExpression implements BooleanExpression, DoubleExpression {

    private DoubleExpression arg1;

    private DoubleExpression arg2;

    public GteExpression(DoubleExpression arg1, DoubleExpression arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    @Override
    public boolean evaluate() {
        return toBoolean(evaluateDouble());
    }

    @Override
    public double evaluateDouble() {
        return arg1.evaluateDouble() >= arg2.evaluateDouble() ? 1.0 : 0.0;
    }
}
