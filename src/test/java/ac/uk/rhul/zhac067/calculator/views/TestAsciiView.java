// $Id: TestAsciiView.java 93 2020-12-08 15:30:34Z zhac067 $ $Revision: 93 $

package ac.uk.rhul.zhac067.calculator.views;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Thanks to https://www.baeldung.com/java-testing-system-out-println for testing printing outputs
 */
class TestAsciiView {
  private static AsciiView view;
  @SuppressWarnings("unused")
  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream output = new ByteArrayOutputStream();
  private final String expectedHelp =
      "Use one of the following:\n?<expression> to set the expression"
          + "\nc to calculate the expression\nx to change calculator type\nq to quit\n";

  @BeforeEach
  void setup() {
    view = new AsciiView();
    System.setOut(new PrintStream(output));

  }

  /*
   * Thanks to https://www.baeldung.com/java-testing-system-out-println
   */
  @Test
  void testHelp() {
    assertEquals(expectedHelp, view.getHelpString());
    view.printHelp();
    assertEquals(expectedHelp, output.toString());
  }

  @Test
  void testSetAnswer() throws IOException {
    view.setAnswer("1");
    assertEquals("1\n", output.toString()); // We test that the correct answer is
                                                        // printed
    output.reset();
    view.setAnswer("1234");
    assertEquals("1234\n", output.toString());
  }
  
  /*
   * I wanted to try and test the menu() function, which had lots of user input .etc...
   * but it was too hard - sorry!
   */
}
