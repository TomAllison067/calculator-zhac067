package ac.uk.rhul.zhac067.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * A class of various simple tests for the Type enum.
 * 
 * This class has three tests, created in order, that together test that the enum has the correct
 * number of constants, named correctly and with the correct String attribute and overridden
 * toString() method.
 */
class TestType {

  /*
   * Test 1 - Test that there are indeed 4 enum constants in Type.
   * 
   * Step 1: From the UML diagram / project spec we know there are four types of entry in an Enum.
   * The most appropriate way to test this seemed to be to test the length with Type.vales().length.
   * 
   * Step 2: The test of course failed initially - so to pass, I declared four constants FOO, BAR,
   * BAZ, BANG (without any properties).
   * 
   * Step 3: After passing test 2 by creating new enum constants, there size of Type.values() was
   * now 8 - and so this test failed again. To pass, I removed the FOO, BAR, BAZ, BANG constants.
   */
  @Test
  void testThereAreFourTypes() {
    assertEquals(4, Type.values().length, "There should be four types of entry in the enum.");
  }

  /*
   * Test 2 - Check each expected enum constant is named appropriately and indeed is a member of the
   * enum.
   * 
   * Step 1: The names of the enum should be NUMBER, SYMBOL, STRING, INVALID. This could have been
   * broken down into an individual test case for each type: eg, testNumberIsThere,
   * testSymbolIsThere, but it's such a simple test case I think it's reasonable to keep it
   * together.
   * 
   * Step 2: Initially this would not compile (because the types were named FOO, BAR, BAZ, BANG) -
   * so to compile (and thus pass) I created new enum constants automatically using Eclipse.
   * 
   * Step 3: Now both tests 1 and 2 failed because there were too many constants and in the wrong
   * order, so I removed the FOO, BAR, BAZ, BANG constants to pass both tests.
   * 
   * Test 1 is now redudant (because this test by definition also checks that there are 4 constants)
   * - but I've kept it to show my progress.
   * 
   * Step 4: I refactored it to use an ordered Type[] array and a loop.
   */
  @Test
  void testEveryExpectedEnumExists() {

    // assertEquals(Type.values()[0], Type.NUMBER);
    // assertEquals(Type.values()[1], Type.SYMBOL);
    // assertEquals(Type.values()[2], Type.STRING);
    // assertEquals(Type.values()[3], Type.INVALID);

    Type[] expectedTypes = {Type.NUMBER, Type.SYMBOL, Type.STRING, Type.INVALID};
    for (int i = 0; i < Type.values().length; i++) {
      assertEquals(expectedTypes[i], Type.values()[i],
          "Expected " + expectedTypes[i] + " but saw " + Type.values()[i]);
    }
  }

  /*
   * Test 3 - This checks each enum member has the correct description (and by extension, that each
   * description is indeed different).
   * 
   * Step 1: I reasoned that each constant would have a simple toString() override that returns a
   * plain English description (eg "Number"). To test, I call toString() on each constant and check
   * it matches the expected description. This failed first time, returning the uppercase enum
   * names.
   * 
   * Step 2: To pass, the simplest solution was simply to add a Str field to the enum and return
   * that from the toString() method.
   * 
   * Step 3: I refactored the test to use an ordered array of expected strings and to loop through
   * the enum values.
   */
  @Test
  void testEachConstantHasCorrectToStringDescription() {
    // OLD TEST
    // assertEquals(Type.values()[0].toString(), "Number");
    // assertEquals(Type.values()[1].toString(), "Symbol");
    // assertEquals(Type.values()[2].toString(), "String");
    // assertEquals(Type.values()[3].toString(), "Invalid");

    String[] expectedStrings = {"Number", "Symbol", "String", "Invalid"};
    for (int i = 0; i < Type.values().length; i++) {
      assertEquals(expectedStrings[i], Type.values()[i].toString(),
          "toString of " + Type.values()[i] + " should return " + expectedStrings[i]);
    }
  }
}
