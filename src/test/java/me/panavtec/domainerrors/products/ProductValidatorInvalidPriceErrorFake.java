package me.panavtec.domainerrors.products;

import me.panavtec.domainerrors.products.CreateProductErrors;
import me.panavtec.domainerrors.products.InvalidCreateProductFieldError;
import me.panavtec.domainerrors.products.ProductValidatorService;

public class ProductValidatorInvalidPriceErrorFake extends ProductValidatorService {

  @Override public InvalidCreateProductFieldError validateFields() {
    InvalidCreateProductFieldError invalidCreateProductFieldError =
        new InvalidCreateProductFieldError();
    invalidCreateProductFieldError.setCreateProductErrors(CreateProductErrors.INVALID_PRICE);
    return invalidCreateProductFieldError;
  }
}
