import java.util.*;
import java.io.*;
import java.math.*;

// TC: O(log 2(n)) 
// MC: O(1)

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int L = 1;
        int R = n;
        while(R > L){
            int mid = L + (R - L)/2;
            if(!isBadVersion(mid)) L = mid + 1;
            else R = mid; 
        }
        return L;
    }
}
