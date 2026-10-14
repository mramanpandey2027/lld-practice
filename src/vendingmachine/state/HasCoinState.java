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
        if(vendingMachine.getInventory().isAvailable(code)) {
            vendingMachine.setSelectedItemCode(code);
            System.out.println("item selected" + vendingMachine.getInventory().getShelf(code).getId());
            vendingMachine.setCurrentState(new DispenseState());
        }
    }

    @Override
    public void dispenseItem(VendingMachine vendingMachine) {
        throw new IllegalStateException("please select item first");
    }

    @Override
    public void cancel(VendingMachine vendingMachine) {
        vendingMachine.clearBalance();
        vendingMachine.setSelectedItemCode(0);
        vendingMachine.setCurrentState(new IdleState());
    }
}
