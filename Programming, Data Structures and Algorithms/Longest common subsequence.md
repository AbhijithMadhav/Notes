# Longest common subsequence

[Top-down
implementation](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Design%20of%20Algorithms/Dynamic%20programming/TDLCS.java)

[Bottom-up
implementation](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Design%20of%20Algorithms/Dynamic%20programming/BULCS.java)

### Subsequence

A subsequence of a given sequence is just the given sequence with zero
or more elements left out.

### Common subsequence

A sequence Z is a common subsequence of X and Y if Z is the subsequence
of both X and Y.

### Longest common subsequence problem

Given two subsequences X and Y, find the length of the longest common
subsequence of X and Y.

### Brute force method

- Enumerate all the subsequences of X. X is of length m. Thus there are
  2<sup>m</sup> subsequences.
- Check each subsequence to see whether it is also a subsequence of Y,
  keeping track of the length of the longest subsequence we find.
- This approach required exponential time.

### Notation for prefix of a sequence

Given a sequence X = \< x<sub>1</sub>, x<sub>2</sub>, …,
x<sub>m</sub>\>, the i'th prefix of X is X<sub>i</sub> = \<
x<sub>1</sub>, x<sub>2</sub>, …, x<sub>i</sub>\>

### Problem characteristics

**Is this an optimization problem? - Yes**

There can be **possibly** 2<sup>min(m, n)</sup> common subsequences. We
seek the longest one.

**Does the optimization problem have optimal-substructure? - Yes**

Let X = \< x<sub>1</sub>, x<sub>2</sub>, …, x<sub>m</sub>\> and Y = \<
y<sub>1</sub>, y<sub>2</sub>, …, y<sub>n</sub>\> be the given sequences,
and let Z = \< z<sub>1</sub>, z<sub>2</sub>, …, z<sub>k</sub>\> be the
LCS of X and Y. The length of the LCS can be expressed in terms of the
solutions of its optimal subproblems as follows

- c\[i, j\] is the length of the LCS, Z, of X<sub>i</sub> and
  Y<sub>j</sub>

<!-- -->

- - - c\[i, j\] = 0, if i or j = 0

      c\[i, j\] = c\[i – 1\]\[j – 1\] + 1, if i, j \> 0 and
      x<sub>i</sub> = y<sub>j</sub>

      c\[i, j\] = max(c\[i – 1\]\[j\], c\[i\]\[j – 1\]), if i, j \> 0
      and x<sub>i</sub> != y<sub>j</sub>

As the problem has an optimal substructure there is no need to calculate
the cost of the possible 2<sup>min(m, n)</sup> common subsequences and
then find the one that is the longest. It is sufficient if we find the
length of a linear(in m or n) number of common subsequences and then
find the longest among them. Each of these common subsequences are the
optimally longest for the respective combination of positions in X and
Y.

**Are the subproblems involved in a candidate solution independent? - Yes**

Only in cases where x<sub>i</sub> != y<sub>j </sub>are there multiple
subproblems( A pair to be precise) involved in forming a candidate
solution

- Finding the length of the LCS of X<sub>i-1</sub> and Y<sub>j</sub>
- Finding the length of the LCS of X<sub>i</sub> and Y<sub>j-1 </sub>

Finding the LCS or its length of any pair of subsequences will not
affect the LCS of any other pair of subsequences.

### Characteristics of the subproblem space

- Are there overlapping subproblems? - Yes

  - Total number of subproblems – Exponential

    - The calculation of the exact number of subproblems is involved as
      the number of subproblems vary depending upon the nature of the
      two sequences(is x<sub>i</sub> == y<sub>i</sub>?)
    - But it can be made out from the recursive problem formulation that
      it is exponential irrespective of the nature of the two sequences.

  - Number of distinct subproblems – mn

    It is clear from the recursive formulation that the number of unique
    subproblems is the equal to the number of ways all the prefixes of X
    and Y can be taken together = mn.

- Is the entire subproblem space solved? - No

  - The formulation of the recursive solution necessitates only solving
    a subset of the subproblems based on the nature of the two
    sequences.
  - In this case a top-down approach with memoization is more efficient.

### Running time

- Naive divide and conquer solution

  - The running time is possibly exponential depending on the nature of
    the two sequences

- Top down method with memoization

  - Solves only the required subproblems lesser than or equal to mn with
    the required recursive calls. Each recursive call then does a
    constant number of comparisons and addition operations to calculate
    the length of its LCS giving a run time of O(mn).

- Bottom up method with memoization

  - The runing time is easy to see. There is a nested for loop which
    runs mn times to solve all the mn unique subproblems . Each
    subproblem then does a constant number of comparison and addition
    operations to calculate the length of its LCS giving a run time of
    $$\Theta{(\mathit{mn})}$$
