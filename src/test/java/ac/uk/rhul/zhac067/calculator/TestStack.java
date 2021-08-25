package ac.uk.rhul.zhac067.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EmptyStackException;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Tests for the Stack class, shown in order of creation.
 * 
 * This class was developed AFTER the Entry class, and so I began straight away by pushing an Entry
 * onto the stack, rather than testing with ints.
 * 
 * I only used float Entry types to test this with. I saw no need to test different types of Entry,
 * as that any comparison logic was tested in the TestEntry class and this stack is only concerned
 * with storing entries, not validating them.
 * 
 * @author zhac067
 *
 */
class TestStack {

  private Stack stack;

  static final float FLOAT_COMPARISON_DELTA = 0.0f; // for comparing two floats

  @BeforeEach
  void setUp() {
    stack = new Stack();
  }

  /*
   * Test 1 - A new stack should have size zero.
   * 
   * To pass, I simply created the class with a size() method that always returns zero.
   */
  @Test
  void testNewStackIsEmpty() {
    assertEquals(0, stack.size(), "A new stack should have size zero.");
  }

  /*
   * Test 2 - A stack which has a single element pushed onto it should have a size of 1.
   * 
   * To pass, I created a new push() method, gave the Stack a size attribute, had push() set size to
   * 1, and returned this attribute from size().
   * 
   * At this point, it became convenient to create a setUp() method for this test class rather than
   * continue creating a new Stack in each individual test case.
   */
  @Test
  void testSinglePushHasSizeOne() {
    stack.push(new Entry(1.0f));
    assertEquals(1, stack.size(),
        "A new stack with one element pushed onto it should have a size of 1.");
  }

  /*
   * Test 4 - A new has size zero, and so is empty, and so should throw an exception when pop() is
   * called.
   * 
   * To pass, I created the pop() method which does nothing except throw an EmptyStackException.
   */
  @Test
  void testPopEmptyStackThrowsException() {
    assertThrows(EmptyStackException.class, () -> stack.pop(),
        "Popping from an empty stack should throw an exception.");
  }

  /*
   * Test 4 - testing the size when more than two elements are pushed and popped.
   * 
   * Initially, the size attribute was set to 0 by the constructor and to 1 by push(). To pass, I
   * had push() increment the size attribute, and pop() decrement it. I also had to move the "throws
   * EmptyStackException" size check to the start of my pop() method in order to avoid an exception
   * being thrown after an acceptable decrement.
   * 
   */
  @Test
  void testPushTwicePopTwiceSize() {
    stack.push(new Entry(1.0f));
    assertEquals(1, stack.size());
    stack.push(new Entry(2.0f));
    assertEquals(2, stack.size());
    stack.pop();
    assertEquals(1, stack.size());
    stack.pop();
    assertEquals(0, stack.size());
    assertThrows(EmptyStackException.class, () -> stack.pop());
  }

  /*
   * Test 5 - Test that pushing a single entry, and reading the popped value, does indeed return
   * this value.
   * 
   * To pass, I had to change pop() to return an Entry (as opposed to the previous void return). I
   * then gave the Stack class a single private Entry field, set this in the push() method and
   * returned it in the pop() method.
   * 
   * @throws BadTypeException
   */
  @Test
  void testSingleEntry() throws BadTypeException {
    stack.push(new Entry(1.0f));
    assertEquals(1.0f, stack.pop().getValue(), FLOAT_COMPARISON_DELTA);
  }

  /*
   * Test 6 - Test that pushing two different entries and then popping them returns these values in
   * the correct order.
   * 
   * This failed because the stack only stored one Entry. It became apparent that I needed a data
   * structure to store several Entry objects in, so I gave the Stack class an Entry array of size
   * 2, indexed by the size attribute, and returned values from this.
   * 
   */
  @Test
  void testTwoEntries() throws BadTypeException {
    stack.push(new Entry(1.0f));
    stack.push(new Entry(2.0f));
    assertEquals(2.0f, stack.pop().getValue(), FLOAT_COMPARISON_DELTA,
        "Pushing 1.0f, 2.0f, and popping once should return 2.0f");
    assertEquals(1.0f, stack.pop().getValue(), FLOAT_COMPARISON_DELTA,
        "Pushing 1.0f, 2.0f, and popping twice should return 1.0f");
  }

  /*
   * Test 7 - Next, I wanted to test that my stack could store lots of values - say, some random
   * number up to 250 - and return them in the correct order.
   * 
   * I used an ArrayDeque to create a test stack to compare my own stack to, popping each value in
   * turn and checking that it is indeed correct. I also decided to check the size at each point
   * while I was at it.
   * 
   * Straight away, I got an IndexOutOfBounds exception as I was simply using an array of size 2. A
   * sensible next step was to change my Stack class so it used an ArrayList instead of an array.
   * This resulted in a test pass.
   */
  @Test
  void testManyRandomEntries() throws BadTypeException {
    Random rng = new Random(); // Generate a random stack size, and random stack entries.
    Deque<Float> expectedStack = new ArrayDeque<Float>();

    int stackSize = 0;
    // We want a random number, but we may as well make sure it's a reasonably large random number.
    while (stackSize < 50) {
      stackSize = rng.nextInt(250);
    }

    // Push onto the stacks
    for (int i = 0; i < stackSize; i++) {
      float value = rng.nextFloat();
      expectedStack.push(value);
      stack.push(new Entry(value));
    }

    // Pop from each stack, checking values and sizes.
    for (int i = stackSize - 1; i >= 0; i--) {
      float expected = expectedStack.pop();
      float actual = stack.pop().getValue();
      assertEquals(expected, actual, FLOAT_COMPARISON_DELTA,
          "Expected " + expected + " but saw " + actual);
      assertEquals(expectedStack.size(), stack.size());
    }

    assertThrows(EmptyStackException.class, () -> stack.pop(),
        "The stack should now be empty again.");
  }

  /*
   * Test 8 - implementing the top() method, the last bit of functionality to add.
   * 
   * First, I simply created a top() method and had it throw an exception straight away. I then
   * pushed a value, and so the test failed again because top() only threw an exception. To fix
   * this, I had the method return the last value added in the stack's internal storage.
   * 
   * Just for good measure, I then pushed a second value and made sure top() returned this second
   * value and not the first (although I probably didn't need to do this).
   */
  @Test
  void testTop() throws BadTypeException {
    assertThrows(EmptyStackException.class, () -> stack.top(),
        "You cannot call top() on an empty stack.");
    stack.push(new Entry(42.0f));
    assertEquals(42.0f, stack.top().getValue(), FLOAT_COMPARISON_DELTA,
        "Expected the answer to life, the Universe and everything but saw " + stack.top());
    stack.push(new Entry(43.0f));
    assertEquals(43.0f, stack.top().getValue(), FLOAT_COMPARISON_DELTA,
        "Expected to see 43.0f but saw " + stack.top());
  }
  

}
