package worldcup.dto;

import worldcup.vo.ScoreByNation;

import java.util.ArrayList;
import java.util.List;

public class MatchResultByGroupDto {
    List<ScoreByNation> scoreByNations = new ArrayList<>();

    public void add(ScoreByNation score) {
        scoreByNations.add(score);
    }
}
