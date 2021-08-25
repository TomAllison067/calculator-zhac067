// $Id: Observer.java 57 2020-11-24 14:51:17Z zhac067 $ $Revision: 57 $

package ac.uk.rhul.zhac067.calculator.views;

/**
 * A functional interface used to implement the Observer pattern. This interface allows methods of
 * an Observer class can be registered as observers of an observable class.
 * 
 * @author zhac067
 *
 */
@FunctionalInterface
public interface Observer {

  /**
   * Used by the observed object to invoke the correct handler method in the observer.
   */
  public void update();
}
