package me.panavtec.domainerrors.users;

import me.panavtec.domainerrors.interactors.InteractorErrorAction;
import me.panavtec.domainerrors.products.CreateProductView;

public class NotLoggedErrorAction implements InteractorErrorAction<NotLoggedError> {
  private final CreateProductView view;

  public NotLoggedErrorAction(CreateProductView view) {
    this.view = view;
  }

  @Override public void onError(NotLoggedError error) {
    view.showNotLogged();
  }
}
