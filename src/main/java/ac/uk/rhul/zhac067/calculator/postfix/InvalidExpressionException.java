// $Id: InvalidExpressionException.java 47 2020-11-18 22:40:18Z zhac067 $ $Revision: 47 $

package ac.uk.rhul.zhac067.calculator.postfix;

/**
 * Thrown by methods that implement the Calculator interface to indicate that the expression
 * evaluated was not indeed a valid mathematical expression.
 * <p>
 * Some examples include:
 * <ul>
 * <li>"+ 1 1" if evaluating postfix notation.</li>
 * <li>"100 / 0" if evaluating any expression!</li>
 * <li>"(2 * 3) + foo" - variable names are not currently supported and random strings cannot be
 * valuated.</li>
 * </ul>
 * </p>
 * 
 * @author zhac067
 * @see CalculatorInterface
 * @see RevPolishCalc
 */
public class InvalidExpressionException extends Exception {
  /**
   * Auto-generated serial.
   */
  private static final long serialVersionUID = 7357549283037327818L;

}
