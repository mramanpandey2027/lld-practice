package vendingmachine;

public class ItemShelf {
    private int id;
    private Item item;
    private int qty;

    public ItemShelf(int id, Item item, int qty) {
        this.id = id;
        this.item = item;
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return item!=null && qty > 0;
    }

    public void decrementQty() {
        if(qty > 0) {
            qty--;
        }
    }

    public void incrementQty() {
        qty++;
    }
}
