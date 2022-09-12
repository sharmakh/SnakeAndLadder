package model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
public class Ladder {
    int start;
    int end;
    int id;

    public Ladder(int start, int end, int id) {
        this.start = start;
        this.end = end;
        this.id = id;
    }
}
