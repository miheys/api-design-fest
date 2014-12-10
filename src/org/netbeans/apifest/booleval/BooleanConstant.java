package org.netbeans.apifest.booleval;

/**
 * Created by John on 2014.12.07..
 */
class BooleanConstant implements Expression {

    public static BooleanConstant TRUE = new BooleanConstant(true);

    public static BooleanConstant FALSE = new BooleanConstant(false);

    private boolean value;

    private BooleanConstant(boolean value) {
        this.value = value;
    }

    @Override
    public boolean evaluate() {
        return value;
    }

}
