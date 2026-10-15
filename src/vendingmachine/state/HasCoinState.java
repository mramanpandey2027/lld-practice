package vendingmachine.state;

import vendingmachine.Coin;
import vendingmachine.VendingMachine;

public class HasCoinState implements State {
    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        vendingMachine.addCoin(coin);
        System.out.println("inserted more coins" + coin.getValue());
    }

    @Override
    public void selectItem(VendingMachine vendingMachine, int code) {
        if(!vendingMachine.getInventory().isAvailable(code)) {
            throw new IllegalStateException("Item not available " + code);
        }

        int itemCost = vendingMachine.getInventory().getShelf(code).getItemCost();
        int insertedCost = vendingMachine.getInsertedBalance();

        if(itemCost > insertedCost) {
            int left_amt = itemCost - insertedCost;
            throw new IllegalStateException("item is more costlier by " + left_amt);
        }

        vendingMachine.setSelectedItemCode(code);
        System.out.println("item selected" + vendingMachine.getInventory().getShelf(code).getId());
        vendingMachine.setCurrentState(new DispenseState());
    }

    @Override
    public void dispenseItem(VendingMachine vendingMachine) {
        throw new IllegalStateException("please select item first");
    }

    @Override
    public void cancel(VendingMachine vendingMachine) {
        System.out.println("cancelling transaction. refunding " + vendingMachine.getInsertedBalance());
        vendingMachine.clearBalance();
        vendingMachine.setSelectedItemCode(0);
        vendingMachine.setCurrentState(new IdleState());
    }
}
