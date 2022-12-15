package worldcup.controller;

import worldcup.group.Group;
import worldcup.group.GroupRepository;
import worldcup.match.MatchRepository;
import worldcup.nation.Nation;
import worldcup.nation.NationRepository;
import worldcup.vo.Score;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SetupController extends AbstractController {

    public static final String SPACE = " ";
    public static final String MATCH_RESULT_FILE_PATH = "src/main/resources/MatchResult.txt";
    public static final String UNREADABLE_FILE_EXCEPTION = "파일을 읽을 수 없습니다.";

    @Override
    void doProcess() {
        try {
            Scanner scanner = new Scanner(new File(MATCH_RESULT_FILE_PATH));
            while (scanner.hasNext()) {
                doSavingMatchInformation(scanner);
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(UNREADABLE_FILE_EXCEPTION);
        }
    }

    private static void doSavingMatchInformation(Scanner scanner) {
        String[] matchInfoSentence = getMatchInfoSentence(scanner);

        Group group = getGroup(matchInfoSentence);
        Score score = getScore(matchInfoSentence[1], matchInfoSentence[4]);
        Score anotherScore = getScore(matchInfoSentence[3], matchInfoSentence[6]);

        MatchRepository.save(group, score, anotherScore);
    }

    private static String[] getMatchInfoSentence(Scanner scanner) {
        String matchInfo = scanner.nextLine();
        return matchInfo.split(SPACE);
    }

    private static Score getScore(String nationName, String scoreValue) {
        Nation nation = NationRepository.saveByName(nationName);
        int nationScore = Integer.parseInt(scoreValue);
        return new Score(nation, nationScore);
    }

    private static Group getGroup(String[] matchInfoSplitted) {
        return GroupRepository.saveByName(matchInfoSplitted[0]);
    }
}
