class Solution {
    public int numSteps(String s) {
        int operations = 0;
        int carry = 0;
        int n = s.length();
        for(int i =n-1;i>0;i--){
            int digit = (s.charAt(i) - '0') + carry;
            if(digit % 2 == 1){
                operations+=2;
                carry = 1;
            }
            else{
                operations+=1;
            }
        }
        return operations+carry;
    }
}