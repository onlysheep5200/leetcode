package problem78;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yaodong.hyd on 2016/7/26.
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<>());
        for (int i = 0;i<nums.length;i++){
            LinkedList<Integer> list = new LinkedList<>();
            list.add(nums[i]);
            sub(nums,i+1,0,list,result);
        }
        return result;
    }

    public  void sub(int[] nums,int start,int lengthBefore,LinkedList<Integer> listBefore,List<List<Integer>> result){
        if (listBefore.size() >0 && listBefore.size() != lengthBefore)
        {
            result.add((List<Integer>) listBefore.clone());
        }
        if (start >= nums.length)
            return;
        sub(nums,start+1,listBefore.size(), (LinkedList<Integer>) listBefore.clone(),result);
        listBefore.add(nums[start]);
        sub(nums,start+1,listBefore.size()-1, (LinkedList<Integer>) listBefore.clone(),result);
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.subsets(new int[]{1,2,3,4}));
    }

}
