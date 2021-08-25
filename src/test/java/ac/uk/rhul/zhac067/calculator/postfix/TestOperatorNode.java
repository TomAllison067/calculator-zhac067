// $Id: TestOperatorNode.java 43 2020-11-18 22:24:03Z zhac067 $ $Revision: 43 $

package ac.uk.rhul.zhac067.calculator.postfix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class TestOperatorNode {
  static OperatorNode node;
  
  @Test
  public void testConstructor() {
    assertThrows(IllegalArgumentException.class, () -> {
      node = new OperatorNode(Operators.PLUS, new LeafNode(1.0f), null);
    }, "An OperatorNode must have two child nodes.");

    assertThrows(IllegalArgumentException.class, () -> {
      node = new OperatorNode(Operators.PLUS, null, new LeafNode(2.0f));
    }, "An OperatorNode must have two child nodes.");

    assertThrows(IllegalArgumentException.class, () -> {
      node = new OperatorNode(null, new LeafNode(1.0f), new LeafNode(1.0f));
    }, "An OperatorNode must have an operator!");
  }

  @Test
  public void testValidCreationAndStorage() {
    LeafNode left = new LeafNode(1.0f);
    LeafNode right = new LeafNode(2.0f);
    Operator plus = Operators.PLUS;
    OperatorNode parent = new OperatorNode(plus, left, right);
    assertEquals(left, parent.getLeft(), "The left LeafNode is stored correctly.");
    assertEquals(right, parent.getRight(), "The right LeafNode is stored correctly.");
    assertEquals(plus, parent.getOperator(), "The Operator is stored correctly.");
  }

  @Test
  public void testComplexChild() {
    LeafNode left = new LeafNode(1.0f);
    LeafNode right = new LeafNode(2.0f);
    Operator plus = Operators.PLUS;
    OperatorNode parent = new OperatorNode(plus, left, right);
    OperatorNode parentParent = new OperatorNode(plus, parent, parent);
    assertEquals(parent, parentParent.getLeft(), "The left node is stored correctly.");
    assertEquals(parent, parentParent.getRight(), "The right node is stored correctly.");
  }

  @Test
  public void testCanAcceptVisitors() {
    
    // Create a stub class to visit an OperatorNode.
    class VisitorStub implements Visitor {
      private boolean hasVisited = false;

      @Override
      public void visit(LeafNode leaf) {}


      @Override
      public void visit(OperatorNode opNode) {
        hasVisited = true;

      }

      public boolean getHasVisited() {
        return hasVisited;
      }

    }

    VisitorStub v = new VisitorStub();
    OperatorNode opNode = new OperatorNode(Operators.PLUS, new LeafNode(1.0f), new LeafNode(2.0f));
    opNode.accept(v);
    assertEquals(true, v.getHasVisited(), "Check that the Visitor has been accepted.");
  }
}
