// $Id: TestCalculatorFactory.java 86 2020-12-06 15:40:57Z zhac067 $ $Author: zhac067 $

package ac.uk.rhul.zhac067.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ac.uk.rhul.zhac067.calculator.CalculatorFactory.CalcType;
import ac.uk.rhul.zhac067.calculator.postfix.RevPolishCalc;
import ac.uk.rhul.zhac067.calculator.standard.StandardCalc;

class TestCalculatorFactory {
  private static CalculatorInterface calc;
  private static CalculatorFactory factory;
  
  @BeforeEach
  void setup() {
    factory = new CalculatorFactory();
  }

  @Test
  void testGetPostfix() {
    calc = factory.getCalculator(CalcType.POSTFIX);
    assertEquals(RevPolishCalc.class, calc.getClass());
  }
  
  @Test
  void testGetInfix() {
    calc = factory.getCalculator(CalcType.INFIX);
    assertEquals(StandardCalc.class, calc.getClass());
  }
  
  @Test
  void testPostfixIsSingleton() {
    CalculatorInterface calc1 = factory.getCalculator(CalcType.POSTFIX);
    CalculatorInterface calc2 = factory.getCalculator(CalcType.POSTFIX);
    assertTrue(calc1 == calc2); // Test the memory addresses are equal
  }
  
  @Test
  void testInfixIsSingleton() {
    CalculatorInterface calc1 = factory.getCalculator(CalcType.INFIX);
    CalculatorInterface calc2 = factory.getCalculator(CalcType.INFIX);
    assertTrue(calc1 == calc2);
  }

}
