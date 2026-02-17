class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        // Creating a new list to store the result
        List<String> result = new ArrayList<>();
        // Iterating through hours (12 hours)
        for (int hours = 0; hours < 12; hours++) {
            // Iterating through minutes (60 minutes)
            for (int minutes = 0; minutes < 60; minutes++) {
                // Check if bitCount matches with the turnedOn
                if (Integer.bitCount(hours) + Integer.bitCount(minutes) == turnedOn) {
                    // Add the result to the list in the format H:MM
                    result.add(String.format("%d:%02d", hours, minutes));
                }
            }
        }
        return result;
    }
}