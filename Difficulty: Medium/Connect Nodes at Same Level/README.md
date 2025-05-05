<h2><a href="https://www.geeksforgeeks.org/problems/connect-nodes-at-same-level--170647/1?page=11&company=Microsoft&difficulty=Medium,Hard&status=solved&sortBy=submissions">Connect Nodes at Same Level</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO"><div class="entry-content">
<p><span style="font-size: 18px;">Given a binary tree, connect the nodes that are at the same level. The structure of the tree Node contains&nbsp;an addition&nbsp;nextRight&nbsp;pointer for this purpose.</span></p>
<p><span style="font-size: 18px;">Initially, all the nextRight pointers point to garbage values. Your&nbsp;should set these pointers to point next right for each node.</span><br><br><span style="font-size: 18px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 10&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; 10 ------&gt; NULL<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; / \&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; /&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<br>&nbsp;&nbsp;&nbsp;&nbsp; 3&nbsp;&nbsp; 5&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; =&gt; &nbsp;&nbsp;&nbsp; 3 ------&gt; 5 --------&gt; NULL<br>&nbsp;&nbsp;&nbsp; / \&nbsp; &nbsp;&nbsp; \&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; /&nbsp; \&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \<br>&nbsp;&nbsp; 4&nbsp;&nbsp; 1&nbsp;&nbsp; 2&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp; 4 --&gt; 1 -----&gt; 2 -------&gt; NULL</span></p>
<p><span style="font-size: 18px;"><strong>Note: </strong>The generated output will contain 2 lines. First line contains the level order traversal of the tree and second line contains the inorder traversal of the tree.</span></p>
<p><span style="font-size: 18px;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input: </strong>root = [3, 1, 2]
     3
&nbsp;  /  \
&nbsp; 1    2
<strong>Output:
</strong>[3, 1, 2]
[1, 3, 2]<strong>
Explanation: </strong>The connected tree is
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 3 ------&gt; NULL
&nbsp;&nbsp;&nbsp;&nbsp; /&nbsp;&nbsp; \
&nbsp;&nbsp;  1---&gt; 2 -----&gt; NULL</span>
</pre>
<pre><span style="font-size: 18px;"><strong>Input: </strong>root = [10, 20, 30, 40, 60]
      10
&nbsp;   /   \
&nbsp;  20   30
&nbsp; /  \
 40  60
<strong>Output:
</strong>[10, 20, 30, 40, 60]
[40, 20, 60, 10, 30]<strong>
Explanation: </strong>The connected tree is
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;10 ---&gt; NULL
&nbsp;&nbsp;&nbsp;  &nbsp; /&nbsp;&nbsp;&nbsp;\
&nbsp;&nbsp;&nbsp;&nbsp; 20---&gt; 30 ---&gt; NULL
&nbsp;&nbsp; /&nbsp;&nbsp; \
&nbsp;40---&gt; 60 ---&gt; NULL</span></pre>
<p><strong style="font-size: 18px;">Constraints:</strong></p>
</div>
<p><span style="font-size: 18px;">1 ≤ number of nodes ≤ 10<sup>5</sup><br>0 ≤ node-&gt;data ≤ 10<sup>5</sup></span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Flipkart</code>&nbsp;<code>Accolite</code>&nbsp;<code>Amazon</code>&nbsp;<code>Microsoft</code>&nbsp;<code>OYO Rooms</code>&nbsp;<code>Ola Cabs</code>&nbsp;<code>Oracle</code>&nbsp;<code>Adobe</code>&nbsp;<code>Google</code>&nbsp;<code>Boomerang Commerce</code>&nbsp;<code>Xome</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Tree</code>&nbsp;<code>Data Structures</code>&nbsp;