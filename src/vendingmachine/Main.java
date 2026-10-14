package vendingmachine;

public class Main {
    public static void main(String... args) {
        Inventory inventory = new Inventory();
        inventory.addItemShelf(new ItemShelf(101, new Item(1, "Coke", 25), 5));
        inventory.addItemShelf(new ItemShelf(102, new Item(2, "Biscuit", 10), 5));

        VendingMachine vendingMachine = new VendingMachine(inventory);


    }
}
