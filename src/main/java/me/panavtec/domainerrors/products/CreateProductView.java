package me.panavtec.domainerrors.products;

import me.panavtec.domainerrors.Product;

public interface CreateProductView {
  void showNotLogged();

  void showInvalidPrice();

  void showInvalidTitle();

  void showCreatedProduct(Product result);

  void genericError();
}
