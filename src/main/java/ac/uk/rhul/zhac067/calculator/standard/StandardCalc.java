// $Id: StandardCalc.java 86 2020-12-06 15:40:57Z zhac067 $ $Revision: 86 $

package ac.uk.rhul.zhac067.calculator.standard;

import ac.uk.rhul.zhac067.calculator.CalculatorInterface;
import ac.uk.rhul.zhac067.calculator.Symbol;
import ac.uk.rhul.zhac067.calculator.postfix.InvalidExpressionException;
import ac.uk.rhul.zhac067.calculator.postfix.RevPolishCalc;

/**
 * A calculator class to evaluate standard/infix expressions.
 * <p>
 * This class works by using Dijkstra's Shunting Yard algorithm to convert infix expressions to
 * postfix expressions. Then, it evaluates these expressions using a Postfix evaluator.
 * </p>
 * 
 * @author zhac067
 * @see RevPolishCalc @see CalculatorInterface
 */
public class StandardCalc implements CalculatorInterface {
  private OpStack stack;
  private RevPolishCalc revPolCalc;

  /**
   * Construct a new standard notation/infix calculator.
   */
  public StandardCalc() {
    this.stack = new OpStack();
    this.revPolCalc = new RevPolishCalc();
  }

  /**
   * Evaluates an infix mathematical expression. It does so by converting the expression to a
   * postfix expression.
   * 
   * @String expression the infix expression to evaluate.
   * @return the result of the evaluation.
   * @throws InvalidExpressionException if the expression is not a valid infix expression.
   */
  @Override
  public float evaluate(String expression) throws InvalidExpressionException {
    String[] tokens = expression.split(" ");
    StringBuilder postfix = new StringBuilder();
    String separator = "";
    boolean expectNumber = true; // the first token should be a number or bracket
    for (String token : tokens) {
      // If it is a symbol, push to the stack
      if ("+-/*".contains(token)) {
        if (expectNumber) {
          throw new InvalidExpressionException();
        }
        Symbol s = null;
        switch (token) {
          case "+":
            s = Symbol.PLUS;
            break;
          case "-":
            s = Symbol.MINUS;
            break;
          case "/":
            s = Symbol.DIVIDE;
            break;
          case "*":
            s = Symbol.TIMES;
            break;
          case "(":
            s = Symbol.LEFT_BRACKET;
            break;
          case ")":
            s = Symbol.RIGHT_BRACKET;
            break;
          default:
            throw new InvalidExpressionException();
        }
        while (stack.size() > 0 && stack.peek().getPrecedence() >= s.getPrecedence()) {
          postfix.append(separator + stack.pop().toString());
        }
        stack.push(s);
        expectNumber = true;
      } else if (token.equals("(")) {
        stack.push(Symbol.LEFT_BRACKET);
      } else if (token.equals(")")) {
        while (stack.peek() != Symbol.LEFT_BRACKET) {
          postfix.append(separator + stack.pop().toString());
        }
        stack.pop();
      } else {
        if (!expectNumber) {
          throw new InvalidExpressionException();
        }
        try {
          // Simply check that the token is indeed a number.
          Float.parseFloat(token);
          postfix.append(separator + token);
          separator = " ";
        } catch (NumberFormatException e) {
          System.err.print(token);
          throw new InvalidExpressionException();
        }
        expectNumber = false;
      }
    }
    while (stack.size() > 0) {
      Symbol s = stack.pop();
      postfix.append(separator + s.toString());
    }
    String toEvaluate = postfix.toString();
    return revPolCalc.evaluate(toEvaluate);
  }

}
