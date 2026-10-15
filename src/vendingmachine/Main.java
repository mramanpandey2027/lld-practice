package vendingmachine;

public class Main {
    public static void main(String... args) {
        Inventory inventory = new Inventory();
        inventory.addItemShelf(new ItemShelf(101, new Item(1, "Coke", 25), 5));
        inventory.addItemShelf(new ItemShelf(102, new Item(2, "Biscuit", 10), 5));

        VendingMachine vendingMachine = new VendingMachine(inventory);

        vendingMachine.insertCoin(Coin.TEN);
        vendingMachine.insertCoin(Coin.TEN);
        vendingMachine.insertCoin(Coin.ONE);

        vendingMachine.selectItem(102);
        vendingMachine.dispense();
        try {
            vendingMachine.insertCoin(Coin.TEN);
            vendingMachine.insertCoin(Coin.TWO);
            vendingMachine.selectItem(101);
            vendingMachine.cancel();
        } catch (IllegalStateException e) {
            System.out.println("exception " + e.getMessage());
            vendingMachine.cancel();
        }

    }
}
