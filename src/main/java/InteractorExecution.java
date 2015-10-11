import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

public class InteractorExecution<T extends InteractorResponse> {
  private InteractorResult<T> interactorResult;
  private int priority;
  private Map<Class<? extends InteractorError>, InteractorErrorAction<? extends InteractorError>>
      errorActions = new HashMap<>();
  private Interactor<T> interactor;

  public InteractorExecution<T> result(InteractorResult<T> output) {
    interactorResult = output;
    return this;
  }

  public InteractorExecution<T> priority(int priority) {
    this.priority = priority;
    return this;
  }

  public <E extends InteractorError> InteractorExecution<T> error(Class<E> errorClass,
      InteractorErrorAction<E> errorAction) {
    errorActions.put(errorClass, errorAction);
    return this;
  }

  public InteractorExecution<T> interactor(Interactor<T> interactor) {
    this.interactor = interactor;
    return this;
  }

  public <E extends InteractorError> InteractorExecution<T> genericError(
      InteractorErrorAction<E> errorAction) {
    errorActions.put(InteractorError.class, errorAction);
    return this;
  }

  public InteractorResult<T> getInteractorResult() {
    return interactorResult;
  }

  public int getPriority() {
    return priority;
  }

  public Map<Class<? extends InteractorError>, InteractorErrorAction<? extends InteractorError>> getErrorActions() {
    return errorActions;
  }

  public Interactor<T> getInteractor() {
    return interactor;
  }

  public Future<T> execute(InteractorInvoker invoker) {
    return invoker.execute(this);
  }

  public InteractorErrorAction<? extends InteractorError> getGenericErrorAction() {
    return errorActions.get(InteractorError.class);
  }
}
