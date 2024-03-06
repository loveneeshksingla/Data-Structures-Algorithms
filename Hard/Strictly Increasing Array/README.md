<h2><a href="https://www.geeksforgeeks.org/problems/convert-to-strictly-increasing-array3351/0">Strictly Increasing Array</a></h2><h3>Difficulty Level : Hard</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">Given an array <strong>nums</strong> of <strong>n</strong> positive integers. Find the minimum number of operations required to modify the array such that array elements are in strictly increasing order (nums[i] &lt; nums[i+1]).<br>Changing&nbsp;a number to greater or lesser than original number is counted as one operation.</span></p>
<p><span style="font-size: 18px;"><strong>Example 1:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input:<br></strong>n = 6<br>nums = [1, 2, 3, 6, 5, 4]
<strong>Output: <br></strong>2
<strong>Explanation: </strong>By decreasing 6 by 2 and increasing 4 by 2, nums will be like [1, 2, 3, 4, 5, 6] which is stricly </span><span style="font-size: 18px;">increasing.</span>
</pre>
<p><span style="font-size: 18px;"><strong>Example 2:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input:</strong> <br>n = 4<br>nums = [1, 2, 3, 4]
<strong>Output: <br></strong>0</span>
<span style="font-size: 18px;"><strong>Explanation: <br></strong>The array nums is already strictly increasing.</span>
</pre>
<p><span style="font-size: 18px;"><strong>Your Task:</strong><br>You don't need to read or print anything. Your task is to complete the function&nbsp;<strong>min_opeartions()&nbsp;</strong>which takes the array <strong>nums </strong>as input parameter and returns the minimum number of opeartion needed to make the array strictly increasing.</span></p>
<p><span style="font-size: 18px;"><strong>Expected Time Complexity:</strong> O(n<sup>2</sup>)</span><br><span style="font-size: 18px;"><strong>Expected Space Complexity:&nbsp;</strong>O(n)</span></p>
<p><span style="font-size: 18px;"><strong>Constraints:&nbsp;</strong><br>1 &lt;= n &lt;= 10<sup>3</sup><br>1 &lt;= nums[i] &lt;= 10<sup>9</sup></span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Microsoft</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Dynamic Programming</code>&nbsp;<code>Algorithms</code>&nbsp;