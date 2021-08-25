package ac.uk.rhul.zhac067.calculator;

/**
 * The <code>Symbol</code> enum represents the non-number tokens allowed in an expression in this
 * calculator.
 * <p>
 * As well as numbers, tokens in this calculator include:
 * <ul>
 * <li>Parentheses</li>
 * <li>Mathematical operators (+, *, /, -)</li>
 * <li>Invalid tokens - we cannot do mathematics with these, and these will be handled later in
 * development</li>
 * </ul>
 * <br>
 * This enum represents these tokens. An Entry which has type Symbol will store one of these
 * constants.
 * </p>
 * 
 * @author zhac067
 * @see Entry
 * @see Type
 */
public enum Symbol {
  /**
   * A constant representing the left parenthesis.
   */
  LEFT_BRACKET("(", 0),

  /**
   * A constant representing the right parenthesis.
   */
  RIGHT_BRACKET(")", 0),

  /**
   * A constant representing the division operator.
   */
  DIVIDE("/", 2),

  /**
   * A constant representing the multiplication operator.
   */
  TIMES("*", 2),

  /**
   * A constant representing the addition operator.
   */
  PLUS("+", 1),
  /**
   * A constant representing the subtraction operator.
   */
  MINUS("-", 1),

  /**
   * A constant representing an invalid symbol. Whatever this is, we cannot use it for mathematics
   * in this calculator.
   */
  INVALID("?", 0);

  /**
   * A String consisting of the mathematical operator represented by this constant.
   */
  private String symbolString;

  private final int precedence;

  /**
   * Creates a Symbol with a String that contains the corresponding mathematical symbol.
   * 
   * @param symbolString the corresponding symbol, eg "*" for multiplication
   */
  private Symbol(String symbolString, int precedence) {
    this.symbolString = symbolString;
    this.precedence = precedence;
  }

  /**
   * Return the precedence of this symbol.
   * 
   * @return its precedence.
   */
  public int getPrecedence() {
    return this.precedence;
  }

  /**
   * Returns a String of the mathematical symbol corresponding to this enum constant.
   * 
   * @return the mathematical symbol corresponding to this constant
   */
  @Override
  public String toString() {
    return this.symbolString;
  }
}
