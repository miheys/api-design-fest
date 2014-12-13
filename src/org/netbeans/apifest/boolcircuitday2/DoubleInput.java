package org.netbeans.apifest.boolcircuitday2;

import com.google.common.base.Preconditions;
import org.netbeans.apifest.boolcircuitday2.api.BooleanExpression;
import org.netbeans.apifest.boolcircuitday2.api.DoubleExpression;

import static org.netbeans.apifest.boolcircuitday2.api.ConvertUtils.toBoolean;

/**
 * Created by Mihails Volkovs on 2014.12.09..
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

    protected boolean isSet() {
        return value != null;
    }

    public void reset() {
        value = null;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
