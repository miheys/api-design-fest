package org.netbeans.apifest.boolcircuit;

/**
 * Created by John on 2014.12.07..
 */
class NotExpression implements Expression {

    private Expression argument;

    public NotExpression(Expression argument) {
        this.argument = argument;
    }

    @Override
    public boolean evaluate() {
        return !argument.evaluate();
    }

}
