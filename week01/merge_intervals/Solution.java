import java.util.*;
import java.io.*;
import java.math.*;


// time O(nlogn), O(n) space
class Solution {
    // -------
    //     ==========

    // ------- ======= 

    // ----------
    //   =====  
    class Interval {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int[][] merge(int[][] intervals) {
        List<Interval> intervalList = new ArrayList<>();
        if (intervals.length == 0) return new int[0][0];
        for(int i=0; i<intervals.length; i++) {
            intervalList.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(intervalList, (i1, i2) -> Integer.compare(i1.start, i2.start));
        List<Interval> mergedIntervals = new ArrayList<>();
        Interval currentInterval = intervalList.get(0);
        for(int i=1; i<intervalList.size(); i++) {
            if (currentInterval.end >= intervalList.get(i).start) {
                currentInterval.end = Math.max(currentInterval.end, intervalList.get(i).end);
            } else {
                mergedIntervals.add(currentInterval);
                currentInterval = new Interval(intervalList.get(i).start, intervalList.get(i).end);
            }
        }
        mergedIntervals.add(currentInterval);
        int[][] mergedList = new int[mergedIntervals.size()][2];
        for(int i=0; i<mergedIntervals.size(); i++) {
            mergedList[i][0] = mergedIntervals.get(i).start;
            mergedList[i][1] = mergedIntervals.get(i).end;
        }
        return mergedList;
    }
}
