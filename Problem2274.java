import java.util.Arrays;

public class Problem2274 {

    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int max=special[0]-bottom;
        for(int i=1;i<special.length;i++)
        {
            max=Math.max(max,special[i]-special[i-1]-1);
        }
        max=Math.max(top-special[special.length-1],max);
        return max;
    }
}