// $Id: CalcController.java 96 2020-12-08 17:40:58Z zhac067 $ $Revision: 96 $

package ac.uk.rhul.zhac067.calculator;

import ac.uk.rhul.zhac067.calculator.CalculatorFactory.CalcType;
import ac.uk.rhul.zhac067.calculator.postfix.InvalidExpressionException;
import ac.uk.rhul.zhac067.calculator.postfix.RevPolishCalc;
import ac.uk.rhul.zhac067.calculator.views.ViewInterface;

/**
 * The controller.
 * 
 * @author zhac067
 *
 */
public class CalcController {
  private ViewInterface view;
  private CalculatorInterface currentEvaluator;
  private CalculatorFactory calcFactory;

  /**
   * Create a new controller and register it as an observer to a given view.
   * 
   * @param view the view to observe.
   */
  public CalcController(ViewInterface view) {
    this.view = view;
    currentEvaluator = new RevPolishCalc();
    calcFactory = new CalculatorFactory();
    view.addCalcObserver(this::handleCalculate);
    view.addTypeObserver(this::handleChangeState);
    view.menu();
  }

  /**
   * Handles the evaluation.
   */
  public void handleCalculate() {
    String expression = view.getUserInput();
    try {
      Float result = currentEvaluator.evaluate(expression);
      view.setAnswer(result.toString());
    } catch (InvalidExpressionException e) {
      view.setAnswer("Invalid expression.");
    }
  }

  /**
   * Handler to change the type of calculator in use.
   */
  public void handleChangeState() {
    CalcType type =
        currentEvaluator.getClass() == RevPolishCalc.class ? CalcType.INFIX : CalcType.POSTFIX;
    currentEvaluator = calcFactory.getCalculator(type);
    System.out.println("Evaluator model set to " + type.toString());
  }

  /**
   * Returns the current evaluator. Primarily used for testing.
   */
  public CalculatorInterface getCurrentEvaluator() {
    return currentEvaluator;
  }
}
