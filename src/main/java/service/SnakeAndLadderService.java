package service;

import model.Board;
import model.Ladder;
import model.Player;
import model.Snake;

import java.util.*;

public class SnakeAndLadderService {
    private Board board;
    private Queue<Player> playerQueue;
    private boolean isGameCompleted;
    private List<Player> players;

    public SnakeAndLadderService(){
        playerQueue = new LinkedList<>();
        isGameCompleted = false;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
        Map<Integer,Integer> playerPos = new HashMap<>();
        for(Player p : players){
            playerPos.put(p.getId(),0);
            playerQueue.add(p);
        }
        this.board.setPlayerPos(playerPos);
    }
    public int checkForSnakes(int currPos,int newPos){
        int pos = currPos+newPos;
        for(Snake s: board.getSnaks()){
            if(s.getStart() == pos){
                newPos = s.getEnd();
                return newPos;
            }
        }
        return newPos+currPos;
    }
    public int checkForLadders(int currPos,int newPos){
        int pos = currPos+newPos;
        for(Ladder l: board.getLadders()){
            if(l.getEnd() == pos){
                newPos = l.getStart();
                return newPos;
            }
        }
        return newPos+currPos;
    }

    public void startGame(){
        while (!playerQueue.isEmpty()){
            Player p = playerQueue.poll();
            int currPos = board.getPlayerPos().get(p.getId());
            int newpos = DiceService.roll();
            if(currPos + newpos >= 100){
                System.out.println("player "+p.getName()+" has won the game");
                break;
            }
            else{
                int ladnewpos = checkForLadders(currPos,newpos);
                int snnewpos = checkForSnakes(currPos,newpos);
                if(ladnewpos != currPos+newpos){
                    newpos = ladnewpos;
                }
                if(snnewpos != currPos+newpos){
                    newpos = snnewpos;
                }
                if(newpos == 100){
                    System.out.println("player "+p.getName()+" has won the game");
                    break;
                }
            }
            board.getPlayerPos().put(p.getId(),newpos);
            playerQueue.add(p);
        }
    }
}
