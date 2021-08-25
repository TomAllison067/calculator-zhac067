// $Id: TestOpStack.java 73 2020-12-02 09:47:06Z zhac067 $ $Author: zhac067 $

package ac.uk.rhul.zhac067.calculator.standard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ac.uk.rhul.zhac067.calculator.BadTypeException;
import ac.uk.rhul.zhac067.calculator.Symbol;

class TestOpStack {
  private static OpStack stack;

  @BeforeEach
  void setup() {
    stack = new OpStack();
  }

  @Test
  void testNewOpStackIsEmpty() {
    assertEquals(0, stack.size());
  }

  @Test
  void testPushThenPop() {
    Symbol plus = Symbol.PLUS;
    Symbol minus = Symbol.MINUS;
    stack.push(plus);
    stack.push(minus);
    assertEquals(2, stack.size());
    assertEquals(Symbol.MINUS, stack.pop());
    assertEquals(1, stack.size());
    assertEquals(Symbol.PLUS, stack.pop());
    assertEquals(0, stack.size());
  }
  
  @Test
  void testPeek() throws BadTypeException {
    Symbol plus = Symbol.PLUS;
    Symbol minus = Symbol.MINUS;
    stack.push(plus);
    stack.push(minus);
    assertEquals(Symbol.MINUS, stack.peek());
    assertEquals(2, stack.size());
    stack.pop();
    assertEquals(Symbol.PLUS, stack.peek());
    assertEquals(1, stack.size());
  }
  
  @Test
  void testEmptyStackThrowsException() {
    assertThrows(EmptyStackException.class, () -> stack.pop());
    stack.push(Symbol.PLUS);
    stack.pop();
    assertThrows(EmptyStackException.class, () -> stack.pop());
  }

}
