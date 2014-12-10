package org.netbeans.apifest.booleval;

/**
 * Created by John on 2014.12.07..
 */
class OrExpression implements Expression {

    private Expression[] arguments;

    public OrExpression(Expression... arguments) {
        this.arguments = arguments;
    }

    @Override
    public boolean evaluate() {
        boolean result = false;
        for (Expression argument : arguments) {
            result = result | argument.evaluate();
        }
        return result;
    }

}
