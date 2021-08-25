// $Id: Operators.java 43 2020-11-18 22:24:03Z zhac067 $ $Revision: 43 $


package ac.uk.rhul.zhac067.calculator.postfix;

/**
 * This is an enum of members that implement the Operator interface.
 * 
 * <p>
 * An operator evaluates two numbers accordingly using its <code>eval</code> method, and this enum
 * contains those for addition, multiplication, division and subtraction.
 * </p>
 * 
 * @author zhac067
 * @see Operator
 */
public enum Operators implements Operator {
  
  /**
   * The addition operator.
   */
  PLUS {
    
    /**
     * Returns the result of a + b.
     */
    @Override
    public float eval(float a, float b) {
      return a + b;
    }
  },

  /**
   * The subtraction operator.
   */
  MINUS {
    
    /**
     * Returns the result of a - b.
     */
    @Override
    public float eval(float a, float b) {
      return a - b;
    }
  },

  /**
   * The multiplication operator.
   */
  TIMES {
    
    /**
     * Returns the result of a * b.
     */
    @Override
    public float eval(float a, float b) {
      return a * b;
    }
  },

  /**
   * The division operator.
   */
  DIVIDE {
    
    /**
     * Returns the result of a / b.
     */
    @Override
    public float eval(float a, float b) {
      return a / b;
    }

  }
}
