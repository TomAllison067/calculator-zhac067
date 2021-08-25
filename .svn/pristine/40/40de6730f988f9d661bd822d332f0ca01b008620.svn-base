package ac.uk.rhul.zhac067.calculator;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * The <code>Stack</code> class represents a last-in-first-out stack of Entry objects.
 * <p>
 * The class supports the usual <code>push</code> and <code>pop</code> operations, as well as the
 * <code>top</code> operation to see the top item on the stack without removing it, and
 * <code>size</code> operation to return how many elements the stack contains.
 * </p>
 * <p>
 * When a stack is first created, it contains no items. Calling <code>push</code>, <code>pop</code>,
 * or <code>top</code> on an empty stack will throw an <code>EmptyStackException</code>.
 * </p>
 * 
 * @author zhac067
 * @see Entry
 * @see EmptyStackException
 */
public class Stack {
  /**
   * The internal storage of this Stack. Initialised as an ArrayList by the constructor.
   */
  private List<Entry> entries;

  /**
   * Creates an empty Stack.
   */
  public Stack() {
    entries = new ArrayList<Entry>();
  }

  /**
   * Gets the size of the Stack.
   * 
   * @return how many Entry objects are currently stored in this Stack.
   */
  public int size() {
    return entries.size();
  }

  /**
   * Pushes a new Entry onto the top of this Stack.
   * 
   * @param entry the Entry to be pushed onto this Stack.
   */
  public void push(Entry entry) {
    entries.add(entry);
  }

  /**
   * Removes the Entry at the top of this stack and returns it.
   * 
   * @return the Entry removed from the top of this stack.
   * @throws EmptyStackException if the stack is empty.
   */
  public Entry pop() throws EmptyStackException {
    if (entries.size() == 0) {
      throw new EmptyStackException();
    }
    return entries.remove(entries.size() - 1);
  }

  /**
   * Retrieves and returns, but does not remove, the Entry at the top of this stack.
   * 
   * @return the Entry at the top of this stack, without removing it from the Stack.
   * @throws EmptyStackException if the stack is empty.
   */
  public Entry top() throws EmptyStackException {
    if (entries.size() == 0) {
      throw new EmptyStackException();
    }
    return entries.get(entries.size() - 1);
  }

}
