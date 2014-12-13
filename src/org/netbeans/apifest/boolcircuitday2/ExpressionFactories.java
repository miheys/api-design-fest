package org.netbeans.apifest.boolcircuitday2;

import com.google.common.collect.Sets;
import org.netbeans.apifest.boolcircuitday2.api.ExpressionFactory;

import java.util.Set;

/**
 * Created by Mihails Volkovs on 2014.12.11..
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
