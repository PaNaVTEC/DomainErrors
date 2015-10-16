package me.panavtec.domainerrors.interactors;

public interface InteractorErrorAction<T extends InteractorError> {
  void onError(T error);
}
