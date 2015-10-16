package me.panavtec.domainerrors.products;

public class ProductValidatorInvalidPriceErrorFake extends ProductValidatorService {

  @Override public InvalidCreateProductFieldError validateFields() {
    InvalidCreateProductFieldError invalidCreateProductFieldError =
        new InvalidCreateProductFieldError();
    invalidCreateProductFieldError.setCreateProductErrors(CreateProductErrors.INVALID_PRICE);
    return invalidCreateProductFieldError;
  }
}
