// $Id: Driver.java 93 2020-12-08 15:30:34Z zhac067 $ $Revision: 93 $

package ac.uk.rhul.zhac067.calculator;

import ac.uk.rhul.zhac067.calculator.views.AsciiView;
import ac.uk.rhul.zhac067.calculator.views.JavaFxView;
import ac.uk.rhul.zhac067.calculator.views.ViewInterface;

/**
 * The entry point for this program.
 * <p>
 * When the program starts, it checks if it was started from a terminal by testing
 * <code>System.console()</code>. If so, it launches the (not-yet-implemented) command line view.
 * Otherwise, if it was started using the runnable jar file (or using
 * <code>mvn javafx:run goal</code>) it calls <code>JavaFxLauncher.startJavaFx</code> to launch the
 * JavaFX view.
 * </p>
 * 
 * @author zhac067
 * @see JavaFxLauncher
 */
public class Driver {

  /**
   * Java programs are started by calling <code>main</code>. As such, this is how this program
   * starts!
   * 
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    @SuppressWarnings("unused")
    CalcController controller;
    if (System.console() != null) {
      controller = new CalcController(new AsciiView());
    } else {
      ViewInterface view = JavaFxView.getInstance();
      controller = new CalcController(view);
    }
    
  }
}
