// $Id: Visitable.java 34 2020-11-16 21:19:06Z zhac067 $ $Revision: 34 $

package ac.uk.rhul.zhac067.calculator.postfix;

/**
 * A Visitable class can be visited by some Visitor, which in turn
 * may perform some algorithm on the Visitable.
 * @author zhac067
 * @see Visitor
 */
public interface Visitable {
  
  /**
   * Accept a Visitor that may perform some algorithm on this Visitable.
   * @param v the Visitor to accept.
   */
  public void accept(Visitor v);
}
