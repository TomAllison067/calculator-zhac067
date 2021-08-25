package ac.uk.rhul.zhac067.calculator;

/**
 * The <code>Entry</code> class represents an entry in the calculator, corresponding to a number,
 * mathematical symbol, or string of tokens.
 * <p>
 * An entry can be one of several things in this calculator:
 * <ul>
 * <li>A mathematical symbol, e.g., + or -</li>
 * <li>A number</li>
 * <li>A String, e.g., "(3 * 2) + 9"</li>
 * </ul>
 * <br>
 * An Entry can be one and only one of these types. You can access the Entry's type, or what value
 * is represented, by using one of the provided getter methods. These getters correspond to the
 * Entry's Type, and a BadTypeException is thrown if you call the wrong getter.
 * </p>
 * 
 * @author zhac067
 * @see BadTypeException
 * @see Symbol
 * @see Type
 * @see Stack
 */
public class Entry {
  /*
   * The Type this Entry represents.
   */
  private Type type;

  /**
   * The Symbol this Entry represents, if it is of Type.SYMBOL.
   */
  private Symbol symbol;

  /**
   * The String represented by this Entry, if it is of Type.STRING.
   */
  private String stringRepresentation;

  /**
   * The numerical value represented by this entry, if it is of Type.NUMBER.
   */
  private float number;

  /**
   * Creates an Entry of float type.
   * 
   * @param number the numeric value to be represented by this Entry.
   */
  public Entry(float number) {
    type = Type.NUMBER;
    this.number = number;
  }

  /**
   * Creates an Entry of String type.
   * 
   * @param stringRepresentation a sequence of tokens. This represents some mathemetical equation,
   *        eg "(2 + 3) * 2".
   */
  public Entry(String stringRepresentation) {
    type = Type.STRING;
    this.stringRepresentation = stringRepresentation;
  }

  /**
   * Creates an Entry with the Symbol type.
   * 
   * @param symbol the mathematical symbol to be represented by this Entry. This corresponds to a
   *        Symbol enum constant.
   * @see Symbol
   */
  public Entry(Symbol symbol) {
    type = Type.SYMBOL;
    this.symbol = symbol;
  }

  /**
   * Returns the type of this entry.
   * 
   * @return the type. Either symbol, number, string or INVALID.
   * @see Type
   */
  public Type getType() {
    return type;
  }

  /**
   * Returns the value belonging to this Entry, or throws an exception if this Entry does not have
   * the NUMBER type.
   * 
   * @return the numerical value.
   * @throws BadTypeException if this Entry does not have the NUMBER type.
   */
  public float getValue() throws BadTypeException {
    if (type != Type.NUMBER) {
      throw new BadTypeException(
          "Error, getValue called: expected Number type, but saw " + this.type);
    }
    return number;
  }

  /**
   * Returns the String belonging to this Entry, or throws an exception if this Entry does not have
   * the STRING type.
   * 
   * @return the corresponding String.
   * @throws BadTypeException if this Entry does not have the STRING type.
   */
  public String getString() throws BadTypeException {
    if (type != Type.STRING) {
      throw new BadTypeException("Error, getString called: expected String type, but saw " + type);
    }
    return stringRepresentation;
  }

  /**
   * Returns the Symbol belonging to this Entry, or throws an exception if this Entry does not have
   * the SYMBOL type.
   * 
   * @return the corresponding Symbol.
   * @throws BadTypeException if this Entry does not have the SYMBOL type.
   */
  public Symbol getSymbol() throws BadTypeException {
    if (type != Type.SYMBOL) {
      throw new BadTypeException("Error, getSymbol called: expected Symbol type, but saw " + type);
    }
    return symbol;
  }

  /**
   * An implementation of hashCode for the Entry type. The hashCode is calculated using a prime
   * number and various operations on the attributes of this class.
   * <p>
   * Credit to <em><a href="
   * https://stackoverflow.com/questions/113511/best-implementation-for-hashcode-method-for-a-collection">
   * this post</a></em> for providing a simple, effective implementation.
   * </p>
   *
   * @return this object's hashCode.
   */
  @Override
  public int hashCode() {
    int prime = 37;
    int result = 1;
    result = prime * result + Float.floatToIntBits(number);
    result = prime * result + (symbol == null ? 0 : symbol.hashCode());
    result = prime * result + (type == null ? 0 : type.hashCode());
    result = prime * result + (stringRepresentation == null ? 0 : stringRepresentation.hashCode());
    return result;
  }

  /**
   * Tests whether this Entry is equivalent to another Entry. Two entries are equivalent if they
   * have the same type, and the same:
   * <p>
   * <ul>
   * <li><strong>value</strong>, for float entries or</li>
   * <li><strong>stringRepresentation</strong>, for string entries or</li>
   * <li><strong>symbol</strong>, for symbol entries</li>
   * </ul>
   * </p>
   * 
   * @return whether a given Entry is equivalent to this one.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Entry other = (Entry) obj;
    if (this.type != other.type) {
      return false;
    }
    if (Float.compare(this.number, other.number) != 0) {
      return false;
    }
    if (this.symbol != other.symbol) {
      return false;
    }
    if (this.type == Type.STRING && other.type == Type.STRING) {
      if (this.stringRepresentation == null || other.stringRepresentation == null) {
        return false;
      }
      return (this.stringRepresentation.equals(other.stringRepresentation));
    }
    return true;
  }
}
