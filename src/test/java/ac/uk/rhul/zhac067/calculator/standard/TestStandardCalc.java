// $Id: TestStandardCalc.java 77 2020-12-03 21:18:16Z zhac067 $ $Author: zhac067 $

package ac.uk.rhul.zhac067.calculator.standard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ac.uk.rhul.zhac067.calculator.postfix.InvalidExpressionException;

class TestStandardCalc {
  private static final float FLOAT_DELTA = 0.0001f;
  private static StandardCalc calc;

  @BeforeAll
  static void setup() {
    calc = new StandardCalc();
  }

  @Test
  void testSimpleExpression() throws InvalidExpressionException {
    // These test cases only test the plus and minus operators, i.e. no brackets or precedence to
    // worry about.
    assertEquals(2.0f, calc.evaluate("1 + 1"), FLOAT_DELTA, "One plus one equals two.");
    assertEquals(5.0f, calc.evaluate("1 + 1 + 3"), FLOAT_DELTA,
        "One plus one plus three equals five.");
    assertEquals(7.0f, calc.evaluate("5 + 5 - 3"), FLOAT_DELTA,
        "Five plus five minus three equals seven.");
  }

  @Test
  void testPostfixExpressionThrowsException() throws InvalidExpressionException {
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("1 1 +"),
        "An infix calculator can't evaluate postfix expressions directly.");
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("3 5 *"),
        "An infix calculator can't evaluate postfix expressions directly.");
    assertThrows(InvalidExpressionException.class,
        () -> calc.evaluate("2 3 * 4 5 / - 9 8 * + 5 - 5 2 / -"),
        "An infix calculator can't evaluate postfix expressions directly.");
    assertThrows(InvalidExpressionException.class,
        () -> calc.evaluate("9 8 * 3 4 / + 0.52 0.98 * 12 / +"),
        "An infix calculator can't evaluate postfix expressions directly.");
  }

  @Test
  void testExpressionWithPrecedence() throws InvalidExpressionException {
    assertEquals(17.5f, calc.evaluate("2.5 + 3 * 5"), FLOAT_DELTA, "Expected 17.5");
    // Swap the order of operators - now precedence matters!
    assertEquals(17.5f, calc.evaluate("3 * 5 + 2.5"), FLOAT_DELTA, "Expected 17.5");
    // Just some random expression with lots of times and multiplication that I drew on a whiteboard
    assertEquals(69.7f, calc.evaluate("2 * 3 - 4 / 5 + 9 * 8 - 5 - 5 / 2"), FLOAT_DELTA);
    assertEquals(72.7925f, calc.evaluate("9 * 8 + 3 / 4 + 0.52 * 0.98 / 12"), FLOAT_DELTA);
  }
  
  @Test
  void testExpressionWithBrackets() throws InvalidExpressionException {
    assertEquals(9.0f, calc.evaluate("( 1 + 2 ) * 3"), FLOAT_DELTA);
    assertEquals(44.0f, calc.evaluate("( 9 + 2 ) * 8 / ( 3 - 1 )"), FLOAT_DELTA);
    assertEquals(9.0f, calc.evaluate("( ( 3 * 2 ) + 1 - ( 2 - 4 ) )"), FLOAT_DELTA);
  }

}
