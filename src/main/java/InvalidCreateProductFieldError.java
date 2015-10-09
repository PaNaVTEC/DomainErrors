public class InvalidCreateProductFieldError implements InteractorError {

  public void setErrors(Errors errors) {
    this.errors = errors;
  }

  Errors errors;

  enum Errors {
    INVALID_TITLE,
    INVALID_PRICE
  }
}
