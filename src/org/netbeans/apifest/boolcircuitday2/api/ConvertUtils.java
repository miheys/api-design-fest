package org.netbeans.apifest.boolcircuitday2.api;

/**
 * Created by Mihails Volkovs on 2014.12.13..
 */
public final class ConvertUtils {

    public static boolean toBoolean(Double value) {
        if (value.equals(1.0)) {
            return true;
        } else if (value.equals(0.0)) {
            return false;
        }
        throw new IllegalStateException("Double value was set as input, can't evaluate boolean");
    }

    public static double toDouble(boolean value) {
        return value ? 1.0 : 0.0;
    }

    public static DoubleExpression toDouble(final BooleanExpression expression) {
        return new DoubleExpression(){
            @Override
            public double evaluateDouble() {
                return ConvertUtils.toDouble(expression.evaluate());
            }
        };
    }

}
