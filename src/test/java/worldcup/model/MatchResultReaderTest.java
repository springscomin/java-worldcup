package worldcup.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import worldcup.model.domain.Match;

class MatchResultReaderTest {
    @Test
    void 파일_정보_저장() {
        List<Match> matches = MatchResultReader.readMatchResult();
        assertThat(matches).hasSize(48);
    }
}