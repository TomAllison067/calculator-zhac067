// $Id: AsciiView.java 93 2020-12-08 15:30:34Z zhac067 $ $Revision: 93 $

package ac.uk.rhul.zhac067.calculator.views;

import java.util.Scanner;

/**
 * The command line view for this calculator.
 * 
 * @author zhac067
 *
 * @see ViewInterface
 */
public class AsciiView implements ViewInterface {
  /**
   * The help text displayed to the user.
   */
  private final String helpString = "Use one of the following:\n?<expression> to set the expression"
      + "\nc to calculate the expression\nx to change calculator type\nq to quit\n";

  /**
   * The answer of the last evaluated expression.
   */
  private String answer;

  /**
   * The expression to be evaluated.
   */
  private String expression;

  private Observer model = null;
  private Observer changeType = null;

  /**
   * Construct a new AsciiView.
   */
  public AsciiView() {}

  @Override
  public String getUserInput() {
    return expression;

  }

  @Override
  public void setAnswer(String answer) {
    this.answer = answer;
    System.out.println(this.answer);

  }

  @Override
  public void addCalcObserver(Observer o) {
    model = o;

  }

  @Override
  public void addTypeObserver(Observer o) {
    changeType = o;

  }

  @Override
  public void menu() {
    Scanner s = new Scanner(System.in);
    boolean finished = false;
    printHelp();

    while (!finished && s.hasNext()) {
      String t = s.nextLine();
      switch (t.toUpperCase().charAt(0)) {
        case 'C':
          model.update();
          break;
        case '?':
          expression = t.substring(1);
          break;
        case 'X':
          changeType.update();
          break;
        case 'Q':
          System.out.println("Bye!");
          finished = true;
          break;
        default:
          printHelp();

      }
    }
    s.close();
    System.exit(0);

  }

  /**
   * Returns the help string displayed to the user.
   */
  public String getHelpString() {
    return helpString;
  }

  /**
   * Prints the help string.
   */
  public void printHelp() {
    System.out.print(helpString);
  }
}
