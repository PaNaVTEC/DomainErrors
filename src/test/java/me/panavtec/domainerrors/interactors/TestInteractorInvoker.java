package me.panavtec.domainerrors.interactors;

import java.util.concurrent.Future;
import me.panavtec.domainerrors.interactors.GenericInteractorError;
import me.panavtec.domainerrors.interactors.InteractorError;
import me.panavtec.domainerrors.interactors.InteractorErrorAction;
import me.panavtec.domainerrors.interactors.InteractorExecution;
import me.panavtec.domainerrors.interactors.InteractorInvoker;
import me.panavtec.domainerrors.interactors.InteractorResponse;
import me.panavtec.domainerrors.interactors.InteractorResult;

public class TestInteractorInvoker implements InteractorInvoker {

  @Override
  public <T extends InteractorResponse> Future<T> execute(InteractorExecution<T> execution) {
    InteractorResult<T> interactorResult = execution.getInteractorResult();
    try {
      T response = execution.getInteractor().call();
      if (response.hasError()) {
        errorAction(execution, response);
      } else {
        interactorResult.onResult(response);
      }
    } catch (Exception e) {
      executeErrorAction(execution, new GenericInteractorError(e));
    }
    return null;
  }

  private <T extends InteractorResponse> void errorAction(InteractorExecution<T> execution,
      T response) {
    InteractorError error = response.getError();
    InteractorErrorAction errorAction = execution.getErrorActions().get(error.getClass());
    if (errorAction != null) {
      errorAction.onError(error);
    } else {
      executeErrorAction(execution, new GenericInteractorError());
    }
  }

  private <T extends InteractorResponse> void executeErrorAction(InteractorExecution<T> execution,
      GenericInteractorError genericInteractorError) {
    InteractorErrorAction genericErrorAction = execution.getGenericErrorAction();
    if (genericErrorAction != null) {
      genericErrorAction.onError(genericInteractorError);
    }
  }
}