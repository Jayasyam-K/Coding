class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] boxedArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(boxedArr,(a,b) -> {
            int bitsA = Integer.bitCount(a);
            int bitsB = Integer.bitCount(b);
            if(bitsA == bitsB){
                return a.compareTo(b);
            }
            return Integer.compare(bitsA,bitsB);
        });
        return Arrays.stream(boxedArr).mapToInt(Integer::intValue).toArray();
        
    }
}