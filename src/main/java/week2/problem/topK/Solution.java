package week2.problem.topK;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 核心思想，首先维护一个map用来存放数字出现次数，然后遍历map，把数据放入小顶堆里，如果堆里的数据达到k个了，就看这个数字出现的个数是否是大于
 * 堆顶，如果大于，就把堆顶诺迪奥，然后把新的元素放进去。如果堆里的元素没有k个，就直接放堆里就行了。
 * 然后遍历堆就可以了。
 * 时间复杂度
 * 生成hashmap O(n)
 * 生成堆O(nlogk)
 * 遍历hashmap O(k)
 * 加起来是nlogk
 * 还有一种解法是用快排的解法。后面再看
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //先声明一个hashmap用来存放数字的出现次数
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            //这里有个小技巧就是Map的GetOrDefort方法，可以在取不到这个key的时候给一个默认值
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }
        //声明一个小顶堆，指定排序的key是出现次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        //遍历map，如果堆的大小是k了，就看
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }
}
