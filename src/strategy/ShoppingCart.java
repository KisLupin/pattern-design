package strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    //List of items
    List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public int calculateTotal() {
        return items.stream().map(Item::getPrice).reduce(Integer::sum).orElse(0);
    }

    public void pay(PaymentStrategy paymentMethod) {
        int amount = calculateTotal();
        paymentMethod.pay(amount);
    }
}
