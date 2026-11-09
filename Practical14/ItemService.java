import java.util.ArrayList;
import java.util.List;

public class ItemService {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        
        if (item == null || item.getName() == null || item.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be empty!");
        }
        items.add(item);
    }

    public int getCount() {
        return items.size();
    }

    public List<Item> getItems() {
        return items;
    }
}