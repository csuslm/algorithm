package scn1.algh.arrays.sort;

public class choose {
    //O(n2)
    private static void chooseSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int k = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[k]) {
                    k = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[k];
            nums[k] = tmp;
        }
    }
    //O(n2)
    /*private static void bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[j + 1]) {
                    int tmp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }*/

    private static void bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[j + 1]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    private static void insertSort(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > cur) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = cur;
        }
    }

    public static void quickSort(int[] nums,int left,int right)
    {
        if(left >= right){
            return;
        }
        int div = partition(nums,left,right);
        quickSort(nums,left,div-1);
        quickSort(nums,div+1,right);
    }

    private static int partition(int[] nums, int left, int right) {
        int i = left,j = right;
        while(i < j){
            while(i < j && nums[j] >= nums[left])
                j--;
            while(i < j && nums[i] <= nums[left])
                i++;
            swap(nums,i,j);
        }
        swap(nums,left,i);
        return i;
    }

    public static void swap(int[] nums,int left,int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{23,12,5,787,1,6,4,9,5,4545,1,5,85,11,12};
        quickSort(nums,0,nums.length-1);
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
