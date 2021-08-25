// $Id: SumVisitor.java 38 2020-11-16 21:48:02Z zhac067 $ $Revision: 38 $

package ac.uk.rhul.zhac067.calculator.postfix;

/**
 * A SumVisitor visits LeafNodes and OperatorNodes to evaluate a postfix syntax tree, setting the
 * answer attribute to the result of an evaluated expression.
 * 
 * @author zhac067
 * @see LeafNode @see OperatorNode
 */
public class SumVisitor implements Visitor {
  private float answer;

  /**
   * Construct a new SumVisitor and set the answer to 0.
   */
  public SumVisitor() {
    answer = 0;
  }

  /**
   * Visit a LeafNode and set answer to the node's value.
   */
  @Override
  public void visit(LeafNode leaf) {
    answer = leaf.getValue();

  }

  /**
   * Visit an OperatorNode (the parent of the tree). Recurse downwards and evaluate the tree,
   * setting answer to the final answer.
   */
  @Override
  public void visit(OperatorNode opNode) {
    opNode.getLeft().accept(this); // Recurse down the tree
    float saveLeft = answer; // Save the left answer before an evaluation
    opNode.getRight().accept(this);
    answer = opNode.getOperator().eval(saveLeft, answer); // Evaluate

  }

  /**
   * Returns the answer stored in this SumVisitor.
   */
  public float getAnswer() {
    return answer;
  }

}
