package model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
public class Snake {
    int start;
    int end;
    int id;

    public Snake(int start, int end, int id) {
        this.start = start;
        this.end = end;
        this.id = id;
    }
}
