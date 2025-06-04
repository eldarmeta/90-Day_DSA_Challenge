Roadmap: 90-Day DSA Challenge (Easy to Advanced)

Overview: This 90-day roadmap will guide you through daily problem-solving practice, covering fundamental to advanced topics in data structures and algorithms (DSA). It is structured by weeks, each focusing on a core topic (Arrays, Strings, Linked Lists, etc.), with a brief theoretical overview followed by 3 daily coding challenges. The plan starts with easy problems in month 1, moves to intermediate problems in month 2, and tackles advanced problems in month 3. This progression mirrors the typical categories of programming contests – including arrays, data structures, combinatorics, number theory, graphs, dynamic programming, and more ￼. By steadily increasing difficulty, you will build a strong algorithmic foundation from scratch (0) to a “good” level.

How to use this roadmap: Each week, read the short theory notes to understand key concepts (with a focus on Java implementations when relevant), then solve the listed problems (with links) – 3 problems per day. The tasks are curated from LeetCode (interview-style questions), CodeForces (competitive programming puzzles), and other platforms. Keep track of your progress in a notebook or journal, and commit your solutions (e.g. to GitHub) for consistency and contribution. By the end of 90 days, you will have practiced a broad range of important problems in computer science and discrete mathematics, in Java and general algorithmic contexts.

Note: It’s normal if you find some problems challenging – the difficulty increases gradually. Use the theory notes and hints from similar problems to guide you. Consistency is key (3 problems a day), and you can adjust pacing if needed. Now, let’s dive into the weekly breakdown of topics and problems!

Week 1 (Days 1–7): Arrays 📋 (Fundamentals – Easy Level)

Theory (Arrays): Arrays are one of the most widely used data structures and a fundamental building block in programming ￼. An array stores elements in contiguous memory locations, allowing constant-time access by index. Key operations include traversal, updating values, and searching. In Java, arrays have fixed size, but you can use ArrayList for dynamic resizing. Important concepts involve iterating through arrays, using two-pointer techniques for sorted arrays, and basic in-place algorithms. This week’s problems focus on array manipulation, scanning for specific values or patterns, and simple algorithms (like sorting small arrays or summing subsets). These exercises solidify your understanding of indexing and looping – critical skills before moving to more complex structures.
	•	Day 1: Two Sum (LeetCode), Best Time to Buy and Sell Stock (LeetCode 121), Contains Duplicate (LeetCode 217)
	•	Day 2: Maximum Subarray (LeetCode 53), Rotate Array (LeetCode 189), Single Number (LeetCode 136)
	•	Day 3: Intersection of Two Arrays (LeetCode 349), Move Zeroes (LeetCode 283), Plus One (LeetCode 66)
	•	Day 4: Remove Duplicates from Sorted Array (LeetCode 26), Remove Element (LeetCode 27), Missing Number (LeetCode 268)
	•	Day 5: Majority Element (LeetCode 169), Merge Sorted Array (LeetCode 88), Find All Numbers Disappeared in an Array (LeetCode 448)
	•	Day 6: Max Consecutive Ones (LeetCode 485), Squares of a Sorted Array (LeetCode 977), Valid Mountain Array (LeetCode 941)
	•	Day 7: Third Maximum Number (LeetCode 414), Check If N and Its Double Exist (LeetCode 1346), Gravity Flip (CodeForces 405A)

Week 2 (Days 8–14): Strings 📝 (Fundamentals – Easy Level)

Theory (Strings): Strings are sequences of characters and are key to handling text data. Common string problems involve searching, parsing, comparing, and modifying strings. In Java, String is immutable (each modification creates a new string), but you can use StringBuilder for efficient edits. Important topics include palindrome checks, anagram detection, and simple parsing. This week covers basic string algorithms: reversing strings, comparing lexicographic order, and character frequency counts. You’ll practice using hash maps or arrays for frequency (e.g. counting letters for an anagram), two-pointer techniques for palindrome checking, and basic conversions (like integer <-> roman numeral). Mastering strings will prepare you for more complex algorithms, as string manipulation often appears in both interviews and contest problems.
	•	Day 8: Valid Anagram (LeetCode 242), First Unique Character in a String (LeetCode 387), Ransom Note (LeetCode 383)
	•	Day 9: Valid Palindrome (LeetCode 125), Palindrome Number (LeetCode 9), Roman to Integer (LeetCode 13)
	•	Day 10: Longest Common Prefix (LeetCode 14), Implement strStr() – Substring Search (LeetCode 28), Add Binary (LeetCode 67)
	•	Day 11: Reverse String (LeetCode 344), Reverse Words in a String III (LeetCode 557), Is Subsequence (LeetCode 392)
	•	Day 12: Excel Sheet Column Number (LeetCode 171), Excel Sheet Column Title (LeetCode 168), Detect Capital (LeetCode 520)
	•	Day 13: Count and Say (LeetCode 38), Valid Palindrome II (LeetCode 680), Check If Two String Arrays are Equivalent (LeetCode 1662)
	•	Day 14: Reverse Only Letters (LeetCode 917), Jewels and Stones (LeetCode 771), Boy or Girl (CodeForces 236A)

Week 3 (Days 15–21): Linked Lists 🔗 (Fundamentals – Easy Level)

Theory (Linked Lists): A linked list is a linear data structure where elements (nodes) are linked using pointers. Each node contains data and a reference to the next (and in doubly-linked lists, also to the previous) node. Unlike arrays, linked lists allow efficient insertion/deletion (O(1) at head or tail if you have the pointer) without shifting elements, but random access is not constant time (you must traverse). In Java, you might implement your own Node class or use built-in structures (e.g. LinkedList from java.util, though that is a doubly-linked list). Key operations: reversing a list, detecting cycles (Floyd’s cycle algorithm), finding middle or nth-from-end nodes, and merging sorted lists. This week’s tasks cover these basics and a few intermediate challenges (toward the end of the week) like recursion on lists and more complex reordering. Mastering linked lists will also help with understanding pointers and memory references in general.
	•	Day 15: Merge Two Sorted Lists (LeetCode 21), Reverse Linked List (LeetCode 206), Middle of the Linked List (LeetCode 876)
	•	Day 16: Linked List Cycle (LeetCode 141), Remove Duplicates from Sorted List (LeetCode 83), Remove Linked List Elements (LeetCode 203)
	•	Day 17: Palindrome Linked List (LeetCode 234), Intersection of Two Linked Lists (LeetCode 160), Delete Node in a Linked List (LeetCode 237)
	•	Day 18: Remove Nth Node from End of List (LeetCode 19), Linked List Cycle II (LeetCode 142), Odd Even Linked List (LeetCode 328)
	•	Day 19: Add Two Numbers (LeetCode 2), Reorder List (LeetCode 143), Swap Nodes in Pairs (LeetCode 24)
	•	Day 20: Copy List with Random Pointer (LeetCode 138), Flatten a Multilevel Doubly Linked List (LeetCode 430), Rotate List (LeetCode 61)
	•	Day 21: Remove Duplicates from Sorted List II (LeetCode 82), Partition List (LeetCode 86), Split Linked List in Parts (LeetCode 725)

Week 4 (Days 22–28): Hash Tables & Sets 🗃️ (Fundamentals – Easy Level)

Theory (Hash Tables/Sets): A hash table (or hash map) stores key-value pairs for efficient lookup (average O(1) time). A hash set is a related structure that stores unique keys (like a mathematical set). In Java, use HashMap<K,V> and HashSet classes. Hash tables are extremely versatile – they allow quick checks for existence of an element, counting frequencies, caching computed results, etc. Common patterns include using a map to count occurrences (for frequency analysis), to map one value to another (e.g. mapping characters for an anagram or pattern), or to detect duplicates efficiently. This week’s problems include classic hashing tasks: detecting sums with complements, finding frequency of elements, identifying common elements between collections, and simple design of hash data structures. By solving these, you learn to trade space for time and use hashing to simplify problems. (Note: Hashing is a common tool in algorithm optimization and appears in many interview problems ￼.)
	•	Day 22: Happy Number (LeetCode 202), Isomorphic Strings (LeetCode 205), Word Pattern (LeetCode 290)
	•	Day 23: Contains Duplicate II (LeetCode 219), Minimum Index Sum of Two Lists (LeetCode 599), Two Sum II – Input Array is Sorted (LeetCode 167)
	•	Day 24: Group Anagrams (LeetCode 49), Valid Sudoku (LeetCode 36), Intersection of Two Arrays II (LeetCode 350)
	•	Day 25: 4Sum II (LeetCode 454), Subarray Sum Equals K (LeetCode 560), Top K Frequent Elements (LeetCode 347)
	•	Day 26: Single Number II (LeetCode 137), Single Number III (LeetCode 260), Longest Consecutive Sequence (LeetCode 128)
	•	Day 27: Design HashSet (LeetCode 705), Design HashMap (LeetCode 706), Logger Rate Limiter (LeetCode 359)
	•	Day 28: Majority Element II (LeetCode 229), Verifying an Alien Dictionary (LeetCode 953), Uncommon Words from Two Sentences (LeetCode 884)

(By the end of Month 1, you have covered all fundamental data structures – arrays, strings, linked lists, hash maps/sets – with primarily easy-level problems. We now ramp up to intermediate-level problems in similar topics and new ones. Don’t worry if some problems in week 3–4 felt harder; month 2 will reinforce and expand on those concepts.)

Week 5 (Days 29–35): Stacks & Queues 📚 (Intermediate – Medium Level)

Theory (Stacks & Queues): A stack is a Last-In-First-Out (LIFO) structure, supporting push and pop operations. In Java, you can use Stack (or better, use Deque to implement stack functionality) for this. Common uses of stacks include parsing bracket expressions, backtracking, and any scenario where you need to reverse or postpone processing (function call stacks, DFS, etc.). A queue is First-In-First-Out (FIFO); Java offers Queue (via LinkedList or ArrayDeque) for implementation. Queues are used in breadth-first search (BFS) algorithms, scheduling tasks, and buffering data streams. This week’s challenges involve both explicit stack/queue problems (like evaluating expressions, using a stack for min or for reversing data) and implicit uses (like BFS on grids, or sliding window problems using deque). By solving them, you’ll learn when to apply a stack vs. a queue and how to implement these in Java. These are medium-level problems, so expect a step up in logic and complexity (multi-step reasoning, combining data structures, etc.).
	•	Day 29: Valid Parentheses (LeetCode 20), Min Stack (LeetCode 155), Implement Queue using Stacks (LeetCode 232)
	•	Day 30: Implement Stack using Queues (LeetCode 225), Next Greater Element I (LeetCode 496), Number of Recent Calls (LeetCode 933)
	•	Day 31: Daily Temperatures (LeetCode 739), Evaluate Reverse Polish Notation (LeetCode 150), Decode String (LeetCode 394)
	•	Day 32: Asteroid Collision (LeetCode 735), Simplify Path (LeetCode 71), Next Greater Element II (LeetCode 503)
	•	Day 33: Generate Parentheses (LeetCode 22), Rotting Oranges – Grid BFS (LeetCode 994), Open the Lock (LeetCode 752)
	•	Day 34: Sliding Window Maximum (LeetCode 239), Largest Rectangle in Histogram (LeetCode 84), Design Circular Queue (LeetCode 622)
	•	Day 35: Basic Calculator II (LeetCode 227), Flatten Nested List Iterator (LeetCode 341), Design Browser History (LeetCode 1472)

Week 6 (Days 36–42): Searching & Sorting 🔎 (Intermediate – Medium Level)

Theory (Searching & Sorting): Efficient searching and sorting algorithms are fundamental in computer science. This week covers binary search and various sorting-related problems. Binary search is an O(log n) algorithm to find elements in a sorted array by repeatedly dividing the search interval in half. It’s implemented in Java with loops or recursion, and understanding it is crucial for many problems. Sorting algorithms (like Quick Sort, Merge Sort, etc.) are usually built-in (Arrays.sort() in Java typically uses Dual-Pivot Quicksort for primitives). Many problems reduce to sorting data and then processing it, or using binary search on sorted input or on the answer space. This week’s tasks include binary search on arrays and on search-space (like finding a minimum capacity or root), as well as interval problems and classic sorting puzzles. You’ll also solve problems with rotated arrays and the two-pointer pattern for sum problems. By the end of the week, you should solidify knowledge of comparison-based sorting, binary search boundaries, and common algorithmic tricks like two-pointer sweeps on sorted data.
	•	Day 36: Binary Search (LeetCode 704), First Bad Version (LeetCode 278), Search Insert Position (LeetCode 35)
	•	Day 37: Find Peak Element (LeetCode 162), Find First and Last Position of Element in Sorted Array (LeetCode 34), Search in Rotated Sorted Array (LeetCode 33)
	•	Day 38: Find Minimum in Rotated Sorted Array (LeetCode 153), Kth Largest Element in an Array (LeetCode 215), 3Sum (LeetCode 15)
	•	Day 39: 4Sum (LeetCode 18), Sort Colors (LeetCode 75), K Closest Points to Origin (LeetCode 973)
	•	Day 40: Merge Intervals (LeetCode 56), Insert Interval (LeetCode 57), Non-overlapping Intervals (LeetCode 435)
	•	Day 41: Meeting Rooms (LeetCode 252) (Note: from LeetCode Interview archive), Meeting Rooms II (LeetCode 253), Largest Number (LeetCode 179)
	•	Day 42: Median of Two Sorted Arrays (LeetCode 4), Capacity To Ship Packages Within D Days (LeetCode 1011), Search a 2D Matrix (LeetCode 74)

Week 7 (Days 43–49): Recursion & Backtracking 🔄 (Intermediate – Medium Level)

Theory (Recursion & Backtracking): Recursion is a technique where a function calls itself to solve smaller subproblems. Backtracking is a form of recursion for exploring decision trees (e.g. generating all combinations/permutations, solving puzzles) by trying a move, and undoing it (“backtracking”) if it doesn’t lead to a solution. In Java, be mindful of recursion depth (stack overflow) and use recursion for clarity when it fits (the JVM handles the recursion call stack). This week, you’ll solve problems that naturally use recursion/backtracking: generating subsets, permutations, solving the N-Queens puzzle, etc. Early in the week includes simple recursion (like computing Fibonacci or powers) and DFS (flood fill) to warm up, then moves to combinatorial generation problems (which may be medium difficulty), and finally some challenging backtracking puzzles (like Sudoku solver, expression add operators, etc.). These problems train you to think in terms of state-space search and are frequently seen in interviews (generate combinations) as well as contests (searching all possibilities with pruning).
	•	Day 43: Fibonacci Number (LeetCode 509), Climbing Stairs (LeetCode 70) (can be done via recursion or DP), Pow(x, n) – Implement Exponent (LeetCode 50) ￼
	•	Day 44: Letter Case Permutation (LeetCode 784), Subsets (LeetCode 78), Subsets II (LeetCode 90)
	•	Day 45: Permutations (LeetCode 46), Permutations II (LeetCode 47) (permute with duplicates), Combinations (LeetCode 77)
	•	Day 46: Combination Sum (LeetCode 39), Combination Sum II (LeetCode 40), Letter Combinations of a Phone Number (LeetCode 17)
	•	Day 47: Word Search (LeetCode 79), Palindrome Partitioning (LeetCode 131), Restore IP Addresses (LeetCode 93)
	•	Day 48: N-Queens (LeetCode 51), Sudoku Solver (LeetCode 37), N-Queens II – Count Solutions (LeetCode 52)
	•	Day 49: Gray Code (LeetCode 89), Expression Add Operators (LeetCode 282), Remove Invalid Parentheses (LeetCode 301)

Week 8 (Days 50–56): Dynamic Programming 🤖 (Intermediate – Medium/Hard Level)

Theory (Dynamic Programming): Dynamic Programming (DP) is an optimization technique for solving recursive problems more efficiently by storing intermediate results (using memoization or tabulation). If a problem can be broken into overlapping subproblems that follow optimal substructure (the optimal solution can be constructed from optimal solutions of subproblems), DP is often applicable. In Java, you might implement DP with arrays or maps for memoization. This week’s problems cover classic DP categories: 1D DP (linear sequences like coin change, Fibonacci variants), 2D DP (grid problems, edit distance), subset/knapsack DP (choosing elements under constraints), and sequence DP (subsequence problems). Early days include simpler DP (house robber, coin change) and progress to harder ones (edit distance, scramble string). Pay attention to identifying state and transitions in each problem. These problems will strengthen your ability to optimize naive recursion and are very common in interviews for their complexity and elegance.
	•	Day 50: House Robber (LeetCode 198), House Robber II (LeetCode 213), Coin Change (LeetCode 322)
	•	Day 51: Coin Change 2 (LeetCode 518), Partition Equal Subset Sum (LeetCode 416), Min Cost Climbing Stairs (LeetCode 746)
	•	Day 52: Unique Paths (LeetCode 62), Unique Paths II (LeetCode 63), Jump Game (LeetCode 55)
	•	Day 53: Jump Game II (LeetCode 45), Decode Ways (LeetCode 91), Word Break (LeetCode 139)
	•	Day 54: Longest Increasing Subsequence (LeetCode 300), Longest Common Subsequence (LeetCode 1143), Edit Distance (LeetCode 72)
	•	Day 55: Palindromic Substrings (LeetCode 647), Longest Palindromic Subsequence (LeetCode 516), Distinct Subsequences (LeetCode 115)
	•	Day 56: Interleaving String (LeetCode 97), Burst Balloons (LeetCode 312), Scramble String (LeetCode 87)

(By the end of Month 2, you’ve tackled intermediate topics and some advanced patterns (like DP). The final month will focus on advanced data structures (trees, graphs, tries, heaps) and math-intensive problems (number theory, combinatorics). These weeks will be challenging (mostly hard-level problems), but you’re now prepared with a strong foundation. Remember to revisit earlier problems or theory if you get stuck – the concepts often build on each other.)

Week 9 (Days 57–63): Trees 🌳 (Advanced – Mixed Difficulty)

Theory (Trees): Trees are hierarchical data structures with parent-child relationships. A binary tree is a tree where each node has at most two children (left and right). Important special cases include binary search trees (BSTs), where in-order traversal yields sorted order, and heaps (a kind of tree used for priority queues, covered later). This week focuses on binary trees. Key operations and concepts: depth-first traversals (preorder, inorder, postorder), breadth-first traversal (level order), computing tree height (depth), checking balance (height difference), symmetry, and common ancestor queries. In Java, you might use TreeNode class (with fields for value, left, right). Many problems involve recursion on trees (due to their recursive structure). We start with easy tasks like traversal and insertions, then move to more complex ones like constructing trees from traversals and binary tree algorithms (like finding paths and serialization). By working through these, you’ll gain comfort with recursive algorithms and pointer manipulation, which are crucial for tree manipulations.
	•	Day 57: Binary Tree Inorder Traversal (LeetCode 94), Binary Tree Preorder Traversal (LeetCode 144), Binary Tree Postorder Traversal (LeetCode 145)
	•	Day 58: Maximum Depth of Binary Tree (LeetCode 104), Symmetric Tree (LeetCode 101), Invert Binary Tree (LeetCode 226)
	•	Day 59: Same Tree (LeetCode 100), Subtree of Another Tree (LeetCode 572), Balanced Binary Tree (LeetCode 110)
	•	Day 60: Binary Tree Level Order Traversal (LeetCode 102), Binary Tree Zigzag Level Order Traversal (LeetCode 103), Binary Tree Right Side View (LeetCode 199)
	•	Day 61: Path Sum (LeetCode 112), Path Sum II (LeetCode 113), Lowest Common Ancestor of a BST (LeetCode 235)
	•	Day 62: Validate Binary Search Tree (LeetCode 98), Lowest Common Ancestor of a Binary Tree (LeetCode 236), Kth Smallest Element in a BST (LeetCode 230)
	•	Day 63: Construct Binary Tree from Preorder and Inorder (LeetCode 105), Serialize and Deserialize Binary Tree (LeetCode 297), Binary Search Tree Iterator (LeetCode 173)

Week 10 (Days 64–70): Graphs 🌐 (Advanced – Medium/Hard Level)

Theory (Graphs): Graphs are a generalization of trees – nodes (vertices) connected by edges (which can be directed or undirected). Many real-world problems are graphs (networks, relationships). Core graph algorithms include Depth-First Search (DFS) and Breadth-First Search (BFS) for traversal, as well as specialized algorithms like Dijkstra’s (shortest path), union-find (disjoint set for connectivity), and topological sort (for DAGs). In Java, graphs can be represented via adjacency lists (e.g. List<List<Integer>> or a Map of node->neighbors). This week’s problems cover typical graph tasks: counting connected components (islands, provinces), graph traversal (clone graph, BFS puzzles), topological sorting (course schedule), shortest path in unweighted graphs (word ladder, open lock), and even some algorithmic puzzles like finding critical connections or Eulerian paths (reconstruct itinerary). Graph problems are often medium to hard. Tackle them by visualizing the graph, choosing the right approach (DFS, BFS, or union-find), and considering edge cases (cycles, disconnected components). These will also involve combinatorial thinking and sometimes advanced math (but primarily graph theory).
	•	Day 64: Number of Islands (LeetCode 200), Max Area of Island (LeetCode 695), Surrounded Regions (LeetCode 130)
	•	Day 65: Clone Graph (LeetCode 133), Course Schedule (LeetCode 207), Course Schedule II (LeetCode 210)
	•	Day 66: Pacific Atlantic Water Flow (LeetCode 417), 01 Matrix (LeetCode 542), Is Graph Bipartite? (LeetCode 785)
	•	Day 67: Word Ladder (LeetCode 127), Word Ladder II (LeetCode 126), Shortest Path in Binary Matrix (LeetCode 1091)
	•	Day 68: Network Delay Time (LeetCode 743), Minimum Knight Moves (LeetCode 1197), All Paths From Source to Target (LeetCode 797)
	•	Day 69: Redundant Connection (LeetCode 684), Number of Provinces (LeetCode 547), Critical Connections in a Network (LeetCode 1192)
	•	Day 70: Reconstruct Itinerary (LeetCode 332), Graph Valid Tree (LeetCode 261) (LeetCode Interview archive), Alien Dictionary (LeetCode 269) (hard – derive ordering of letters via topological sort)

Week 11 (Days 71–77): Mathematics & Bit Manipulation 🔢 (Advanced – Mixed Difficulty)

Theory (Math & Bit Manipulation): Many programming challenges involve mathematical reasoning or bitwise operations. Number theory topics include prime numbers, greatest common divisor (GCD), modular arithmetic, etc., which are frequently asked in competitive programming ￼. Combinatorics (counting) is covered next week, so this week leans more on pure math and bits. Bit manipulation leverages binary representations of numbers; in Java, you have bitwise operators (&, |, ^, ~, <<, >>). Common tasks: counting set bits, checking power of 2, flipping bits, etc. We also include some classical math problems like checking primes, computing GCD/LCM, and simple simulation of math operations (like division without using divide). This week’s problems range from easy one-liners (e.g., parity checks) to tricky bit problems (like range bitwise AND) and math puzzles (like happy number or prime counting). They develop your low-level understanding of data and are often the key to optimizing algorithms (bit tricks can replace loops). Competitive programmers place heavy emphasis on number theory and bit tricks ￼ ￼, so mastering these will give you an edge.
	•	Day 71: Count Primes (LeetCode 204), Greatest Common Divisor of Strings (LeetCode 1071), Power of Two (LeetCode 231)
	•	Day 72: Power of Three (LeetCode 326), Power of Four (LeetCode 342), Sqrt(x) – Integer Square Root (LeetCode 69)
	•	Day 73: Factorial Trailing Zeroes (LeetCode 172), Ugly Number (LeetCode 263), Arranging Coins (LeetCode 441)
	•	Day 74: Number of 1 Bits (LeetCode 191) (Hamming Weight), Hamming Distance (LeetCode 461), Reverse Bits (LeetCode 190)
	•	Day 75: Sum of Two Integers (LeetCode 371) (bitwise addition), Bitwise AND of Numbers Range (LeetCode 201), Counting Bits (LeetCode 338)
	•	Day 76: Watermelon (CodeForces 4A), Elephant (CodeForces 617A), Bear and Big Brother (CodeForces 791A)
	•	Day 77: Wrong Subtraction (CodeForces 977A), Nearly Lucky Number (CodeForces 110A), Hit the Lottery (CodeForces 996A)

Week 12 (Days 78–84): Combinatorics 🎲 (Advanced – Mixed Difficulty)

Theory (Combinatorics & Counting): Combinatorics deals with counting combinations, permutations, and arrangements of sets – a core part of discrete mathematics and competitive programming ￼. Many problems reduce to computing the number of ways to do something (with or without dynamic programming). This week’s focus is on counting and generating combinations/permutations and other combinatorial constructs. You’ll practice with Pascal’s Triangle (which relates to binomial coefficients), permutation generation and ordering (next permutation, kth permutation), and some creative counting problems (like counting unique digit numbers, or vowel permutations with rules). We also include a few CodeForces problems that involve simple combinatorial reasoning (like counting team solutions or using division results). These tasks reinforce understanding of mathematical patterns and often require recognizing formulae (nCr, Catalan numbers, etc.) or using backtracking with pruning to count possibilities. By the end, you should be comfortable with both constructing combinations (backtracking approach) and computing counts via formulas or DP.
	•	Day 78: Pascal’s Triangle (LeetCode 118), Pascal’s Triangle II (LeetCode 119), Unique Binary Search Trees (LeetCode 96) (Catalan number application)
	•	Day 79: Next Permutation (LeetCode 31), Permutation Sequence (LeetCode 60), Count Numbers with Unique Digits (LeetCode 357)
	•	Day 80: Bulb Switcher (LeetCode 319), Letter Tile Possibilities (LeetCode 1079), Beautiful Arrangement (LeetCode 526)
	•	Day 81: Count Vowels Permutation (LeetCode 1220), Number of Dice Rolls with Target Sum (LeetCode 1155), Combination Sum IV (LeetCode 377)
	•	Day 82: Team (CodeForces 231A), Soft Drinking (CodeForces 151A), George and Accommodation (CodeForces 467A)
	•	Day 83: Domino Piling (CodeForces 50A), Beautiful Matrix (CodeForces 263A), Petya and Strings (CodeForces 112A)
	•	Day 84: Soldier and Bananas (CodeForces 546A), Anton and Danik (CodeForces 734A), Ultra-Fast Mathematician (CodeForces 61A)

Week 13 (Days 85–90): Advanced Topics (Heaps, Tries, & More) 🧩

Theory (Heaps, Tries & Advanced Data Structures): In this final week, we tackle a few remaining advanced structures and problem types:
	•	Heaps/Priority Queues: A heap is a complete binary tree satisfying the heap property (max-heap or min-heap). In Java, use PriorityQueue. Heaps allow efficient retrieval of the largest or smallest element. Many problems (like “top K” or “merge sorted lists”) utilize heaps for optimal performance.
	•	Tries (Prefix Trees): A trie is a tree-based structure for storing strings by their prefixes. Each node represents a prefix of some words. Tries are useful for fast prefix queries (autocomplete, spell-check, word games). We’ll implement tries and apply them to problems like word search optimization and prefix/suffix lookups.
	•	Advanced design problems: We include LRU/LFU Cache designs – these require using multiple structures (lists + hash maps) to achieve the desired performance. These are often considered hard due to careful detail management.
	•	Miscellaneous algorithms: e.g., a hard problem like “Trapping Rain Water” (two-pointer or stack solution) as a final challenge.

This week’s tasks are among the toughest (mostly hard level). They will test your understanding of all earlier concepts combined with new ones. Don’t be discouraged by difficulty – even if you can outline a solution or solve part of the problem, that’s progress. Use this week to identify any weak spots to review. Solving these will give you confidence in tackling virtually any coding problem.
	•	Day 85: Kth Largest Element in a Stream (LeetCode 703), Last Stone Weight (LeetCode 1046), Kth Smallest Element in a Sorted Matrix (LeetCode 378)
	•	Day 86: Find Median from Data Stream (LeetCode 295), Sliding Window Median (LeetCode 480), Merge K Sorted Lists (LeetCode 23)
	•	Day 87: Trapping Rain Water (LeetCode 42), Task Scheduler (LeetCode 621), LRU Cache (LeetCode 146)
	•	Day 88: Implement Trie (Prefix Tree) (LeetCode 208), Add and Search Word – Data structure design (LeetCode 211), Word Search II (LeetCode 212)
	•	Day 89: Replace Words (LeetCode 648), Maximum XOR of Two Numbers in an Array (LeetCode 421), LFU Cache (LeetCode 460)
	•	Day 90: Prefix and Suffix Search (LeetCode 745), Design Search Autocomplete System (LeetCode 642), Palindrome Pairs (LeetCode 336)

⸻

Conclusion & Next Steps: Congratulations on making it through 90 days of intensive practice! 🎉 You’ve solved around 270 problems across all major topics in computer science: data structures (arrays, linked lists, stacks, queues, trees, graphs, tries), algorithms (sorting, searching, DP, backtracking, etc.), and mathematics (number theory, combinatorics, bit manipulation). This roadmap was designed to build your skills from the ground up – from basic problem-solving to tackling some of the toughest coding challenges. Along the way, you’ve learned to analyze problems, recognize patterns, and apply appropriate techniques (often combining multiple concepts).

Going forward, you can reinforce knowledge by revisiting problems you found difficult, or by exploring variations of these problems. It’s also beneficial to participate in contests (LeetCode weekly contests or Codeforces rounds) to apply what you’ve learned under time pressure. Continue to write clean, well-documented code and perhaps contribute your solutions and insights (e.g., as blog posts or in discussion forums) – this helps solidify your understanding and gives back to the community.

Remember that consistency and curiosity are key in programming. By following this guide, you’ve built a strong foundation. Keep practicing and exploring new challenges beyond this 90-day plan to become even more proficient. Good luck, and happy coding! 🤗

Sources & References: This plan was informed by popular coding interview problem sets (like LeetCode Top Interview questions and NeetCode 150) and competitive programming problem archives. For theoretical groundwork, references like GeeksforGeeks and others were used to ensure coverage of important topics (e.g., the significance of arrays ￼, and the common categories in contests ￼). The structured approach of easy->medium->hard over 3 months is a proven strategy in many DSA roadmaps ￼ ￼. Additionally, number theory and combinatorics were emphasized because they are frequently asked in contests ￼. All problem statements belong to their respective platforms (LeetCode, CodeForces, etc.), and you can find detailed editorial solutions on those sites or community forums if you need hints. Stay persistent – with the completion of this roadmap, you are well on your way to algorithmic mastery! ￼ ￼
