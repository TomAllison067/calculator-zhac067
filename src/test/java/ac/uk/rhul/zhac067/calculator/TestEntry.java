package ac.uk.rhul.zhac067.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/*
 * This class contains tests for the Entry class and for the BadTypeException class (as these are
 * only thrown by an Entry). They were created in the shown order.
 */
class TestEntry {
  private Entry entry;

  /*
   * Test 1 - Test that a constructor does indeed exist and creates an Entry object.
   * 
   * Step 1: The test wouldn't compile before creating the Entry class, so I created a new empy
   * Entry class.
   * 
   * This test became redundant - as I developed the specific three constructors, the generic
   * constructor was removed.
   *
   */
  // @Test
  // void testConstructor() {
  // entry = new Entry();
  // assertNotNull(entry, "The constructor creates an object.");
  // }

  /*
   * Test 2 - Test the functionality of a float constructor - ie, that getType() returns Type.NUMBER
   * and getValue() returns the passed-in float parameter, and that getString() and getSymbol()
   * throw a BadTypeException.
   * 
   * Step 1: The test wouldn't compile, so I created the appropriate constructor (with float
   * parameter), gave the class a float attribute, getType() and getValue() methods. Then, I simply
   * faked the return from getType() to return Type.NUMBER and getValue() to return the passed in
   * parameter (in this case 1.0f).
   * 
   * Step 2: I added the getString() and getSymbol() methods to the class and created an empty
   * BadTypeException class to be thrown. getString() and getSymbol() did nothing except throw this
   * exception.
   * 
   * Step 3: After working on test 3 and implementing BadTypeException, I had to refactor the test
   * slightly.
   */
  @Test
  void testFloatEntryConstructorAndException() throws BadTypeException {
    entry = new Entry(1.0f);
    assertEquals(Type.NUMBER, entry.getType(),
        "The float constructor constructs an Entry with type NUMBER.");
    assertEquals(1.0f, entry.getValue());
    assertThrows(BadTypeException.class, () -> entry.getString(),
        "getString() does not work on a number Entry.");
    assertThrows(BadTypeException.class, () -> entry.getSymbol(),
        "getSymbol() does not work on a number Entry.");
  }

  /*
   * Test 3 - Test the functionality of the String constructor, ie that getType() returns
   * Type.STRING and that getValue() and getSymbol() throw a BadTypeException
   * 
   * Step 1: Created an appropriate String constructor to let it compile. And then the test failed -
   * e.getType() still only returned Type.FLOAT. The bare minimum code was to change the method to
   * return Type.STRING instead. This of course meant test 2 failed.
   * 
   * Step 2: The next step was to create a Type attribute in the Entry class, and return this
   * attribute from the getType() - and now this test and test 2 passed. I was using "Entry e" in my
   * test code a few times now, so I declared a static Entry object at the top of this test class.
   * 
   * Step 3: To throw the correct exception, I changed getValue() to throw BadTypeException. Again,
   * this meant test 2 failed (because it expected 1.0f). To make test 2 pass again, I made
   * getValue() return '1.0f' if the type had Type.NUMBER, else throw an exception.
   * 
   * Step 4: I forgot to check that getString() returns the correct String! To solve this, I made
   * getString() return "1 + 1 = 2" if the Entry has Type.STRING, else throw an exception. I added
   * this after the assertThrows() tests to be consistent with other tests.
   */
  @Test
  void testStringEntryConstructorAndException() throws BadTypeException {
    entry = new Entry("1 + 1 = 2");
    assertEquals(Type.STRING, entry.getType(),
        "The String constructor creates an Entry with type STRING.");
    assertEquals("1 + 1 = 2", entry.getString());
    assertThrows(BadTypeException.class, () -> entry.getValue(),
        "getValue() does not work on a String Entry.");
    assertThrows(BadTypeException.class, () -> entry.getSymbol(),
        "getSymbol() does not work on a String Entry.");
  }

  /*
   * Test 4 - Test the functionality of the Symbol constructor, ie that getType() returns
   * Type.SYMBOL, that getSymbol() returns the passed-in Symbol and that getValue() and getString()
   * throw appropriate exceptions.
   * 
   * Step 1: To pass the first assertion, I had the appropriate constructor set the type in Entry.
   * 
   * Step 2: To pass the second assertion, I had the getSymbol method return Symbol.PLUS if the
   * entry has Type.SYMBOL, else throw an exception. getString() and getValue() already threw a
   * BadTypeException, so nothing to do here.
   */
  @Test
  void testSymbolEntryConstructorAndException() throws BadTypeException {
    entry = new Entry(Symbol.PLUS);
    assertEquals(Type.SYMBOL, entry.getType(),
        "The Symbol constructor creates an entry with type SYMBOL");
    assertEquals(Symbol.PLUS, entry.getSymbol(),
        "Expected Symbol.PLUS but saw " + entry.getSymbol());
    assertThrows(BadTypeException.class, () -> entry.getValue(),
        "getValue() does not work on a Symbol Entry.");
    assertThrows(BadTypeException.class, () -> entry.getString(),
        "getString() does not work on a Symbol Entry.");
  }

  /*
   * Test 5 - The BadTypeException errors should throw appropriate, useful messages.
   * 
   * Step 1: I defined what messages I would like in the third argument of the assertions below. I
   * then tested type of Entry to make sure appropriate messages would be thrown.
   * 
   * Step 2: The test failed. To pass, I had to create an appropriate constructor with a String in
   * the BadTypeException class and then modify the error throws in the Entry class to take this
   * into account.
   */
  @Test
  void testAppropriateErrorMessages() {
    BadTypeException e;
    // First, test the Number type of Entry.
    entry = new Entry(1.0f);
    e = assertThrows(BadTypeException.class, () -> entry.getString());
    assertEquals("Error, getString called: expected String type, but saw " + entry.getType(),
        e.getMessage());
    e = assertThrows(BadTypeException.class, () -> entry.getSymbol());
    assertEquals("Error, getSymbol called: expected Symbol type, but saw " + entry.getType(),
        e.getMessage());

    // Now, test the Symbol type of Entry.
    entry = new Entry(Symbol.PLUS);
    e = assertThrows(BadTypeException.class, () -> entry.getString());
    assertEquals("Error, getString called: expected String type, but saw " + entry.getType(),
        e.getMessage());
    e = assertThrows(BadTypeException.class, () -> entry.getValue());
    assertEquals("Error, getValue called: expected Number type, but saw " + entry.getType(),
        e.getMessage());

    // Finally, test the String type of Entry.
    entry = new Entry("1 + 2 = 3");
    e = assertThrows(BadTypeException.class, () -> entry.getValue());
    assertEquals("Error, getValue called: expected Number type, but saw " + entry.getType(),
        e.getMessage());
    e = assertThrows(BadTypeException.class, () -> entry.getSymbol());
    assertEquals("Error, getSymbol called: expected Symbol type, but saw " + entry.getType(),
        e.getMessage());
  }

  /*
   * Test 6 - Different Entries with of Number type with different values should have different
   * values.
   * 
   * To pass: This failed because each getValue() call was just returning "1.0f". To pass, I added a
   * value field to the Entry class, instantiated it in the float constructor and returned this from
   * getValue().
   */
  @Test
  void testTwoNumberEntriesHaveDifferentValues() throws BadTypeException {
    Entry num1 = new Entry(2.0f);
    Entry num2 = new Entry(1.0f);
    assertNotEquals(num1.getValue(), num2.getValue(),
        "Two entries constructed with different float values "
            + "should return different numbers from getValue().");
  }

  /*
   * Test 7 - Different Entries of String type should indeed return different strings from
   * getString().
   * 
   * To pass: This failed because each getString() call was just returning "1 + 1 = 2". To pass, I
   * added a String field to the Entry class, instantiated it in the String constructor and returned
   * it from getString() appropriately.
   */
  @Test
  void testTwoStringEntriesHaveDifferentStrings() throws BadTypeException {
    Entry string1 = new Entry("1 + 1 = 2");
    Entry string2 = new Entry("3 * 3 = 9");
    assertNotEquals(string1.getString(), string2.getString(),
        "Two entries constructed with different strings "
            + "should return different strings with getString().");
  }

  /*
   * Test 8 - Different Entries of Symbol type should indeed return different Symbols from
   * getSymbol().
   * 
   * To pass: getSymbol() was only returning Symbol.PLUS from the earlier stages, so I added a
   * Symbol field to the Entry class, instantiated it in the Symbol constructor and returned it from
   * getSymbol().
   */
  @Test
  void testTwoSymbolEntriesHaveDifferentSymbols() throws BadTypeException {
    Entry symbol1 = new Entry(Symbol.PLUS);
    Entry symbol2 = new Entry(Symbol.MINUS);
    assertNotEquals(symbol1.getSymbol(), symbol2.getSymbol(),
        "Two entries constructed with different symbols"
            + " should return different symbols with getSymbol().");
  }


  /*
   * Test 9 - We need to implement the hashCode method in order to later implement equals().
   * 
   * Step 1: I created two Entrys of the same type and parameter, and faked hashCode() to simply
   * return a single integer.
   * 
   * Step 2: I created a third Entry of the same type, but different symbol, and faked hashCode()
   * with an if, else condition related to the symbol.
   * 
   * Step 3: I created an Entry of different type, and so this has a different hashCode. By this
   * point, it became appropriate to actually implement hashCode() properly as opposed to more
   * if/else conditions.
   */
  @Test
  void testHashCode() throws BadTypeException {
    Entry plus1 = new Entry(Symbol.PLUS);
    Entry plus2 = new Entry(Symbol.PLUS);

    // These two entries have the same symbol and are equivalent.
    assertTrue(plus1.hashCode() == plus2.hashCode(),
        "Two equivalent Entry objects have the same hashCode.");

    Entry minus = new Entry(Symbol.MINUS);

    // These two entries have a different symbol, and are not equivalent.
    assertFalse(plus1.hashCode() == minus.hashCode(),
        "Two non-equivalent Entry objects have different hashCodes.");

    Entry float1 = new Entry(1.0f);

    // These two entries have a different type, and are not equivalent.
    assertFalse(minus.hashCode() == float1.hashCode(),
        "Two equivalent Entry objects have the same hashCode.");
  }

  /*
   * Test 10 - Having implemented hashCode, we need to implement equals. From the project
   * specification, two entries are equal if they have the same type, and same value.
   * 
   * Step 1: I created two different entries and simply faked equals() to return true in all cases
   * with assertNotEquals.
   * 
   * Step 2: I tested an entry for equality with null. My faked implementation failed the test, so I
   * made equals() return false if the other object is null.
   * 
   * Step 3: I tested the object for equality with a non-Entry class. The test failed, so I added a
   * class check in equals().
   * 
   * Step 4: I created another float Entry with a different value. To pass the test, I added a check
   * for the entry's value in equals().
   * 
   * Step 5: I created three different symbol entries. To pass, I then had to add a Symbol check. I
   * followed this same process for string entries.
   * 
   * Step 6: Finally, to double check that different types were unequal, I added a type check.
   * 
   * I am now confident in my Entry class.
   */
  @Test
  void testEquality() throws BadTypeException {
    Entry float1 = new Entry(1.0f);
    Entry float2 = new Entry(1.0f);
    assertEquals(float1, float2,
        "Two Number entries with the same numerical value are equivalent.");

    assertNotEquals(float1, null, "An Entry is not equivalent to null.");

    Integer notAnEntry = 42; // the answer to life, the universe and everything
    assertNotEquals(float1, notAnEntry, "An Entry cannot be equivalent to a non-Entry object.");

    Entry float3 = new Entry(2.0f);
    assertNotEquals(float1, float3);

    // Now, check symbol equality - two entries with the same symbol are equal, two entries with
    // different symbols are not.
    Entry symbol1 = new Entry(Symbol.PLUS);
    Entry symbol2 = new Entry(Symbol.MINUS);
    Entry symbol3 = new Entry(Symbol.PLUS);
    assertNotEquals(symbol1, symbol2, "Two Entry objects with the same Symbol are equivalent.");
    assertEquals(symbol1, symbol3, "Two Entry objects with different Symbols are not equivalent.");
    assertNotEquals(symbol1, notAnEntry, "An Entry cannot be equivalent to a non-Entry object.");

    // Now do a similar thing for string entries.
    Entry string1 = new Entry("foo");
    Entry string2 = new Entry("bar");
    Entry string3 = new Entry("foo");
    assertNotEquals(string1, string2, "Two Entry objects with the same String are equivalent.");
    assertEquals(string1, string3, "Two Entry objects with different Strings are not equivalent.");
    assertNotEquals(string1, notAnEntry, "An Entry cannot be equivalent to a non-Entry object.");


    // Finally, check for type equality.
    assertNotEquals(float1, symbol1, "A Number Entry and a Symbol Entry are not equivalent.");
    assertNotEquals(float1, string1, "A Number Entry and a String Entry are not equivalent.");
    assertNotEquals(symbol1, string1, "A Symbol Entry and a String Entry are not equivalent.");
  }
}
