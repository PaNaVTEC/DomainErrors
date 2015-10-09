public class NotLoggedErrorAction implements InteractorErrorAction<NotLoggedError> {
  private final CreateProductView view;

  public NotLoggedErrorAction(CreateProductView view) {
    this.view = view;
  }

  @Override public void onError(NotLoggedError error) {
    view.showNotLogged();
  }
}
