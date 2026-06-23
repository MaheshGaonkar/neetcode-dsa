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
        int n = intervals.size();

        List<Interval> intervalsBasedOnStartTime = new ArrayList<>(intervals);
        Collections.sort(intervalsBasedOnStartTime, (a, b) -> Integer.compare(a.start, b.start));

        List<Interval> intervalsBasedOnEndTime = new ArrayList<>(intervals);
        Collections.sort(intervalsBasedOnEndTime, (a, b) -> Integer.compare(a.end, b.end));

        int totalRoom = 0;

        int startTimePointerIndex = 0;
        int endTimePointerIndex = 0;

        while(startTimePointerIndex < n) {
            Interval startMeeting = intervalsBasedOnStartTime.get(startTimePointerIndex++);
            Interval endMeeting = intervalsBasedOnEndTime.get(endTimePointerIndex);
            
            if (endMeeting.end <= startMeeting.start) {
                endTimePointerIndex++;
            } else {
                totalRoom++;
            }

        }
        return totalRoom;
    }
}
