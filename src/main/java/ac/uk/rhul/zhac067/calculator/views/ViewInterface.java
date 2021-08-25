// $Id: ViewInterface.java 57 2020-11-24 14:51:17Z zhac067 $ $Revision: 57 $

package ac.uk.rhul.zhac067.calculator.views;

/**
 * Represents a view in this calculator.
 * 
 * @author zhac067
 */
public interface ViewInterface {

  /**
   * Get the user input from the view.
   * 
   * @return the String representing the inputted mathematical expression.
   */
  public String getUserInput();

  /**
   * Update this view to show the answer of the last evaluated expression.
   * 
   * @param answer the answer.
   */
  public void setAnswer(String answer);

  /**
   * Add an observer to this view to be notified when the user wishes to evaluate an expression.
   * 
   * @param o the observer to be notified.
   */
  public void addCalcObserver(Observer o);

  /**
   * Add an observer to this view to be notified when the user wishes to change the evaluation type.
   * I.e., when switching from postfix to standard notation or vice versa.
   * 
   * @param o observer.
   */
  public void addTypeObserver(Observer o);
  
  /**
   * Display the menu to the user.
   */
  public void menu();
}
