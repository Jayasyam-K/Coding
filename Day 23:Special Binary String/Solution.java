class Solution {
    public String makeLargestSpecial(String s) {
        int n = s.length();
        int count = 0;
        int i = 0;
        List<String> result = new ArrayList<>();
        for(int j=0;j<n;j++){
            if(s.charAt(j)=='1'){
                count++;
            }else{
                count--;
            }
            if(count == 0){
               String middle = s.substring(i+1,j);
               String middleOptimized = makeLargestSpecial(middle);
               result.add('1'+middleOptimized+'0');
               i=j+1;
            }
        }
        Collections.sort(result,Collections.reverseOrder());
        return String.join("",result);
    }
}