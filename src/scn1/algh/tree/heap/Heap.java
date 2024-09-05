package scn1.algh.tree.heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    static int num;

    private final static List<Integer> maxHeap = new ArrayList<>();


    int left(int n) {
        return 2 * n + 1;
    }

    int right(int n) {
        return 2 * n + 2;
    }

    int father(int n) {
        return (n - 1) / 2;
    }

    int peek() {
        return maxHeap.getFirst();
    }

    void push(int i) {
        maxHeap.add(i);
        //从底向上堆化
        heapify(maxHeap.size() - 1);
    }

    void heapify(int i) {
        while (true) {
            int p = father(i);
            if (p < 0 || maxHeap.get(p) >= maxHeap.get(i)) {
                break;
            }
            swap(p, i);
            i = p;
        }
    }

    void swap(int i, int j) {
        int tmp = maxHeap.get(i);
        maxHeap.set(i, maxHeap.get(j));
        maxHeap.set(j, tmp);
    }

    int pop() {
        if (maxHeap.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        swap(0, maxHeap.size() - 1);
        heapifyDown(0);
        int p = maxHeap.removeLast();
        return p;
    }

    void heapifyDown(int i) {
        while (true) {
            // 判断节点 i, l, r 中值最大的节点，记为 ma
            int l = left(i), r = right(i), ma = i;
            if (l < maxHeap.size() && maxHeap.get(l) > maxHeap.get(ma))
                ma = l;
            if (r < maxHeap.size() && maxHeap.get(r) > maxHeap.get(ma))
                ma = r;
            // 若节点 i 最大或索引 l, r 越界，则无须继续堆化，跳出
            if (ma == i)
                break;
            // 交换两节点
            swap(i, ma);
            // 循环向下堆化
            i = ma;
        }
    }
}
