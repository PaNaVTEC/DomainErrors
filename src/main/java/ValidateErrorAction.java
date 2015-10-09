public class ValidateErrorAction implements InteractorErrorAction<InvalidCreateProductFieldError> {
  private final CreateProductView view;

  public ValidateErrorAction(CreateProductView view) {
    this.view = view;
  }

  @Override public void onError(InvalidCreateProductFieldError error) {
    if (error.errors == InvalidCreateProductFieldError.Errors.INVALID_PRICE) {
      view.showInvalidPrice();
    }
    if (error.errors == InvalidCreateProductFieldError.Errors.INVALID_TITLE) {
      view.showInvalidTitle();
    }
  }
}
