package org.netbeans.apifest.boolcircuitday1;

import com.google.common.base.Preconditions;

/**
 * Created by John on 2014.12.09..
 */
class BooleanInput implements Expression {

    private Boolean value;

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public boolean evaluate() {
        Preconditions.checkState(value != null, "Input has not been provided");
        return value;
    }
}
