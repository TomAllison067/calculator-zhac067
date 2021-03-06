// $Id: TestController.java 86 2020-12-06 15:40:57Z zhac067 $ $Revision$

package ac.uk.rhul.zhac067.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ac.uk.rhul.zhac067.calculator.postfix.RevPolishCalc;
import ac.uk.rhul.zhac067.calculator.standard.StandardCalc;
import ac.uk.rhul.zhac067.calculator.views.Observer;
import ac.uk.rhul.zhac067.calculator.views.ViewInterface;

public class TestController {
  private static ViewStub view;
  private static CalcController controller;
  
  @BeforeAll
  public static void setup() {
    view = new ViewStub();
    controller = new CalcController(view);
  }
  
  @Test
  public void testHandleCalculate() {
    view.calculate("1 1 +");
    assertEquals("2.0", view.getAnswer());
    view.calculate("5 8 * ");
    assertEquals("40.0", view.getAnswer());
    view.calculate("1 2 + +");
    assertEquals("Invalid expression.", view.getAnswer());
  }
  
  @Test
  public void testHandleChangeState() {
    // By default, the controller's current evaluator should be the reverse polish.
    assertEquals(RevPolishCalc.class, controller.getCurrentEvaluator().getClass());
    view.changeEvalType();
    // Then, change to standard
    assertEquals(StandardCalc.class, controller.getCurrentEvaluator().getClass());
    view.changeEvalType();
    // Back to postfix
    assertEquals(RevPolishCalc.class, controller.getCurrentEvaluator().getClass());
    
  }
  
  
  // A simple stub to with which to call controller methods.
  private static class ViewStub implements ViewInterface {
    private Observer evaluateMethodObserver = null;
    private Observer changeCalculatorTypeObserver = null;
    private String input = null;
    private String answer = null;
    

    @Override
    public String getUserInput() {
      return input;
    }

    @Override
    public void setAnswer(String answer) {
      this.answer = answer;

    }

    @Override
    public void addCalcObserver(Observer o) {
      this.evaluateMethodObserver = o;
    }

    @Override
    public void addTypeObserver(Observer o) {
      this.changeCalculatorTypeObserver = o;

    }

    @Override
    public void menu() {}

    public void calculate(String expr) {
      input = expr;
      evaluateMethodObserver.update();
    }

    public String getAnswer() {
      return answer;
    }
    
    public void changeEvalType() {
      changeCalculatorTypeObserver.update();
    }
  }
}
