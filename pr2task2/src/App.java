import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        GameShop gameShop = new GameShop();

        gameShop.addGame(new BoardGame("Монополия", 2, 6, 60, 8, 20.0f));
        gameShop.addGame(new BoardGame("Колонизаторы", 3, 4, 90, 10, 30.0f));
        gameShop.addGame(new BoardGame("Риск", 2, 6, 120, 12, 25.0f));
        gameShop.addGame(new BoardGame("Билет на поезд", 2, 5, 60, 8, 35.0f));
        gameShop.addGame(new BoardGame("Пандемия", 2, 4, 45, 8, 28.0f));
        gameShop.addGame(new BoardGame("Шахматы", 2, 2, 60, 6, 15.0f));
        gameShop.addGame(new BoardGame("Клудо", 2, 6, 45, 8, 22.0f));
        gameShop.addGame(new BoardGame("Эрудит", 2, 4, 50, 10, 18.0f));
        gameShop.addGame(new BoardGame("Уно", 2, 10, 30, 6, 10.0f));
        gameShop.addGame(new BoardGame("Дженга", 1, 8, 20, 6, 12.0f));

        List<Customer> customers = new ArrayList<>();
        String[] gameNames = {"Монополия", "Колонизаторы", "Риск", "Билет на поезд", "Пандемия", "Шахматы", "Клудо", "Эрудит", "Уно", "Дженга"};
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            String randomGame = gameNames[random.nextInt(gameNames.length)];
            float randomMoney = 10 + random.nextFloat() * 40;
            customers.add(new Customer(randomGame, randomMoney));
        }

        int soldGames = 0;
        for (Customer customer : customers) {
            String gameName = customer.getGameName();
            float money = customer.getMoney();
            BoardGame purchasedGame = gameShop.buyGame(gameName, money);

            if (purchasedGame != null) {
                System.out.println("Покупатель купил игру: " + purchasedGame.getName() + " за " + purchasedGame.getPrice() + " $");
                soldGames++;
            } else {
                System.out.println("У покупателя недостаточно средств на счету для покупки игры: " + gameName);
            }

            if (gameShop.getCatalog().isEmpty()) {
                System.out.println("Все игры проданы!");
                break;
            }
        }

        System.out.println("Количество проданных игр: " + soldGames);
        System.out.println("Полученный заработок: " + gameShop.getEarnings() + " Р");
    }
}
