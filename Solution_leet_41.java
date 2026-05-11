ort java.util.ArrayList;
import java.util.List;

class Solution_leet_41 {
    public int[] separateDigits(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        
        for (int num : nums) {
            // Convert number to string to easily access each digit
            String s = Integer.toString(num);
            for (char c : s.toCharArray()) {
                // Convert char back to digit and add to list
                resultList.add(c - '0');
            }
        }
        
        // Convert the List back to an int array
        int[] answer = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }
        
        return answer;
    }
}
