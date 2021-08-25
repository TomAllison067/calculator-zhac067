// $Id: TestNumStack.java 50 2020-11-24 08:56:19Z zhac067 $ $Revision: 50 $

package ac.uk.rhul.zhac067.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EmptyStackException;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestNumStack {
  static final float FLOAT_COMPARISON_DELTA = 0.0f;
  private static NumStack stack;

  @BeforeEach
  void setup() {
    stack = new NumStack();
  }

  @Test
  void testNewNumStackIsEmpty() {
    NumStack stack = new NumStack();
    assertEquals(true, stack.isEmpty());
    assertThrows(EmptyStackException.class, () -> stack.pop(),
        "Popping from a newly-created empty stack should throw an exception.");
  }

  @Test
  void testPushOneThenPop() throws BadTypeException {
    stack.push(1.0f);
    assertFalse(stack.isEmpty());
    assertEquals(1.0f, stack.pop(), FLOAT_COMPARISON_DELTA);
    assertTrue(stack.isEmpty());

  }

  @Test
  void testPushTwoThenPop() throws BadTypeException {
    stack.push(1.0f);
    stack.push(2.0f);
    assertEquals(2.0f, stack.pop(), FLOAT_COMPARISON_DELTA);
    assertFalse(stack.isEmpty());
    assertEquals(1.0f, stack.pop(), FLOAT_COMPARISON_DELTA);
    assertTrue(stack.isEmpty());
  }

  @Test
  void testRandomFloats() throws BadTypeException {
    Random rng = new Random();
    int numberOfEntries = rng.nextInt(100);
    Deque<Float> javaStack = new ArrayDeque<Float>(numberOfEntries);

    for (int i = 0; i < numberOfEntries; i++) {
      float next = rng.nextFloat();
      javaStack.push(next);
      stack.push(next);
    }
    assertFalse(stack.isEmpty());

    for (int i = numberOfEntries - 1; i >= 0; i--) {
      assertEquals(javaStack.pop(), stack.pop(), FLOAT_COMPARISON_DELTA);
    }
    assertTrue(stack.isEmpty());
  }

  @Test
  void testEmptyNumStackThrowsException() {
    stack.push(1.0f);
    stack.pop();
    assertThrows(EmptyStackException.class, () -> stack.pop(),
        "The stack should now be empty again.");
  }
}
