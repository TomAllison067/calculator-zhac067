// $Id: TestLeafNode.java 34 2020-11-16 21:19:06Z zhac067 $ $Revision: 34 $

package ac.uk.rhul.zhac067.calculator.postfix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestLeafNode {
  static final float DELTA = 0.0001f;

  @Test
  public void testNewLeafNode() {
    LeafNode node = new LeafNode(5.0f);
    assertEquals(5.0f, node.getValue(), DELTA,
        "A new leaf node should return the value it is instantiated with.");
    node = new LeafNode(2.0f);
    assertEquals(2.0f, node.getValue(), DELTA,
        "A new leaf node should return the value it is instantiated with.");
  }

  @Test
  public void testAcceptVisitor() {
    LeafNode node = new LeafNode(5.0f);

    // Stub a visitor to visit this node
    class VisitorStub implements Visitor {
      private boolean hasVisited = false;

      @Override
      public void visit(LeafNode leaf) {
        hasVisited = true;
      }
      
      @Override
      public void visit(OperatorNode opNode) {}

      public boolean getHasVisited() {
        return hasVisited;
      }
    }
    
    VisitorStub v = new VisitorStub();
    node.accept(v);
    assertEquals(true, v.getHasVisited(),
        "If the leaf has successfully accepted the Visitor, then the Visitor's this is true.");

  }
}
