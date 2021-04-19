package week3.excise.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FullPermutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }
        System.out.println(output);
        int n = nums.length;
        //开始递归
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    public static void main(String[] argvs){
        FullPermutation fp = new FullPermutation();
        List<List<Integer>>  res = fp.permute(new int[]{1,2,3});
        System.out.print(res);

    }
}
