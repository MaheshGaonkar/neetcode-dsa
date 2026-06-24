class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length < k || k < 1) {
            return new int[]{};
        }

        Map<Integer, Integer> numFreqCountMap = new HashMap<>();
        for(int num : nums) {
            int count = numFreqCountMap.getOrDefault(num, 0) + 1;
            numFreqCountMap.put(num, count);
        }

        PriorityQueue<int[]> minHeapByNumFreq = 
        new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        for(Map.Entry<Integer, Integer> numFreqEntry : numFreqCountMap.entrySet()) {
            int[] numWithFreq = new int[]{numFreqEntry.getKey(), numFreqEntry.getValue()};
            minHeapByNumFreq.offer(numWithFreq);

            if (minHeapByNumFreq.size() > k) {
                minHeapByNumFreq.poll();
            }
        }

        int[] topKFreqElements = new int[k];
        for(int i = 0; i < k; i++) {
            topKFreqElements[i] = minHeapByNumFreq.poll()[0];
        }
        return topKFreqElements;
    }
}
