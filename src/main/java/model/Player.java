package model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
public class Player {
    int id;
    String name;
    Player pos;

    public Player(int id, String name, Player pos) {
        this.id = id;
        this.name = name;
        this.pos = pos;
    }
}
