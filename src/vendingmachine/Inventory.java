package vendingmachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    private final Map<Integer, ItemShelf> itemShelfMap = new ConcurrentHashMap<>();

    public void addItemShelf(ItemShelf itemShelf) {
        itemShelfMap.put(itemShelf.getId(), itemShelf);
    }

    public boolean isAvailable(int code) {
        return itemShelfMap.containsKey(code) && itemShelfMap.get(code).isAvailable();
    }

    public void decrementQty(int code) {
        if(itemShelfMap.containsKey(code)) {
            itemShelfMap.get(code).decrementQty();
        }

    }
    public ItemShelf getShelf(int code) {
        return itemShelfMap.get(code);
    }

}
