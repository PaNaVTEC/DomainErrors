public class GenericErrorAction implements InteractorErrorAction<InteractorError> {
  private final CreateProductView view;

  public GenericErrorAction(CreateProductView view) {
    this.view = view;
  }

  @Override public void onError(InteractorError error) {
    view.genericError();
  }
}
