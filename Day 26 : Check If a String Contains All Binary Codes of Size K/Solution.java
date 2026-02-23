class Solution {
    public boolean hasAllCodes(String s, int k) {
        int need = 1<<k;
        Set<String> Temp= new HashSet<>();
        for(int i=0;i<=s.length()-k;i++){
            Temp.add(s.substring(i,i+k));
            if(Temp.size()==need){
                return true;
            }
        }
        return Temp.size() == need;
    }
}