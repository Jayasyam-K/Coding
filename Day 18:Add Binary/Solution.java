class Solution {
    public String addBinary(String a, String b) {
        //Creating a stringBuilder object
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        //We will keep adding the digits from the end of the string until we have processed all the digits and there is no carry left
        while(i>=0 || j>=0 || carry!=0){
            if(i>=0) carry+= a.charAt(i--)-'0';
            if(j>=0) carry+= b.charAt(j--)-'0';
            sb.append(carry%2);
            carry=carry/2;
        }
        //Since we calculated the sum from the end of the string, we need to reverse it before returning
        return sb.reverse().toString();
    }
}