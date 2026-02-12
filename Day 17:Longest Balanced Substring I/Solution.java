class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int result = 0;
        for(int i=0;i<n;++i){
            int[] count = new int[26];
            for(int j = i;j<n;++j){
                count[s.charAt(j) - 'a']++;
                boolean valid = true;
                int freq = -1;
                for(int k=0;k<26;++k){
                    if(count[k] > 0){
                        if(freq == -1){
                            freq = count[k];
                        }
                        else if(freq!= count[k]){
                            valid = false;
                            break;
                        }
                    }
                }
            if(valid){
                result = Math.max(result,j-i+1);
            }
            }
        }
        return result;
    }
}