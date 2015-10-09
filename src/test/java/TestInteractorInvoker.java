import java.util.concurrent.Future;

public class TestInteractorInvoker implements InteractorInvoker {
  @Override
  public <T extends InteractorResponse> Future<T> execute(InteractorExecution<T> execution) {
    InteractorResult<T> interactorResult = execution.getInteractorResult();
    try {
      T response = execution.getInteractor().call();
      if (response.hasError()) {
        InteractorError error = response.getError();
        InteractorErrorAction interactorErrorAction =
            execution.getErrorActions().get(error.getClass());
        if (interactorErrorAction != null) {
          interactorErrorAction.onError(error);
        }
      } else {
        interactorResult.onResult(response);
      }
    } catch (Exception e) {
      InteractorErrorAction interactorErrorAction = execution.getGenericError();
      if (interactorErrorAction != null) {
        interactorErrorAction.onError(new GenericError(e));
      }
    }
    return null;
  }
}