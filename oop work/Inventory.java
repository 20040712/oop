public class Inventory {
    private static final int MAX_ITEMS = 10;
    private String[] items;
    private int itemCount;

    public Inventory() {
        items = new String[MAX_ITEMS];
        itemCount = 0;
    }

    public void addItem(String item) {
        if (itemCount < MAX_ITEMS) {
            items[itemCount++] = item;
        }
    }

    public String displayInventory() {
        StringBuilder inventory = new StringBuilder();
        for (int i = 0; i < itemCount; i++) {
            inventory.append(items[i]).append(" ");
        }
        return inventory.toString();
    }
}
