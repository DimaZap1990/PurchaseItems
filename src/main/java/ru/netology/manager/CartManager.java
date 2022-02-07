package ru.netology.manager;

import ru.netology.domain.PurchaseItems;
import ru.netology.repository.CartRepository;

public class CartManager {
    private CartRepository repository;

    public CartManager(CartRepository repository) {
        this.repository = repository;
    }

    public void add(PurchaseItems item) {
        repository.save(item);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }
}
