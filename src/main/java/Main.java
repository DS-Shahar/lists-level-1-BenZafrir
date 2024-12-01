import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main{
  public static List<Integer> generateRandomList(int x, int y) {
        List<Integer> randomList = new ArrayList<>();
        Random rand = new Random();
        
        for (int i = 0; i < 20; i++) {
            int randomNumber = rand.nextInt(y - x + 1) + x;
            randomList.add(randomNumber);
        }
        return randomList;
  }
  public static int countOccurrences(List<Integer> list, int x) {
        int count = 0;
        for (int number : list) {
            if (number == x) {
                count++;
            }
        }
        return count;
  }
}
