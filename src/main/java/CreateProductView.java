public interface CreateProductView {
  void showNotLogged();

  void showInvalidPrice();

  void showInvalidTitle();

  void showCreatedProduct(Product result);

  void genericError();
}
