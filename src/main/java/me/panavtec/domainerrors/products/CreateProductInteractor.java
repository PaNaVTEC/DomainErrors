package me.panavtec.domainerrors.products;

import me.panavtec.domainerrors.InvalidCreateProductFieldError;
import me.panavtec.domainerrors.LoginService;
import me.panavtec.domainerrors.NotLoggedError;
import me.panavtec.domainerrors.ValidatorService;
import me.panavtec.domainerrors.interactors.Interactor;

public class CreateProductInteractor implements Interactor<CreateProductResponse> {
  private final LoginService loginService;
  private final ValidatorService productValidator;

  public CreateProductInteractor(LoginService loginService, ValidatorService productValidator) {
    this.loginService = loginService;
    this.productValidator = productValidator;
  }

  @Override public CreateProductResponse call() throws Exception {
    CreateProductResponse createProductResponse = new CreateProductResponse();
    if (!loginService.isLogged()) {
      createProductResponse.setError(new NotLoggedError());
      return createProductResponse;
    }

    InvalidCreateProductFieldError validateError = productValidator.validateFields();
    if (validateError != null) {
      createProductResponse.setError(validateError);
      return createProductResponse;
    }

    return createProductResponse;
  }
}
