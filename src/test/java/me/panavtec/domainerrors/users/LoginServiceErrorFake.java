package me.panavtec.domainerrors.users;

public class LoginServiceErrorFake extends LoginService {
  @Override public boolean isLogged() {
    return false;
  }
}
