package me.panavtec.domainerrors.products;

import me.panavtec.domainerrors.interactors.InteractorInvoker;
import me.panavtec.domainerrors.interactors.TestInteractorInvoker;
import me.panavtec.domainerrors.users.LoginService;
import me.panavtec.domainerrors.users.LoginServiceErrorFake;
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
    ProductValidatorService productValidatorService = new ProductValidatorService();
    CreateProductPresenter presenter = Mockito.spy(
        new CreateProductPresenter(view, new CreateProductInteractor(loginService,
            productValidatorService), invoker));
    presenter.onCreateProduct();
    Mockito.verify(view).showCreatedProduct(any(Product.class));
  }

  @Test public void whenUserIsNotLoggedIn_onErrorIsCalledWithLoginError() {
    LoginService loginService = new LoginServiceErrorFake();
    ProductValidatorService productValidatorService = new ProductValidatorService();
    CreateProductPresenter presenter = Mockito.spy(
        new CreateProductPresenter(view, new CreateProductInteractor(loginService,
            productValidatorService), invoker));
    presenter.onCreateProduct();
    Mockito.verify(view).showNotLogged();
  }

  @Test public void whenUserCreatesProductWithInvalidOutput_onInputInvalidErrorIsCalled() {
    LoginService loginService = new LoginService();
    ProductValidatorService productValidatorService = new ProductValidatorInvalidPriceErrorFake();
    CreateProductPresenter presenter = Mockito.spy(
        new CreateProductPresenter(view, new CreateProductInteractor(loginService,
            productValidatorService), invoker));
    presenter.onCreateProduct();
    Mockito.verify(view).showInvalidPrice();
  }
}
