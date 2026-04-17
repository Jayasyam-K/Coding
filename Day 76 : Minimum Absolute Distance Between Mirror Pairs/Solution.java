class Solution {
    public int minMirrorPairDistance(int[] nums) {

        HashMap<Integer , Integer> hm = new HashMap<>();
        hm.put(nums[nums.length-1] , nums.length-1);

        int minimum = Integer.MAX_VALUE ;

        for(int i = nums.length -2 ; i>=0 ; i--){

            int rev = reverse(nums[i]);

            if(hm.containsKey(rev)){
                int dist = Math.abs(hm.get(rev) - i);
                minimum = Math.min(minimum , dist);
            }

            hm.put(nums[i] , i);
            
        }

        if(minimum == Integer.MAX_VALUE) return -1 ; 
        return minimum ; 
        
    }

    public int reverse(int n){

        int rev = 0 ;

        while(n!=0){

            int ld = n%10 ;
            rev = rev*10 + ld ;
            n = n/10;
        }
        return rev ; 
    }
}