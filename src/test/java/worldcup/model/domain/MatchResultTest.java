package worldcup.model.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MatchResultTest {
    @Test
    void 경기_결과_계산_승리() {
        assertThat(MatchResult.computeResult(3, 0)).isEqualTo(MatchResult.WIN);
    }

    @Test
    void 경기_결과_계산_무승부() {
        assertThat(MatchResult.computeResult(1, 1)).isEqualTo(MatchResult.DRAW);
    }

    @Test
    void 경기_결과_계산_패배() {
        assertThat(MatchResult.computeResult(1, 2)).isEqualTo(MatchResult.LOSE);
    }
}