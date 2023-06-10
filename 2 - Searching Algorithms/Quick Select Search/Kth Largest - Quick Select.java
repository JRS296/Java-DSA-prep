class Solution {
    //quickselect: the average of time:o(n), it depends on the pivot we choose.
    //Very Similar to QuickSort - especiallu partition algo
//space:o(logn)
public int findKthLargest(int[] nums, int k) {
        return quickselect(nums, 0, nums.length - 1, k);
    }
public int quickselect(int[] nums, int start, int end, int k){
        if(start >= end) return nums[start];
        int i = start;
        int j = end;
        int pivot = nums[(end - start) / 2 + start];
        while(i <= j){
            while(i <= j && nums[i] > pivot){//Only Change for smallest/largest
                i++;
            }
            while(i <= j && nums[j] < pivot){//Only Change for smallest/largest
                j--;
            }
            if(i <= j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        //start,...,j,i,...,end
        if(start + k - 1 <= j){
            return quickselect(nums, start, j, k);
        }
        if(start + k - 1 >= i){
            return quickselect(nums, i, end, k - i + start);
        }
        return nums[j + 1];
    }
}

/*
Runtime
5 ms
Beats
97.20%
Memory
49.8 MB
Beats
90.33%
 */

//Based off Quick Sort:
class Solution2 {
    //quicksort: time:o(nlogn) space:o(logn)
public int findKthLargest(int[] nums, int k) {
        quicksort(nums, 0, nums.length - 1, k);
        return nums[k - 1];
    }
    public void quicksort(int[] nums, int start, int end, int k){
        if(start >= end) return;
        int i = start;
        int j = end;
        int pivot = nums[(end - start) / 2 + start];
        while(i <= j){
            while(i <= j && nums[i] > pivot){
                i++;
            }
            while(i <= j && nums[j] < pivot){
                j--;
            }
            if(i <= j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        quicksort(nums, start, j, k);
        quicksort(nums, i, end, k);
    }
}

/*
Runtime
36 ms
Beats
54.99%
Memory
49.6 MB
Beats
97.78%
 */