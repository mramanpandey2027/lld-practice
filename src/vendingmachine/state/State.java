package vendingmachine.state;

import vendingmachine.Coin;
import vendingmachine.VendingMachine;

public interface State {
    void insertCoin(VendingMachine vendingMachine, Coin coin) ;
    void selectItem(VendingMachine vendingMachine, int code) ;
    void dispenseItem(VendingMachine vendingMachine) ;
    void cancel(VendingMachine vendingMachine) ;
}
