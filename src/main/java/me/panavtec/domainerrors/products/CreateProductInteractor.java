package me.panavtec.domainerrors.products;

import me.panavtec.domainerrors.interactors.Interactor;
import me.panavtec.domainerrors.users.LoginService;
import me.panavtec.domainerrors.users.NotLoggedError;

public class CreateProductInteractor implements Interactor<CreateProductResponse> {
  private final LoginService loginService;
  private final ProductValidatorService productValidator;

  public CreateProductInteractor(LoginService loginService, ProductValidatorService productValidator) {
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
