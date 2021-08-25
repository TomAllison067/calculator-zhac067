// $Id: CalculatorFactory.java 96 2020-12-08 17:40:58Z zhac067 $ $Author: zhac067 $

package ac.uk.rhul.zhac067.calculator;

import ac.uk.rhul.zhac067.calculator.postfix.RevPolishCalc;
import ac.uk.rhul.zhac067.calculator.standard.StandardCalc;

/**
 * A calculator factory.
 * <p>
 * Use this to construct get a CalculatorInterface class. It has an internal CalcType enum, which
 * corresponds to the type of calculator this factory can output. Each calculator is a singleton
 * when retrieved via this factory.
 * <ul>
 * <li>CalcType.POSTFIX</li>
 * <li>CalcType.INFIX</li>
 * </ul>
 * </p>
 * 
 * @author zhac067
 * @see RevPolCalc @see StandardCalc @see CalculatorInterface
 */
public class CalculatorFactory {
  private RevPolishCalc postfix = null;
  private StandardCalc infix = null;

  /**
   * Get a calculator.
   * 
   * @param type the type of calculator
   * @return the calculator.
   */
  public CalculatorInterface getCalculator(CalcType type) {
    if (type == CalcType.POSTFIX) {
      return getPostfix();
    } else {
      return getInfix();
    }
  }

  /**
   * Returns a singleton RevPolishCalc.
   */
  private RevPolishCalc getPostfix() {
    if (postfix == null) {
      postfix = new RevPolishCalc();
    }
    return postfix;
  }

  /**
   * Returns a singleton StandardCalc.
   */
  private StandardCalc getInfix() {
    if (infix == null) {
      infix = new StandardCalc();
    }
    return infix;
  }

  /**
   * An inner enum to represent the different types of calculator that can be created by this
   * factory.
   */
  enum CalcType {
    /** Reverse polish. */
    POSTFIX("Postfix"),
    /** Infix. */
    INFIX("Infix");
    
    private String name;
    
    private CalcType(String name) {
      this.name = name;
    }
    
    @Override
    public String toString() {
      return this.name;
    }
  }
}
