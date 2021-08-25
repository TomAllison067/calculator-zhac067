// $id Author$

package ac.uk.rhul.zhac067.calculator.standard;

import ac.uk.rhul.zhac067.calculator.BadTypeException;
import ac.uk.rhul.zhac067.calculator.Entry;
import ac.uk.rhul.zhac067.calculator.Stack;
import ac.uk.rhul.zhac067.calculator.Symbol;

/**
 * A stack of operators. An operator in this calculator is one of the following: +, -, *, /, (, )
 * 
 * @author zhac067
 */
public class OpStack {
  /**
   * The internal Stack that this class is a facade for.
   */
  private Stack stack;

  /**
   * Construct a new OpStack.
   */
  public OpStack() {
    this.stack = new Stack();
  }

  /**
   * Returns the number of elements currently in this stack.
   */
  public int size() {
    return stack.size();
  }

  /**
   * Push a new symbol onto the top of this stack.
   * 
   * @param symbol the symbol to push.
   */
  public void push(Symbol symbol) {
    stack.push(new Entry(symbol));
  }

  /**
   * Remove the symbol currently at the top of this stack and return it.
   * 
   * @return the symbol at the top of this stack.
   */
  public Symbol pop() {
    Entry entry = stack.pop();
    try {
      return entry.getSymbol();
    } catch (BadTypeException e) {
      return Symbol.INVALID;
    }
  }

  /**
   * Return the symbol at top of the stack, without removing it.
   * @return the symbol at the top of the stack.
   */
  public Symbol peek() {
    Entry entry = stack.top();
    try {
      return entry.getSymbol();
    } catch (BadTypeException e) {
      return Symbol.INVALID;
    }
  }
}
