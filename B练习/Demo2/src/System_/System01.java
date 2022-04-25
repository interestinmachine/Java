package System_;

import java.util.Arrays;

public class System01 {
    public static void main(String[] args) {
        int[] src = new int[]{1,2,3,4,5,6,7};
        int[] dest = new int[3];
        System.arraycopy(src,0,dest,0,3);
        System.out.println(Arrays.toString(dest));
    }
}

