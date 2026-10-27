```java
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    public static int diagonalDifference(List<List<Integer>> arr) {
        int n = arr.size();

        int Rightsum = 0;
        int Leftsum = 0;

        for (int c = 0; c < n; c++) {
            int Right = arr.get(c).get(c);
            Rightsum += Right;
        }

        for (int d = 0; d < n; d++) {
            int Left = arr.get(d).get(n - 1 - d);
            Leftsum += Left;
        }

        int DiagonalDiff = Math.abs(Rightsum - Leftsum);
        return DiagonalDiff;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(
                Stream.of(bufferedReader.readLine().trim().split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(toList())
            );
        }

        int result = Result.diagonalDifference(arr);

        System.out.println(result);

        bufferedReader.close();
    }
}

```