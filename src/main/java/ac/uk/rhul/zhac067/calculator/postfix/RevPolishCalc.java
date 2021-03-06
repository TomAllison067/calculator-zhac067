// $Id: RevPolishCalc.java 86 2020-12-06 15:40:57Z zhac067 $ $Revision: 86 $

package ac.uk.rhul.zhac067.calculator.postfix;

import ac.uk.rhul.zhac067.calculator.CalculatorInterface;
import java.util.ArrayDeque;
import java.util.Deque;


/**
 * This class evaluates mathematical expressions given in reverse Polish notation.
 * <p>
 * Reverse Polish notation (RPN), also known as Polish postfix notation or simply postfix notation,
 * is a mathematical notation in which operators follow their operands.
 * </p>
 * <p>
 * A simple example would be the expression "1 1 +", which translates to "1 + 1". An advantage is
 * that we do not need to worry about parentheses with this notation. Say we wanted to evaluate "3 -
 * (4 * 5)", we would write this as 3 4 5 * -. This unambiguously means 3 (4 5 *) - which becomes 3
 * (20) - which becomes 3 - 20.
 * </p>
 * 
 * @author zhac067
 *
 */
public class RevPolishCalc implements CalculatorInterface {
  /**
   * A stack to store Visitable nodes during the evaluation.
   */
  private Deque<Visitable> nodes;

  /**
   * Constructs a new RevPolishCalc.
   */
  public RevPolishCalc() {
    nodes = new ArrayDeque<Visitable>();
  }

  /**
   * Evaluates the given Reverse Polish / postfix notation mathematical expression.
   * 
   * @param expression the postfix expression to evaluate.
   * @return the result of the evaluation.
   * @throws InvalidExpressionException if the expression is not a valid postfix expression.
   */
  public float evaluate(String expression) throws InvalidExpressionException {
    nodes.clear();
    String[] tokens = expression.split(" ");
    for (String token : tokens) {
      /*
       * If we read an operator, pop the previous two nodes from the stack set them as children to a
       * new parent node.
       */
      if ("+-/*".contains(token)) {

        if (nodes.size() < 2) {
          throw new InvalidExpressionException();
        }
        Visitable leafRight = nodes.pop();
        Visitable leafLeft = nodes.pop();
        Visitable opNode = null;
        switch (token) {
          case "+":
            opNode = new OperatorNode(Operators.PLUS, leafLeft, leafRight);
            break;
          case "-":
            opNode = new OperatorNode(Operators.MINUS, leafLeft, leafRight);
            break;
          case "/":
            opNode = new OperatorNode(Operators.DIVIDE, leafLeft, leafRight);
            break;
          case "*":
            opNode = new OperatorNode(Operators.TIMES, leafLeft, leafRight);
            break;
          default:
            break; // We really won't ever get to the default case
        }
        nodes.push(opNode);
      } else {
        // Otherwise, if we read a number, just push it to the stack.
        try {
          Float value = Float.parseFloat(token);
          nodes.push(new LeafNode(value));
        } catch (NumberFormatException e) {
          throw new InvalidExpressionException(); // I know this is lazy...
        }
      }
    }
    if (nodes.size() != 1) {
      // This could happen if we have too many numbers or
      // too many operators
      throw new InvalidExpressionException();
    }
    SumVisitor visitor = new SumVisitor();
    // The answer will be stored in the SumVisitor at the end of the evaluation.
    nodes.pop().accept(visitor);
    return visitor.getAnswer();
  }

}
