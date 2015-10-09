public class ValidatorInvalidPriceErrorFake extends ValidatorService {

  @Override public InvalidCreateProductFieldError validateFields() {
    InvalidCreateProductFieldError invalidCreateProductFieldError =
        new InvalidCreateProductFieldError();
    invalidCreateProductFieldError.setErrors(InvalidCreateProductFieldError.Errors.INVALID_PRICE);
    return invalidCreateProductFieldError;
  }
}
