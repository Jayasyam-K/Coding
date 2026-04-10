class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer,Integer> prev=new HashMap<>();
        Map<Integer,Integer> diff=new HashMap<>();
        int result=500,n=nums.length;
        for(int i=0;i<n;i++){
            if(diff.containsKey(nums[i])){
                int a=diff.get(nums[i]);
                int b=i-prev.get(nums[i]);
                diff.put(nums[i],b);
                result=Math.min(result,2*(a+b));
            }else if(prev.containsKey(nums[i])){
                diff.put(nums[i],i-prev.get(nums[i]));
            }
            prev.put(nums[i],i);
        }
        return result==500?-1:result;
    }
}