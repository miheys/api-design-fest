package org.netbeans.apifest.boolcircuitday2;

import com.google.common.base.Preconditions;

/**
 * Created by John on 2014.12.09..
 */
class DoubleInput implements BooleanExpression, DoubleExpression {

    private Double value;

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean evaluate() {
        return toBoolean(evaluateDouble());
    }

    @Override
    public double evaluateDouble() {
        Preconditions.checkState(value != null, "Input has not been provided");
        return value;
    }

    protected static boolean toBoolean(Double value) {
        if (value.equals(1.0)) {
            return true;
        } else if (value.equals(0.0)) {
            return false;
        }
        throw new IllegalStateException("Double value was set as input, can't evaluate boolean");
    }

    protected boolean isSet() {
        return value != null;
    }

    public void reset() {
        value = null;
    }
}
