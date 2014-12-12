package org.netbeans.apifest.boolcircuitday1;

/**
 * Created by John on 2014.12.07..
 */
class AndExpression implements Expression {

    private Expression[] arguments;

    public AndExpression(Expression... arguments) {
        this.arguments = arguments;
    }

    @Override
    public boolean evaluate() {
        boolean result = true;
        for (Expression argument : arguments) {
            result = result & argument.evaluate();
        }
        return result;
    }

}
