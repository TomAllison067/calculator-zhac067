//$Id: Visitor.java 34 2020-11-16 21:19:06Z zhac067 $ $Revision: 34 $

package ac.uk.rhul.zhac067.calculator.postfix;

/**
 * A Visitor can visit any Visitable node, and usually perform some algorithm on it.
 * <p>
 * Visitable nodes in this Calculator program are probably either leaves or operator nodes
 * in the Postfix syntax tree.
 * </p>
 * @author zhac067
 * @see Visitable
 */
public interface Visitor {

  /**
   * Visit a visitable LeafNode class, and perform any appropriate algorithm.
   * <p>
   * Most likely, just get the leaf's value.
   * </p>
   * @param leaf the leaf to visit.
   */
  public void visit(LeafNode leaf);
  
  /**
   * Visit an OperatorNode, and perform any appropriate algorithms.
   * @param opNode the node to visit.
   */
  public void visit(OperatorNode opNode);

}
