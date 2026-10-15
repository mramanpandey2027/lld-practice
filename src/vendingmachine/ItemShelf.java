package vendingmachine;

import java.util.concurrent.atomic.AtomicInteger;

public class ItemShelf {
    private int id;
    private Item item;
    private AtomicInteger qty;

    public ItemShelf(int id, Item item, int qty) {
        this.id = id;
        this.item = item;
        this.qty = new AtomicInteger(qty);
    }

    public int getItemCost() {
        return item.getPrice();
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return item!=null && qty.get() > 0;
    }

    public boolean decrementQty() {
        while(true) {
            int current = qty.get();
            if(current <=0) return false;
            if(qty.compareAndSet(current, current-1)) {
                return true;
            }
        }
    }

    public void incrementQty() {
        qty.getAndIncrement();
    }
}
