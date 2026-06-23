/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (null == intervals || intervals.size() == 0) {
            return 0;
        }

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        
        PriorityQueue<Interval> occupiedRoomMinHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.end, b.end));
        int totalRoom = 0;

        for(int i = 0; i < intervals.size(); i++) {
            Interval currentMeeting = intervals.get(i);
            while(!occupiedRoomMinHeap.isEmpty() && occupiedRoomMinHeap.peek().end <= currentMeeting.start) {
                occupiedRoomMinHeap.poll();
            }
            occupiedRoomMinHeap.offer(currentMeeting);
            totalRoom = Math.max(totalRoom, occupiedRoomMinHeap.size());
        }

        return totalRoom;
    }
}
