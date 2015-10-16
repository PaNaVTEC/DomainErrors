package me.panavtec.domainerrors.users;

import me.panavtec.domainerrors.users.LoginService;

public class LoginServiceErrorFake extends LoginService {
  @Override public boolean isLogged() {
    return false;
  }
}
