package vendingmachine.state;

import vendingmachine.Coin;
import vendingmachine.VendingMachine;

public class DispenseState implements State {
    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        throw new IllegalStateException("item is selected already, no more coin can be inserted");
    }

    @Override
    public void selectItem(VendingMachine vendingMachine, int code) {
        throw new IllegalStateException("item is already selected");
    }

    @Override
    public void dispenseItem(VendingMachine vendingMachine) {
        // stock remove
        vendingMachine.getInventory().decrementQty(vendingMachine.getSelectedItemCode());
        System.out.println("dispensing item code: " + vendingMachine.getSelectedItemCode());

        // return change
        int itemCost = vendingMachine.getInventory().getShelf(vendingMachine.getSelectedItemCode()).getItemCost();
        int insertedCost = vendingMachine.getInsertedBalance();
        int change = insertedCost - itemCost;
        if(change > 0) {
            System.out.println("returning change : " + change);
        }

        // clear balance
        vendingMachine.clearBalance();
        vendingMachine.setSelectedItemCode(0);
        vendingMachine.setCurrentState(new IdleState());
    }

    @Override
    public void cancel(VendingMachine vendingMachine) {
        throw new IllegalStateException("item can't be canceled during dispensing");
    }
}
