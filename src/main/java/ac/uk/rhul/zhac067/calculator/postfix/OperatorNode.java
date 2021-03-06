// $Id: OperatorNode.java 36 2020-11-16 21:36:35Z zhac067 $ $Revision: 36 $

package ac.uk.rhul.zhac067.calculator.postfix;

/**
 * An OperatorNode is a node that has two child LeafNodes.
 * <p>
 * It has an Operator, which can evaluate expressions, and two children that represent numbers or
 * other OperatorNodes. It is Visitable by a Visitor.
 * </p>
 * 
 * @author tom
 * @see Visitable @see Visitor @see Operator @see LeafNode
 */
public class OperatorNode implements Visitable {
  private final Operator operator;
  private Visitable left;
  private Visitable right;

  /**
   * Construct an OperatorNode.
   * 
   * @param operator the Operator to be stored. Defines what evaluation will be done on the
   *        children.
   * @param left the left Visitable to be stored.
   * @param right the right Visitable to be stored.
   */
  public OperatorNode(Operator operator, Visitable left, Visitable right) {
    if (left == null || right == null || operator == null) {
      throw new IllegalArgumentException();
    }
    this.operator = operator;
    this.left = left;
    this.right = right;
  }

  /**
   * Returns the left child node of this OperatorNode.
   */
  public Visitable getLeft() {
    return left;
  }

  /**
   * Returns the right child node of this OperatorNode.
   */
  public Visitable getRight() {
    return right;
  }

  /**
   * Returns the Operator of this OperatorNode.
   */
  public Operator getOperator() {
    return operator;
  }

  @Override
  public void accept(Visitor v) {
    v.visit(this);
  }

}
