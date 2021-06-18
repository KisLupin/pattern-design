package interpreter;

import java.text.Format;

public class InterpreterClient {
    public InterpreterContext ic;

    public InterpreterClient(InterpreterContext i) {
        this.ic = i;
    }

    public String interpret(String str) {
        Expression exp;
        //create rules for expressions
        int c = Integer.parseInt(str.substring(0, str.indexOf(" ")));
        if (str.endsWith("Hexadecimal")) {
            exp = new IntToHexExpression(c);
        } else if (str.endsWith("Binary")) {
            exp = new IntToBinaryExpression(c);
        } else return str;

        return exp.interpret(ic);
    }

    public static void main(String[] args) {
        String str1 = "128 in Binary";
        String str2 = "128 in Hexadecimal";

        InterpreterClient ec = new InterpreterClient(new InterpreterContext());
        System.out.println(str1 + " = " + ec.interpret(str1));
        System.out.println(str2 + " = " + ec.interpret(str2));
    }
}
