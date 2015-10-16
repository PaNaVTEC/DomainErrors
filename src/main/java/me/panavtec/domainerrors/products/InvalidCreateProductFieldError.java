package me.panavtec.domainerrors.products;

import me.panavtec.domainerrors.interactors.InteractorError;

public class InvalidCreateProductFieldError implements InteractorError {

  private CreateProductErrors createProductErrors;

  public void setCreateProductErrors(CreateProductErrors createProductErrors) {
    this.createProductErrors = createProductErrors;
  }

  public CreateProductErrors getCreateProductErrors() {
    return createProductErrors;
  }
}
