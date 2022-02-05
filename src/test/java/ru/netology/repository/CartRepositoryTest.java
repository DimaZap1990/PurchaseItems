package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.PurchaseItems;

import static org.junit.jupiter.api.Assertions.*;

class CartRepositoryTest {
    @Test
    public void repoTest() {
        PurchaseItems fist = new PurchaseItems(10, 1, "fist", 15, 1);
        PurchaseItems second = new PurchaseItems(11, 2, "second", 16, 3);
        PurchaseItems third = new PurchaseItems(12, 3, "third", 15, 1);
        CartRepository repo = new CartRepository();
        repo.save(fist);
        repo.save(second);
        repo.save(third);
        repo.RemoveById(11);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.RemoveById(3);});
    }
}


