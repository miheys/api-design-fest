package org.netbeans.apifest.boolcircuitday2.api;

import org.netbeans.apifest.boolcircuitday2.CircuitImpl;

/**
 * Created by Mihails Volkovs on 2014.12.13..
 */
public final class CircuitFactory {

    public static Circuit create(String expression) {
        return new CircuitImpl(expression);
    }

}
