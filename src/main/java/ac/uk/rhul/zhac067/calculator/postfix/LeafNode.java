// $Id: LeafNode.java 34 2020-11-16 21:19:06Z zhac067 $ $Revision: 34 $

package ac.uk.rhul.zhac067.calculator.postfix;

/**
 * A LeafNode represents a leaf in the syntax tree built up when evaluating an expression using
 * Reverse Polish notation.
 * 
 * @author zhac067
 *
 */
public class LeafNode implements Visitable {
  /**
   * The value stored in this LeafNode.
   */
  private final float value;

  /**
   * Construct a new LeafNode, and store a value in it.
   * 
   * @param value the value to store.
   */
  public LeafNode(Float value) {
    this.value = value;
  }

  /**
   * Returns the value stored in this LeafNode.
   */
  public float getValue() {
    return value;
  }

  @Override
  public void accept(Visitor v) {
    v.visit(this);
  }
}
