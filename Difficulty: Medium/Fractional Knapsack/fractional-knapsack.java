class Pair {
    double perUnitVal;
    int wt;
    
    public Pair(double perUnitVal, int wt) {
        this.perUnitVal = perUnitVal;
        this.wt = wt;
    }
}

class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.perUnitVal, a.perUnitVal));
        
        int wtArrSize = wt.length;
        
        for (int ind = 0; ind < wtArrSize; ind++) {
            
            double perUnitVal = (double)val[ind] / wt[ind];
            pq.add(new Pair(perUnitVal, wt[ind]));
        }
        
        int currentCap = 0;
        
        double ans = (int)0;
        

        while (currentCap < capacity && !pq.isEmpty()) {
            Pair curPair = pq.poll();
          
            int curTotalWt = curPair.wt;
            double curVal = curPair.perUnitVal;
            
            // System.out.println(curTotalWt + "<=====curTotalWt====");
            // System.out.println(curVal + "<====curVal");
            // System.out.println(capacity + "<=======capacity");
            // System.out.println(currentCap + "<===currentCap");
            int curWt = (capacity >= (currentCap + curTotalWt) ) ? curTotalWt : (capacity - currentCap);
            
            // System.out.println(curWt + "<======curWt");
            // System.out.println("...................................");
            currentCap += curWt;
            ans = ans + (double)(curVal * curWt);

        }
        
        return ans;
    }
}





