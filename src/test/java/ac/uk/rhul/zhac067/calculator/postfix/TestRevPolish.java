// $Id: TestRevPolish.java 65 2020-11-25 20:17:09Z zhac067 $ $Revision: 65 $

package ac.uk.rhul.zhac067.calculator.postfix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestRevPolish {
  static final float FLOAT_DELTA = 0.0001f;
  static RevPolishCalc eval;
  
  @BeforeEach
  public void setup() {
    eval = new RevPolishCalc();
  }

  @Test
  public void testSimpleExpression() throws InvalidExpressionException {
    assertEquals(2.0f, eval.evaluate("1 1 +"), FLOAT_DELTA, "1 1 + should evaluate to 2");
  }
  
  @Test
  public void testPlusTwice() throws InvalidExpressionException {
    assertEquals(5.0f, eval.evaluate("2 3 +"), FLOAT_DELTA, "2 3 + should evaluate to 5");
    assertEquals(110.0f, eval.evaluate("50 50 + 10 +"), FLOAT_DELTA, "50 50 + 10 + should evaluate to 110");
  }
  
  @Test
  public void testMinus() throws InvalidExpressionException {
    assertEquals(102.0f, eval.evaluate("105 3 - "), FLOAT_DELTA, "105 3 - should evaluate to 102");
    assertEquals(4999.0f, eval.evaluate("2500 2500 + 1 -"), FLOAT_DELTA, "2500 2500 + 1 - should evaluate to 4999");
  }
  
  @Test
  public void testComplexExpression() throws InvalidExpressionException {
    String someComplexExpression = "3 2 + 11.5 * 3 4 / - 3.14 +"; // Should be 59.89
    assertEquals(59.89f, eval.evaluate(someComplexExpression), FLOAT_DELTA);
  }
  
  @Test
  public void testInvalidExpressionStartsWithOperator() {
    assertThrows(InvalidExpressionException.class, () -> eval.evaluate("+ 1 2")); // Clearly wrong - not how postfix works
    assertThrows(InvalidExpressionException.class, () -> eval.evaluate("+ 5 5 * 6 +"));
  }
  
  @Test
  public void testUnbalancedExpressionThrowsException() {
    assertThrows(InvalidExpressionException.class, () -> eval.evaluate("1 1 + +"));
    assertThrows(InvalidExpressionException.class, () -> eval.evaluate("1 1 + 1"));
    assertThrows(InvalidExpressionException.class, () -> eval.evaluate("1 1 + 2 + /"));
    assertThrows(InvalidExpressionException.class, () -> eval.evaluate("1 1 1 + + +"));
  }
  
  @Test
  public void testNotNumberOrOperatorThrowsException () {
    assertThrows(InvalidExpressionException.class, () -> eval.evaluate("1 1 a"));
    assertThrows(InvalidExpressionException.class, () -> eval.evaluate("a b c d e f g"));
    assertThrows(InvalidExpressionException.class, () -> eval.evaluate("alpha 4 + "));
  }
}
