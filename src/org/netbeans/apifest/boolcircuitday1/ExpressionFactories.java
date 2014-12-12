package org.netbeans.apifest.boolcircuitday1;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created by John on 2014.12.11..
 */
public class ExpressionFactories {

    private static Set<ExpressionFactory> customExpressionFactories = Sets.newHashSet();

    public static void registerCustom(ExpressionFactory customExpressionFactory) {
        customExpressionFactories.add(customExpressionFactory);
    }

    public static Set<ExpressionFactory> get() {
        return Sets.newHashSet(customExpressionFactories);
    }
}
