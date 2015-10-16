package me.panavtec.domainerrors.products;

import me.panavtec.domainerrors.interactors.InteractorErrorAction;

public class ValidateErrorAction implements InteractorErrorAction<InvalidCreateProductFieldError> {
  private final CreateProductView view;

  public ValidateErrorAction(CreateProductView view) {
    this.view = view;
  }

  @Override public void onError(InvalidCreateProductFieldError error) {
    if (error.getCreateProductErrors() == CreateProductErrors.INVALID_PRICE) {
      view.showInvalidPrice();
    }
    if (error.getCreateProductErrors() == CreateProductErrors.INVALID_TITLE) {
      view.showInvalidTitle();
    }
  }
}
