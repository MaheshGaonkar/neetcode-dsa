class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (null == strs || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> groupOfAnagramMap = new HashMap<>();

        for(String word : strs) {
            String anagramKey = convertToAnagramKey(word);
            groupOfAnagramMap.computeIfAbsent(anagramKey, key -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(groupOfAnagramMap.values());
    }

    private String convertToAnagramKey(String word) {
        int[] charFreq = new int[26];
        for(int i = 0; i < word.length(); i++) {
            charFreq[word.charAt(i) - 'a']++;
        }
        StringBuilder key = new StringBuilder();
        for(int count : charFreq) {
            key.append(count).append("#");
        }
        return key.toString();
    }
}
