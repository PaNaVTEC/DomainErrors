public class LoginServiceErrorFake extends LoginService {
  @Override public boolean isLogged() {
    return false;
  }
}
