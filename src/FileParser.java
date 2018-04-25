import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileParser {

    private final static String SEPARATOR = "\\s+";

    public static int[][] parseMatrix(final String filePath)  throws IOException{

        final Path path=Paths.get(filePath);
        return Files.lines(path)
                .map(l -> l.trim().split(SEPARATOR))
                .map(sa -> Stream.of(sa)
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .toArray(int[][]::new);

    }

}
