<h2><a href="https://www.geeksforgeeks.org/problems/max-circular-subarray-sum-1587115620/1?page=1&sprint=6953b4d1fce7211810a91af47ee09295&sortBy=submissions">Max Circular Subarray Sum</a></h2><h3>Difficulty Level : Difficulty: Hard</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">Given an array of integers <strong>arr[]</strong> in a <strong>circular</strong> fashion. Your task is to find and return the <strong>maximum </strong>subarray sum that we can get, if we assume the array to be circular.</span></p>
<p><span style="font-size: 18px;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input: </strong>arr[] = [8, -8, 9, -9, 10, -11, 12]
<strong>Output: </strong>22<strong>
Explanation:</strong></span><span style="font-size: 18px;">Starting from the last element of the array, i.e, 12, and moving in a circular fashion, <br>we have max subarray as 12, 8, -8, 9, -9, 10, which gives maximum sum as 22.</span></pre>
<pre><span style="font-size: 18px;"><strong>Input: </strong>arr[] = [10, -3, -4, 7, 6, 5, -4, -1]
<strong>Output: </strong>23<strong>
Explanation: </strong>Maximum<strong> s</strong>um of the circular subarray is 23. The subarray is [7, 6, 5, -4, -1, 10].</span>
</pre>
<p><span style="font-size: 18px;"><strong>Expected Time Complexity:&nbsp;</strong>O(n).<br><strong>Expected Auxiliary Space:&nbsp;</strong>O(1).</span></p>
<p><br><span style="font-size: 18px;"><strong>Constraints:</strong><br>1 &lt;= arr.size() &lt;= 10<sup>6</sup><br>-10<sup>6 </sup>&lt;= arr[i] &lt;= 10<sup>6</sup></span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Amazon</code>&nbsp;<code>Microsoft</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Arrays</code>&nbsp;<code>Data Structures</code>&nbsp;