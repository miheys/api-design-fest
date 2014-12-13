package org.netbeans.apifest.boolcircuitday2.api;

/**
 * Created by Mihails Volkovs on 2014.12.13..
 */
public interface Circuit {

    @Deprecated
    void setInputs(boolean... values);

    void setInput(String variableName, boolean value);

    void setInput(String variableName, double value);

    boolean evaluate();

    double evaluateDouble();

}
