package vendingmachine;

import vendingmachine.state.IdleState;
import vendingmachine.state.State;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private State currentState;
    private Inventory inventory;
    private List<Coin> insertedCoins;
    private int selectedItemCode;

    public VendingMachine(Inventory inventory) {
        this.inventory = inventory;
        this.insertedCoins = new ArrayList<>();
        this.currentState = new IdleState();
    }

    public void insertCoin(Coin coin) {
        currentState.insertCoin(this, coin);
    }
    public void selectItem(int code) {
        currentState.selectItem(this, code);
    }
    public void dispense() {
        currentState.dispenseItem(this);
    }
    public void cancel() {
        currentState.cancel(this);
    }
    public int getSelectedItemCode() {
        return selectedItemCode;
    }
    public void setCurrentState(State state) {
        this.currentState = state;
    }
    public void setSelectedItemCode(int code) {
        this.selectedItemCode = code;
    }
    public void clearBalance() {
        this.insertedCoins.clear();
    }
    public void addCoin(Coin coin) {
        insertedCoins.add(coin);
    }
    public Inventory getInventory() {
        return inventory;
    }
    public int getInsertedBalance() {
        int sum=0;
        for(Coin coin: insertedCoins) {
            sum+=coin.getValue();
        }
        return sum;
    }
}
