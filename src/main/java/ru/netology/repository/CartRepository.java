package ru.netology.repository;

import ru.netology.domain.NotFoundException;
import ru.netology.domain.PurchaseItems;

public class CartRepository {
    private PurchaseItems[] items = new PurchaseItems[0];

    public void save(PurchaseItems item) {
        int length = items.length + 1;
        PurchaseItems[] tmp = new PurchaseItems[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public void removeById(int id) {
        if (findById(id) == null) {

            throw new NotFoundException("Element with id:" + id + " not found");
        }
        int length = items.length - 1;
        PurchaseItems[] tmp = new PurchaseItems[length];
        int index = 0;
        for (PurchaseItems item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public PurchaseItems findById(int id) {
        for (PurchaseItems item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
