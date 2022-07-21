import com.example.tictactoe.Strategies.NormalWinningStrategy;
import com.example.tictactoe.Strategies.WinningStrategy;
import com.example.tictactoe.controllers.GameController;
import com.example.tictactoe.models.*;

import java.util.List;

public class GameSimulator {


   public static void main(String []Args) {
       int dimension = 3;
       Players p1 = new HumanPlayer(new Symbol('X'), "Hello", "Player1");
       Players p2= new BotPlayer(DifficultyLevel.EASY, new Symbol('O'));
       WinningStrategy winningStrategy=new NormalWinningStrategy();

       GameController gameController=new GameController();
       Game game=gameController.gameCreator(dimension, List.of(p1,p2),List.of(winningStrategy));
       while (gameController.gameStatus(game).equals(GameStatus.IN_PROGRESS))
       {
           System.out.println("______________________________");
           gameController.display(game);
           gameController.makeMove(game);
       }



   }

}
