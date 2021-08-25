package ac.uk.rhul.zhac067.calculator;

/**
 * The <code>Type</code> enum represents the types an Entry can represent.
 * <p>
 * An Entry in this calculator can represent one of four types:
 * <ol>
 * <li>A number</li>
 * <li>A symbol (a mathematical operator, for example +, *, /, -)</li>
 * <li>A string (of characters, for example "(3 + 2) * 5"</li>
 * <li>An invalid type - we cannot do mathematics with this type.</li>
 * </ol>
 * <br>
 * This enum represents these types of entries.
 * </p>
 * 
 * @author zhac067
 * @see Entry
 * @see Type
 */
public enum Type {
  /**
   * A constant representing the Number type.
   */
  NUMBER("Number"),

  /**
   * A constant representing the Symbol type, eg "+", "-".
   */
  SYMBOL("Symbol"),

  /**
   * A constant representing the String type, eg "(3 + 2) * 2".
   */
  STRING("String"),

  /**
   * A constant representing the invalid type, eg "(Mary had a little lamb) * 10".
   */
  INVALID("Invalid");

  /**
   * A human-readable (ie, title case) description.
   */
  private String description;

  /**
   * Create a Type with a simple, printable description of what it is.
   *
   * @param a human-readable description
   */
  private Type(String description) {
    this.description = description;
  }

  /**
   * Returns the printable, human-readable description corresponding to an enum constant.
   * 
   * @return the description corresponding to this constant
   */
  @Override
  public String toString() {
    return description;
  }
}
