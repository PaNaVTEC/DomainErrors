public interface InteractorErrorAction<T extends InteractorError> {
  void onError(T error);
}
