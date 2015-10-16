package me.panavtec.domainerrors.products;

import me.panavtec.domainerrors.interactors.GenericErrorAction;
import me.panavtec.domainerrors.interactors.InteractorExecution;
import me.panavtec.domainerrors.interactors.InteractorInvoker;
import me.panavtec.domainerrors.interactors.InteractorResult;
import me.panavtec.domainerrors.users.NotLoggedError;
import me.panavtec.domainerrors.users.NotLoggedErrorAction;

public class CreateProductPresenter {
  private final CreateProductView view;
  private final CreateProductInteractor createProductInteractor;
  private final InteractorInvoker invoker;

  public CreateProductPresenter(CreateProductView view,
      CreateProductInteractor createProductInteractor, InteractorInvoker invoker) {
    this.view = view;
    this.createProductInteractor = createProductInteractor;
    this.invoker = invoker;
  }

  public void onCreateProduct() {
    new InteractorExecution<CreateProductResponse>().
        interactor(createProductInteractor).
        result(new InteractorResult<CreateProductResponse>() {
          @Override public void onResult(CreateProductResponse result) {
            view.showCreatedProduct(result.getResponse());
          }
        }).
        error(NotLoggedError.class, new NotLoggedErrorAction(view)).
        error(InvalidCreateProductFieldError.class, new ValidateErrorAction(view)).
        genericError(new GenericErrorAction(view)).
        execute(invoker);
  }

}
