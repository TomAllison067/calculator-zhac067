// $Id: JavaFxView.java 86 2020-12-06 15:40:57Z zhac067 $ $Revision: 86 $

package ac.uk.rhul.zhac067.calculator.views;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * This is the JavaFX view class for the calculator, filled by the FXML loader at run time.
 * 
 * @author zhac067
 */
public class JavaFxView extends Application implements ViewInterface {
  /*
   * The scene's width - the same value as the preferred width of the GridPane in GuiConfig.fxml.
   */
  private static final int SCENE_WIDTH = 300;

  /*
   * The scene's height - the same value as the preferred height of the GridPane in GuiConfig.fxml.
   */
  private static final int SCENE_HEIGHT = 240;

  /**
   * The text field for the user to input the expression to be evaluated.
   */
  @FXML
  private TextField inputTextField;

  /**
   * The button pressed to evaluate the expression.
   */
  @FXML
  private Button calculateButton;

  /**
   * A radio button to set the calculator to evaluate infix expressions.
   */
  @FXML
  private RadioButton infixRadio;

  /**
   * A radio button to set the calculator to evaluate postfix (reverse polish) expressions.
   */
  @FXML
  private RadioButton postfixRadio;

  /**
   * A group for the radio buttons.
   */
  @FXML
  private ToggleGroup radioToggleGroup;

  /**
   * A label to point the user to the result of their evaluated expression.
   */
  @FXML
  private Label resultLabel;

  /**
   * A label to display the result of the evaluated expression.
   */
  @FXML
  private Label resultOutputLabel;

  /**
   * The menu.
   */
  @FXML
  private Menu menu;

  /**
   * The only item in the menu - the "help" button.
   */
  @FXML
  private MenuItem menuItem;

  /**
   * A panel to display helpful text to the user.
   */
  private HelpPane helpPane;

  /**
   * The singleton instance of this view. Set by getInstance.
   */
  private static volatile JavaFxView instance = null;

  @FXML
  void initialize() {
    instance = this;
  }

  /**
   * Returns the singleton instance of this view.
   */
  public static synchronized JavaFxView getInstance() {
    if (instance == null) {
      new Thread(() -> Application.launch(JavaFxView.class)).start();
      while (instance == null) {
      }
    }
    return instance;

  }


  /**
   * A callback for JavaFX when the toolkit is initialised.
   * <p>
   * It first loads GuiConfig.fxml to load the GUI object heirarchy, then uses this to build a
   * JavaFX scene which is shown to the user.
   * </p>
   * 
   * @param primaryStage the stage to attach the newly create scene.
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(JavaFxView.class.getResource("GuiConfig.fxml"));
    Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
    primaryStage.setTitle("The CS2800 Calculator");
    primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("calculator-icon.png")));
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  @Override
  public String getUserInput() {
    System.out.println("Getting user input: " + inputTextField.getText());
    return inputTextField.getText();
  }

  @Override
  public void setAnswer(String answer) {
    System.out.println("Setting answer to: " + answer);
    resultOutputLabel.setText(answer);

  }

  @Override
  public void addCalcObserver(Observer o) {
    System.out.println("Successfully added observer to calculate method.");
    calculateButton.setOnAction(event -> o.update());

  }

  @Override
  public void addTypeObserver(Observer o) {
    System.out.println("Successfully added observer to change type method.");
    postfixRadio.setOnAction(event -> o.update());
    infixRadio.setOnAction(event -> o.update());

  }

  /**
   * Enable the buttons.
   */
  public void menu() {
    calculateButton.setDisable(false);
    infixRadio.setDisable(false);
    postfixRadio.setDisable(false);
  }

  /**
   * Instantiates a help pane if not already done, and then shows it to the user.
   */
  public void showHelp() {
    if (helpPane == null) {
      helpPane = new HelpPane();
    }
    helpPane.show();
  }

  /**
   * A simple inner class used to display some help text to the user.
   * @author zhac067
   *
   */
  class HelpPane extends Stage {

    /**
     * Construct a new help pane.
     */
    public HelpPane() {
      this.setTitle("Help");
     
      TextArea text = new TextArea();
      text.setWrapText(true);
      text.setEditable(false);
      text.setText("Welcome to the CS2800 Calculator.\n\n"
          + "You can choose between infix or postfix evaluation.\n\n"
          + "Please enter each token with a space in between, for example:\n"
          + "( 4 * 3 ) + 5\n"
          + "8 23 + 12 -\n"
          + "\n"
          + "By Thomas Allison (zhac067).");
      BorderPane borderPane = new BorderPane();
      borderPane.setCenter(text);
      Scene s = new Scene(borderPane, SCENE_WIDTH, SCENE_HEIGHT);
      this.setScene(s);
    }
  }
}
