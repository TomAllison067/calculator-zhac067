// $Id: TestSymbol.java 86 2020-12-06 15:40:57Z zhac067 $ $Revision: 86 $

package ac.uk.rhul.zhac067.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TestSymbol {

  @Test
  void testThereAreSevenSymbols() {
    assertEquals(7, Symbol.values().length, "The size of Symbol.values() should be seven.");
  }

  @Test
  void testEveryExpectedExpectedEnumExists() {
    Symbol[] expectedSymbols = {Symbol.LEFT_BRACKET, Symbol.RIGHT_BRACKET, Symbol.DIVIDE,
        Symbol.TIMES, Symbol.PLUS, Symbol.MINUS, Symbol.INVALID};
    for (int i = 0; i < Symbol.values().length; i++) {
      assertEquals(expectedSymbols[i], Symbol.values()[i],
          "Expected " + expectedSymbols[i] + " but saw " + Symbol.values()[i]);
    }
  }

  @Test
  void testEachConstantHasCorrectToStringDescription() {
    String[] expectedStrings = {"(", ")", "/", "*", "+", "-", "?"};
    for (int i = 0; i < Symbol.values().length; i++) {
      assertEquals(expectedStrings[i], Symbol.values()[i].toString(),
          "toString of " + Symbol.values()[i] + " should return" + expectedStrings[i]);
    }
  }

  @Test
  void testPrecedence() {
    // Starting from highest to lowest precedence, let's just test quickly that they're right 
    assertEquals(2, Symbol.DIVIDE.getPrecedence());
    assertEquals(2, Symbol.TIMES.getPrecedence());
    assertEquals(1, Symbol.PLUS.getPrecedence());
    assertEquals(1, Symbol.MINUS.getPrecedence());
    assertEquals(0, Symbol.LEFT_BRACKET.getPrecedence());
    assertEquals(0, Symbol.RIGHT_BRACKET.getPrecedence());
    assertEquals(0, Symbol.INVALID.getPrecedence());
  }
}
