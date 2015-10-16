package me.panavtec.domainerrors.interactors;

import java.util.concurrent.Future;

public interface InteractorInvoker {

  <T extends InteractorResponse> Future<T> execute(InteractorExecution<T> execution);
}
