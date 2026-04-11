class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(!map.containsKey(nums[i])) map.put(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        int result=Integer.MAX_VALUE;
        for(int i:map.keySet()){
            List<Integer> arr=map.get(i);
            if(arr.size()>=3){
                for(int j=0;j<arr.size()-2;j++){
                    result=Math.min(result,
                                (arr.get(j+1)-arr.get(j))+
                                (arr.get(j+2)-arr.get(j+1))+
                                (arr.get(j+2)-arr.get(j)));
                }
            }
        }
        return result==Integer.MAX_VALUE?-1:result;
    }
}