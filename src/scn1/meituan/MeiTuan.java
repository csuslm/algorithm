package scn1.meituan;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MeiTuan {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Slm");
        list.add("Slm1");
        list.add("Slm2");
        list.add("Slm3");
        list.add("Slm4");
        list.add("Slm5");
        list.remove("Slm");
        //removeIf
        System.out.println(list.get(0));
    }
}

/*Scanner scanner = new Scanner(System.in);
int n = scanner.nextInt();
List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
        list.add(scanner.nextInt());
        }
int x = scanner.nextInt();
int y = scanner.nextInt();

int[] nums = new int[n];
int index = 0;
        for (Integer i : list) {
nums[index++] = i;
        }
// x y
// y x
int flag = 0;
        for(int i=0;i<n;i++) {
        if( nums[i] == x) {
        if(nums[i+1] == y||nums[i-1]==y) {
        System.out.println("Yes");
               }else {
                       System.out.println("No");
               }
                       }
                       }*/
