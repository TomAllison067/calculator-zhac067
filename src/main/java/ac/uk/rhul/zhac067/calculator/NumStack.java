// $Id: NumStack.java 50 2020-11-24 08:56:19Z zhac067 $ $Revision: 50 $

package ac.uk.rhul.zhac067.calculator;

/**
 * This class represents a stack of numbers.
 * <p>
 * It is a facade of the Stack class, and indeed has a Stack attribute member. As such, it supports
 * the same usual methods <code>push</code> and <code>pop</code> as well as <code>isEmpty</code> for
 * use in evaluation algorithms by other classes.
 * </p>
 * 
 * @author zhac067
 * @see Stack
 */
public class NumStack {
  private Stack stack;

  /**
   * Construct a new NumStack.
   */
  public NumStack() {
    this.stack = new Stack();
  }

  /**
   * Checks if the NumStack is empty.
   * 
   * @return true if it is empty.
   */
  public boolean isEmpty() {
    return stack.size() == 0;
  }

  /**
   * Pushes a new number to this NumStack.
   * 
   * @param f the floating-point number to push.
   */
  public void push(float f) {
    stack.push(new Entry(f));

  }

  /**
   * Removes the number at the top of this NumStack and returns it.
   * 
   * @return the floating-point number at the top of this NumStack.
   */
  public float pop() {
    Entry entry = stack.pop();
    try {
      return entry.getValue();
    } catch (BadTypeException e) {
      e.printStackTrace();
      return Float.NEGATIVE_INFINITY;
    }
  }
}
