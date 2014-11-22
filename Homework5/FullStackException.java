
/**
 * Runtime exception thrown when the capacity of the array used by an
 * ArrayStack has been exceeded.
 * @see ArrayStack
 */
@SuppressWarnings("serial")
public class FullStackException extends RuntimeException {
  public FullStackException(String err) {
    super(err);
  }
}
