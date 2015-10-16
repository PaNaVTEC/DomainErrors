package me.panavtec.domainerrors.interactors;

public class InteractorResponse<T> {
  private T response;
  private InteractorError error;

  public boolean hasError() {
    return error != null;
  }

  public void setError(InteractorError error) {
    this.error = error;
  }

  public InteractorError getError() {
    return error;
  }

  public T getResponse() {
    return response;
  }

  public void setResponse(T response) {
    this.response = response;
  }
}
