<h2><a href="https://www.geeksforgeeks.org/problems/maximize-the-array3340/1?page=1&sprint=0ec03cea5d45f27194a614ac5db94f0c&sortBy=submissions">Maximize The Array</a></h2><h3>Difficulty Level : Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given two integer arrays Arr1 and Arr2 of size N. Use the greatest elements from the given arrays to create a new array of size N such that it consists of only unique elements and the sum of all its elements is maximum.<br>
The created elements should contain the elements of Arr2 followed by elements of Arr1 in order of their appearance.</span></p>

<p><span style="font-size:18px"><strong>Note:</strong> The input array will be given in such way, that every time it is possible to make a new arr by maintaing the following conditions.</span></p>

<p><br>
<span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>N = 5
Arr1 = {7, 4, 8, 0, 1}
Arr2 = {9, 7, 2, 3, 6}
<strong>Output: </strong>9 7 6 4 8
<strong>Explanation:</strong> 9, 7, 6 are from 2nd array
and 4, 8 from 1st array.</span></pre>

<p><br>
<span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input: </strong>N = 4
Arr1 = {6, 7, 5, 3}
Arr2 = {5, 6, 2, 9} 
<strong>Output:</strong> 5 6 9 7 
<strong>Explanation:</strong> 5, 6, 9 are from 2nd array
and 7 from 1st array.</span></pre>

<p><br>
<span style="font-size:18px"><strong>Your Task: </strong><br>
You don't need to read input or print anything. Your task is to complete the function <strong>maximizeArray()</strong> which takes the array arr1[], arr2[] and n as input parameters and returns the desired array of integers.</span></p>

<p><br>
<span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(NlogN)<br>
<strong>Expected Auxiliary Space:</strong> O(N)</span></p>

<p><br>
<span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= N &lt;= 10<sup>5</sup><br>
0 &lt;=| Arr1[i] |&lt;= 10<sup>9</sup><br>
0 &lt;= |Arr2[i] |&lt;= 10<sup>9</sup></span></p>
</div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Microsoft</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Arrays</code>&nbsp;<code>Mathematical</code>&nbsp;<code>Numbers</code>&nbsp;<code>Heap</code>&nbsp;<code>Data Structures</code>&nbsp;<code>Algorithms</code>&nbsp;