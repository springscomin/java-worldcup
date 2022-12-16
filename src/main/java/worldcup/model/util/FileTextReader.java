package worldcup.model.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileTextReader {
    private FileTextReader() {
    }

    public static List<String> readTextLines(String path) throws IOException {
        List<String> result = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String readValue;
        while ((readValue = reader.readLine()) != null) {
            result.add(readValue);
        }
        return result;
    }

}
