package stores;

public class Store {
    private String storeName;

    public Store(String storeName) {
        this.storeName = storeName;
    }

    public void displayStore() {
        System.out.println(storeName);
    }
}
