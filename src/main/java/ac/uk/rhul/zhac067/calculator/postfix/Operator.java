// $Id: Operator.java 34 2020-11-16 21:19:06Z zhac067 $ $Revision: 34 $

package ac.uk.rhul.zhac067.calculator.postfix;

/**
 * This interface represents some mathematical operator. An operator can evaluate two numbers,
 * depending on what the operator represents.
 * 
 * @author zhac067
 *
 */
public interface Operator {

  /**
   * Evaluate two floats a and b, and return the answer.
   * 
   * @return the result, evaluated appropriately for this operator.
   */
  public float eval(float a, float b);
}
