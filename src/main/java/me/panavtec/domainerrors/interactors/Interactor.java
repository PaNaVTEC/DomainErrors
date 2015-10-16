package me.panavtec.domainerrors.interactors;

import java.util.concurrent.Callable;

public interface Interactor<T> extends Callable<T> {
  @Override T call() throws Exception;
}
