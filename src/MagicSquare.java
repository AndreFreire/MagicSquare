import java.util.HashMap;
import java.util.Map;

public class MagicSquare {

    public static void main(final String[] args) throws Exception {

        final int[][] square = FileParser.parseMatrix(args[0]);

        calculateMagicSquare(square);

    }

    private static void calculateMagicSquare(final int[][] square) {
        final Map<String, Integer> sums = new HashMap<>();
        String identifier;
        int element;
        for(int i = 0; i < square.length; i++) {
            for(int j = 0; j < square.length; j++) {
                element = square[i][j];
                identifier = String.format("L_%d", i);
                sums.put(identifier, sums.getOrDefault(identifier, 0 ) + element );

                identifier = String.format("C_%d", i);
                sums.put(identifier, sums.getOrDefault(identifier, 0 ) + element );

                if(j == i){
                    identifier = "D1";
                    sums.put(identifier, sums.getOrDefault(identifier, 0 ) + element );
                }

                if(j + i + 1 == square.length){
                    identifier = "D2";
                    sums.put(identifier, sums.getOrDefault(identifier, 0 ) + element );
                }
            }
        }

        final long count = sums.values().stream().distinct().count();

        if(count == 1) {
            System.out.println("É um quadrado mágico");
        } else {
            System.out.println("Não é um quadrado mágico");
        }
    }


}
