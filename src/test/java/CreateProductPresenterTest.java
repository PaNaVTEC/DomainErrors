import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.any;

public class CreateProductPresenterTest {

  private InteractorInvoker invoker;
  @Mock private CreateProductView view;

  @Before public void setUp() {
    invoker = new TestInteractorInvoker();
    MockitoAnnotations.initMocks(this);
  }

  @Test public void whenInputIsValid_onResultIsCalled() {
    LoginService loginService = new LoginService();
    ValidatorService validatorService = new ValidatorService();
    CreateProductPresenter presenter = Mockito.spy(
        new CreateProductPresenter(view, new CreateProductInteractor(loginService, validatorService), invoker));
    presenter.onCreateProduct();
    Mockito.verify(view).showCreatedProduct(any(Product.class));
  }

  @Test public void whenUserIsNotLoggedIn_onErrorIsCalledWithLoginError() {
    LoginService loginService = new LoginServiceErrorFake();
    ValidatorService validatorService = new ValidatorService();
    CreateProductPresenter presenter = Mockito.spy(
        new CreateProductPresenter(view, new CreateProductInteractor(loginService, validatorService), invoker));
    presenter.onCreateProduct();
    Mockito.verify(view).showNotLogged();
  }

  @Test public void whenUserCreatesProductWithInvalidOutput_onInputInvalidErrorIsCalled() {
    LoginService loginService = new LoginService();
    ValidatorService validatorService = new ValidatorInvalidPriceErrorFake();
    CreateProductPresenter presenter = Mockito.spy(
        new CreateProductPresenter(view, new CreateProductInteractor(loginService, validatorService), invoker));
    presenter.onCreateProduct();
    Mockito.verify(view).showInvalidPrice();
  }
}
