// $Id: TestOperators.java 43 2020-11-18 22:24:03Z zhac067 $ $Revision: 43 $


package ac.uk.rhul.zhac067.calculator.postfix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestOperators {
  static final float DELTA = 0.001f;
  
  @Test
  public void testSimplePlus() {
    Operator plus = Operators.PLUS;
    assertEquals(2.0f, plus.eval(1.0f, 1.0f), DELTA, ("1 + 1 = 2"));
  }
  
  @Test
  public void testSimpleMinus() {
    Operator minus = Operators.MINUS;
    assertEquals(1.0f, minus.eval(2.0f, 1.0f), DELTA, ("2 - 1 = 1"));
  }
  
  @Test
  public void testSimpleTimes() {
    Operator times = Operators.TIMES;
    assertEquals(9.0f, times.eval(6.0f, 1.5f), DELTA, ("6 * 1.5 = 9"));
  }
  
  @Test
  public void testSimpleDivides() {
    Operator divide = Operators.DIVIDE;
    assertEquals(6.0f, divide.eval(9.0f, 1.5f), DELTA, ("9 / 1.5 = 6"));
  }
}
