public class GenericError implements InteractorError {

  private Throwable cause;

  public GenericError(Throwable cause) {
    this.cause = cause;
  }

  public Throwable getCause() {
    return cause;
  }
}
