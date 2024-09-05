package scn1.algh.stackqueue;

import java.util.*;

public class StackQueueTopics {
    static Stack<Integer> stackIn = new Stack<>();
    static Stack<Integer> stackOut = new Stack<>();

    /**
     * 有效括号
     */
    public Boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '{') {
                characterStack.push('}');
            } else if (ch == '[') {
                characterStack.push(']');
            } else if (ch == '(') {
                characterStack.push(')');
            } else {
                Character pop = characterStack.pop();
                if (ch != pop) break;
            }
            if (characterStack.isEmpty()) return true;
        }
        return false;
    }


    public String deleteDouble(String string) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = string.toCharArray();
        stack.push(charArray[0]);
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == stack.peek()) {
                stack.pop();
            } else {
                stack.push(charArray[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    /**
     * 滑动窗口最大值
     * nums为目标数组 k为窗口大小
     */
    public int[] findMaxInWindows(int[] nums, int k) {
        MyQueue queue = new MyQueue();
        int len = nums.length - k + 1;
        int[] res = new int[len];
        for (int i = 0; i < k; i++) {
            queue.push(nums[i]);
        }
        int num = 0;
        res[num++] = queue.front();
        for (int i = k; i < nums.length; i++) {
            queue.pop(nums[i - k]);
            queue.push(nums[i]);
            res[num++] = queue.front();
        }
        return res;
    }

    /**
     * 返回数组出现频率前k高的元素
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topK(int[] nums, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            heap.offer(new int[]{integerIntegerEntry.getKey(), integerIntegerEntry.getValue()});
        }
        int index = 0;
        int[] res = new int[k];
        while (!heap.isEmpty()) {
            res[index++] = heap.poll()[0];
        }
        return res;
    }
}

/**
 * 构建单调队列
 */
class MyQueue {
    Deque<Integer> queue = new LinkedList<>();

    void push(Integer num) {
        while (!queue.isEmpty() && num > queue.getLast()) {
            queue.removeLast();
        }
        queue.addLast(num);
    }

    void pop(Integer num) {
        if (!queue.isEmpty() && num.equals(queue.getFirst())) {
            queue.pop();
        }
    }

    int front() {
        return queue.getFirst();
    }

}