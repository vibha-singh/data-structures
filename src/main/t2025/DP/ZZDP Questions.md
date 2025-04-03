Dynamic Programming (DP) is a powerful algorithmic technique used to solve problems by breaking them down into simpler subproblems and storing the results of these subproblems to avoid redundant computations. Below is a comprehensive list of common DP problems categorized by type:

1. Classic DP Problems
    **Fibonacci Sequence:** Compute the nth Fibonacci number.
    **Climbing Stairs:** Count the number of ways to climb n stairs if you can take 1 or 2 steps at a time.
    **0/1 Knapsack Problem:** Maximize the value of items in a knapsack without exceeding its capacity.
    **Unbounded Knapsack Problem:** Similar to 0/1 Knapsack, but items can be reused.
    **Coin Change (Minimum Coins):** Find the minimum number of coins needed to make a given amount.
    **Coin Change II (Number of Ways):** Count the number of ways to make a given amount using coins.
    **Longest Increasing Subsequence (LIS):** Find the length of the longest subsequence of a given sequence such that all elements are in increasing order.
    
    **Matrix Chain Multiplication:** Find the most efficient way to multiply a sequence of matrices.
    **Subset Sum Problem:** Determine if there is a subset of a given set with a sum equal to a target.
    **Partition Equal Subset Sum:** Check if an array can be partitioned into two subsets with equal sums.
    **Rod Cutting Problem:** Maximize the profit by cutting a rod into pieces and selling them.
    **Maximum Product Subarray:** Find the contiguous subarray within an array that has the largest product.
    **Maximum Subarray (Kadane's Algorithm):** Find the contiguous subarray with the largest sum.
   
    **Egg Dropping Problem:** Find the minimum number of attempts needed to determine the critical floor in an egg-dropping experiment.

2. DP on Strings
    **Longest Common Substring**: Find the longest substring common to two strings.
    **Distinct Subsequences:** Count the number of distinct subsequences of one string that match another string.
    **Regular Expression Matching**: Implement a regular expression matcher with support for '.' and '*'.
    **Wildcard Matching**: Implement a wildcard pattern matcher with support for '?' and '*'.
    **Interleaving String**: Determine if a string is formed by interleaving two other strings.
    **Scramble String**: Determine if one string is a scrambled form of another.
    **Word Break Problem**: Determine if a string can be segmented into words from a dictionary.
    **Palindrome Partitioning**: Find the minimum number of cuts needed to partition a string into palindromic substrings.
    **Longest Palindromic Subsequence**: Find the length of the longest subsequence of a string that is a palindrome.
    **Longest Palindromic Substring**: Find the longest substring of a string that is a palindrome.
    **Edit Distance (Levenshtein Distance)**: Find the minimum number of operations (insert, delete, replace) to convert one string to another.
    **Longest Common Subsequence (LCS)**: Find the longest subsequence common to two strings.

3. DP on Trees
    **Maximum Path Sum in a Binary Tree:** Find the maximum path sum in a binary tree.
    **House Robber III:** Maximize the amount of money that can be robbed from a binary tree without alerting adjacent nodes.
    **Diameter of a Binary Tree:** Find the length of the longest path between two nodes in a binary tree.

4. DP on Grids/Matrices
    Unique Paths
    Count the number of unique paths from the top-left to the bottom-right of a grid.
    Unique Paths II (with Obstacles)
    Count the number of unique paths in a grid with obstacles.
    Minimum Path Sum
    Find the path from the top-left to the bottom-right of a grid with the minimum sum.
    Dungeon Game
    Find the minimum initial health required to reach the bottom-right of a dungeon grid.
    Maximal Square
    Find the largest square containing only 1s in a binary matrix.
    Maximal Rectangle
    Find the largest rectangle containing only 1s in a binary matrix.
    Count Square Submatrices with All Ones
    Count the number of square submatrices with all ones.
    Cherry Pickup
    Maximize the number of cherries collected by two robots moving through a grid.

5. DP with State Transitions
    Buy and Sell Stock (Multiple Variations)
    Maximize profit from buying and selling stocks with constraints (e.g., at most k transactions, cooldown periods).
    Best Time to Buy and Sell Stock with Cooldown
    Maximize profit with a cooldown period after selling.
    Best Time to Buy and Sell Stock with Transaction Fee
    Maximize profit with a fee for each transaction.
    Paint House
    Minimize the cost of painting houses with adjacent houses not having the same color.
    Paint Fence
    Count the number of ways to paint a fence with k colors and no more than two adjacent posts having the same color.
    Decode Ways
    Count the number of ways to decode a string of digits into letters (A=1, B=2, ..., Z=26).
    Integer Break
    Maximize the product of integers when breaking a given integer into the sum of at least two positive integers.
    Perfect Squares
    Find the minimum number of perfect square numbers that sum to a given number.
    Minimum Cost For Tickets
    Find the minimum cost to travel every day in a given list of days using 1-day, 7-day, or 30-day tickets.

6. Advanced DP Problems
    Burst Balloons
    Maximize the coins collected by bursting balloons in a specific order.
    Super Egg Drop
    Find the minimum number of attempts needed to determine the critical floor in an egg-dropping experiment with k eggs and n floors.
    Count Numbers with Unique Digits
    Count the numbers with unique digits in a given range.
    Number of Dice Rolls with Target Sum
    Count the number of ways to roll dice to get a target sum.
    Minimum Cost to Merge Stones
    Find the minimum cost to merge stones into piles.
    Minimum Falling Path Sum
    Find the minimum sum of a falling path through a grid.
    Knight Probability in Chessboard
    Calculate the probability that a knight remains on the chessboard after k moves.
    Minimum Swaps to Make Sequences Increasing
    Find the minimum number of swaps to make two sequences strictly increasing.
    Tallest Billboard
    Find the maximum height of a billboard that can be built using a set of rods.
    This list covers a wide range of DP problems, from classic to advanced. Each problem can be solved using DP techniques such as memoization, tabulation, or state transitions.