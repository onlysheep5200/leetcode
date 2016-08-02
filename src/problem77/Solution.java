package problem77;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yaodong.hyd on 2016/7/26.
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (n < k ){
            return null;
        }
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        for (int i = 1;i<=n;i++){
            nextPermutation(i+1,n,k,i,new LinkedList<Integer>(),result);
        }

        return result;
    }

    public void nextPermutation(int start,int end,int k,int current,LinkedList<Integer> list,List<List<Integer>> result){
        if (list.size() >= k )
            return;
        else{
            list.add(current);
            if (list.size() == k) {
                result.add(list);
                return;
            }
            for (int i = start;i<=end;i++){
                nextPermutation(i+1,end,k,i, (LinkedList<Integer>) list.clone(),result);
            }
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.combine(4,2));
    }
}
