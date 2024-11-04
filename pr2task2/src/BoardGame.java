public class BoardGame {
    private final String name;
    private final float price;

    public BoardGame(String name, int playerMin, int playerMax, int gameDuration, int minAge, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

}

