// $Id: CalculatorInterface.java 86 2020-12-06 15:40:57Z zhac067 $ $Revision: 86 $

package ac.uk.rhul.zhac067.calculator;

import ac.uk.rhul.zhac067.calculator.postfix.InvalidExpressionException;

/**
 * This is an interface for classes that can evaluate some mathematical expression.
 * 
 * @author zhac067
 */
public interface CalculatorInterface {
  /**
   * Evaluates a given expression and returns the result.
   * 
   * @param expression the mathematical expression to evaluate.
   * @return the result of the evaluation.
   * @throws InvalidExpressionException if the expression is not a valid mathematical expression.
   */
  public float evaluate(String expression) throws InvalidExpressionException;
}
