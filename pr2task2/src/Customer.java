public class Customer {
    private final String gameToBuy;
    private final float moneyInWallet;

    public Customer(String gameToBuy, float moneyInWallet) {
        this.gameToBuy = gameToBuy;
        this.moneyInWallet = moneyInWallet;
    }

    public String getGameName() {
        return gameToBuy;
    }

    public float getMoney() {
        return moneyInWallet;
    }
}

