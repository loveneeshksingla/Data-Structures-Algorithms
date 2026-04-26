
class Pair {
    int value;
    int index;
    public Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }
}


class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> heap = new PriorityQueue<>(
            (a, b) -> b.value - a.value);
 
        // Initialize the heap with the first k elements
        for (int i = 0; i < k; i++) {
            heap.offer(new Pair(arr[i], i));
        }
 
        // The maximum element in the first window
        ans.add(heap.peek().value);
 
        // Process the remaining elements
        for (int i = k; i < arr.length; i++) {
            heap.offer(new Pair(arr[i], i));
 
            // Remove elements that are outside the current
            // window
            while (heap.peek().index <= i - k) {
                heap.poll();
            }
 
            // The maximum element in the current window
            ans.add(heap.peek().value);
        }
 
        return ans;
    }
}