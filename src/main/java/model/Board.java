package model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Builder
@Data
@NoArgsConstructor
public class Board {
    int size;
    List<Snake> snaks;
    List<Ladder>ladders;
    Map<Integer,Integer> playerPos;

    public Board(int size, List<Snake> snaks, List<Ladder> ladders, Map<Integer, Integer> playerPos) {
        this.size = size;
        this.snaks = snaks;
        this.ladders = ladders;
        this.playerPos = playerPos;
    }
}
