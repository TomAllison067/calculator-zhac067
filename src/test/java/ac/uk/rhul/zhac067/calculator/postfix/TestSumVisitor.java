// $Id: TestSumVisitor.java 43 2020-11-18 22:24:03Z zhac067 $ $Revision: 43 $

package ac.uk.rhul.zhac067.calculator.postfix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSumVisitor {
  static final float DELTA = 0.0001f;
  
  private static SumVisitor sum;
  
  @BeforeEach
  public void setup() {
    sum = new SumVisitor();
  }
  
  @Test
  public void testNewVisitorAnswerZero() {
    assertEquals(0, sum.getAnswer(), DELTA, "A new SumVisitor has answer 0.");
  }
  
  @Test
  public void testVisitLeaf() {
    LeafNode leaf = new LeafNode(10.0f);
    leaf.accept(sum);
    assertEquals(10.0f, sum.getAnswer(), DELTA, "Check a leaf is visited correctly.");
  }
  
  @Test
  public void testVisitOperatorNode() {
    // First, build a simple tree and evalute it.
    LeafNode thirtyTwo = new LeafNode(32.0f);
    LeafNode eleven = new LeafNode(10.0f);
    OperatorNode fourtyTwo = new OperatorNode(Operators.PLUS, eleven, thirtyTwo);
    fourtyTwo.accept(sum);
    assertEquals(42.0f, sum.getAnswer(), DELTA, "Check the answer to life, the universe and everything.");
    
    // Now, add a parent to that tree - and evaluate that too.
    OperatorNode twenty = new OperatorNode(Operators.MINUS, fourtyTwo, new LeafNode(22.0f));
    twenty.accept(sum);
    assertEquals(20.0f, sum.getAnswer(), DELTA, "The SumVisitor evaluates the tree correctly to 20.0f.");
  }
}
