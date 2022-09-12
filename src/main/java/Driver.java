import model.Board;
import model.Ladder;
import model.Player;
import model.Snake;
import service.SnakeAndLadderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of players");
        int noOfPlayer = sc.nextInt();
        List<Player>players = new ArrayList<>();
        for(int i = 0;i<noOfPlayer;i++){
            Player p1 = new Player();
            p1.setId(i);
            System.out.println("enter the player name");
            p1.setName(sc.next());
            players.add(p1);
        }

        System.out.println("enter the no of snakes");
        int noOfSnakes = sc.nextInt();
        List<Snake>snakes = new ArrayList<>();
        for(int i = 0;i<noOfSnakes;i++){
            Snake s1 = new Snake();
            s1.setId(i);
            System.out.println("enter the start position");
            s1.setStart(sc.nextInt());
            System.out.println("enter the end position");
            s1.setEnd(sc.nextInt());
            snakes.add(s1);
        }

        System.out.println("enter the no of ladders");
        int noOfLadders = sc.nextInt();
        List<Ladder>ladders = new ArrayList<>();
        for(int i = 0;i<noOfLadders;i++){
            Ladder l1 = new Ladder();
            l1.setId(i);
            System.out.println("enter the start position");
            l1.setStart(sc.nextInt());
            System.out.println("enter the end position");
            l1.setEnd(sc.nextInt());
            ladders.add(l1);
        }

        Board board = new Board();
        board.setLadders(ladders);
        board.setSnaks(snakes);

        SnakeAndLadderService snakeAndLadderService = new SnakeAndLadderService();
        snakeAndLadderService.setBoard(board);
        snakeAndLadderService.setPlayers(players);
        snakeAndLadderService.startGame();

    }
}
