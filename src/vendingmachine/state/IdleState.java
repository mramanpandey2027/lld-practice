package vendingmachine.state;

import vendingmachine.Coin;
import vendingmachine.VendingMachine;

public class IdleState implements State {
    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        vendingMachine.addCoin(coin);
        System.out.println("coin inserted : " + coin.getValue());
        vendingMachine.setCurrentState(new HasCoinState());
    }

    @Override
    public void selectItem(VendingMachine vendingMachine, int code) {
        throw new IllegalStateException("Please insert coin before selecting item");
    }

    @Override
    public void dispenseItem(VendingMachine vendingMachine) {
        throw new IllegalStateException("Please insert coin first and select item");
    }

    @Override
    public void cancel(VendingMachine vendingMachine) {
        System.out.println("machine is idle");
    }
}
