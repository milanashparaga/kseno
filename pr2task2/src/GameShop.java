import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameShop {
    private final Map<String, BoardGame> gamesCatalog;
    private float earnings;

    public GameShop() {
        this.gamesCatalog = new HashMap<>();
        this.earnings = 0;
    }

    public void addGame(BoardGame game) {
        gamesCatalog.put(game.getName(), game);
    }

    public BoardGame buyGame(String gameName, float customerMoney) {
        BoardGame game = gamesCatalog.get(gameName);

        if (game != null && customerMoney >= game.getPrice()) {
            gamesCatalog.remove(gameName);
            earnings += game.getPrice();
            return game;
        }
        return null;
    }

    public float getEarnings() {
        return earnings;
    }

    public List<BoardGame> getCatalog() {
        return gamesCatalog.values().stream().toList();
    }
}

