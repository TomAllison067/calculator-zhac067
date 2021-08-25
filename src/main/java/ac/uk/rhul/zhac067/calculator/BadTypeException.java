package ac.uk.rhul.zhac067.calculator;

/**
 * Thrown by methods in the Entry class to indicate that the wrong getter was called on a given
 * Entry object.
 * <p>
 * A BadTypeException is thrown by an Entry when a getter is called that does not correspond to that
 * Entry's type. For example, calling getValue() on an Entry with type String will throw a
 * BadTypeException.
 * </p>
 * 
 * @author zhac067
 * @see Entry
 * @see Type
 */
public class BadTypeException extends Exception {
  /**
   * Auto-generated serial.
   */
  private static final long serialVersionUID = -5306955252613066655L;

  /**
   * Throw a BadTypeException with an error message. Thrown when the wrong getter is called on an
   * Entry.
   * <p>
   * A good error message could show both the expected type and the actual type. For example:
   * </p>
   * <p>
   * <code>Error: getString() called. Expected Type.STRING but saw Type.FLOAT</code>
   * </p>
   * 
   * @param errorMessage the error message displayed when the wrong getter is called.
   */
  public BadTypeException(String errorMessage) {
    super(errorMessage);
  }
}
