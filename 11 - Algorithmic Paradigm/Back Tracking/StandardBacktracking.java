/*
This structure might apply to many other backtracking questions, but here I am just going to demonstrate Subsets, Permutations, and Combination Sum.
 */

//Subsets - https://leetcode.com/problems/subsets/
class Solution_Subsets {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, new ArrayList<Integer>(), 0);
        return ans;
    }

    public void helper (int nums[], ArrayList<Integer> temp, int x) {
        if(x <= nums.length) {
            ans.add(new ArrayList<Integer>(temp));
        }

        if(x>nums.length) return;

        for( int i=x; i<nums.length; i++) {
            temp.add(nums[i]);
            helper(nums, temp, i+1); //i+1 will give all subsets, x+1 will give all permutations with repition
            temp.remove(temp.size()-1);
        }
    }
}

//Subsets 2 (with Dups) - https://leetcode.com/problems/subsets-ii/
class Solution_Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    } 
}

//Permutations - https://leetcode.com/problems/permutations/
class Solution_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
     }
     
     private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
           list.add(new ArrayList<>(tempList));
        } else{
           for(int i = 0; i < nums.length; i++){ 
              if(tempList.contains(nums[i])) continue; // element already exists, skip
              tempList.add(nums[i]);
              backtrack(list, tempList, nums);
              tempList.remove(tempList.size() - 1);
           }
        }
     } 
}

//Permutations II (contains duplicates) - https://leetcode.com/problems/permutations-ii/
class Solution_Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                used[i] = true; 
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false; 
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}

//Combination Sum - https://leetcode.com/problems/combination-sum/
class Solution_ComboSum {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, target, new ArrayList<Integer>(), 0, 0);
        return ans;
    }

    public void helper(int[] arr, int target, List<Integer> temp, int start, int sum) {
        if(sum == target) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }

        if (sum>target) return;

        for(int i=start; i<arr.length; i++) {
            temp.add(arr[i]);
            helper(arr, target, temp, i, sum+arr[i]);
            temp.remove(temp.size()-1);
        }
    }
}

//Combination Sum II (can't reuse same element) : https://leetcode.com/problems/combination-sum-ii/
class Solution_ComboSum2 {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
        
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1); 
            }
        }
    } 
}

//Palindrome Partitioning : https://leetcode.com/problems/palindrome-partitioning/
class Solution_PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), s, 0);
        return list;
     }
     
     public void backtrack(List<List<String>> list, List<String> tempList, String s, int start){
        if(start == s.length())
           list.add(new ArrayList<>(tempList));
        else{
           for(int i = start; i < s.length(); i++){
              if(isPalindrome(s, start, i)){
                 tempList.add(s.substring(start, i + 1));
                 backtrack(list, tempList, s, i + 1);
                 tempList.remove(tempList.size() - 1);
              }
           }
        }
     }
     
     public boolean isPalindrome(String s, int low, int high){
        while(low < high)
           if(s.charAt(low++) != s.charAt(high--)) return false;
        return true;
     } 
}

