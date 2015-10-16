package me.panavtec.domainerrors.interactors;

public interface InteractorResult<T> {
  void onResult(T result);
}
