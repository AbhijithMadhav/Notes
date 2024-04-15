Master Method for solving recurrences

The Master Theorem(Figure 2)

- The master method is a black box for solving recurrences.

- The assumption is that all subproblems have equal size. Thus it
  applies to recurrences of the form

  - $$T{{(n)} \leq a}T{\left( \frac{n}{b} \right) + O}{(n^{d})}$$
    ------------- (\*)

    - *a* = Number of immediate recursive calls ( \>= 1)

      *b* = Factor by which the input shrinks before each recursive
      call(\>1)

      *d* = exponent in the running time of the combine step

- The Master theorem gives the running time of the above types of
  recurrences as

  -  $$T{{(n)} = \left\{ \begin{matrix}
    {O{({n^{d}\log n})}} & {\mathit{if}{a = b^{d}}} \\
    {O{(n^{d})}} & {\mathit{if}{a < b^{d}}} \\
    {O{(n^{\log_{b}a})}} & {\mathit{if}{a > b^{d}}}
    \end{matrix} \right.}$$

    Note that the base of the logarithm is not specified as the big-O
    notation subsumes the constant base.

Interpretation

- Consider the recursion tree representing the running time of a typical
  divide and conquer algorithm.

- Number of subproblems at level *j* = <sup>$$a^{j}$$</sup>

- Size of each subproblem at level *j* =
  $$\left( \frac{n}{b^{j}} \right)$$

- From (\*) above we know that

  - T(n) = (Number of recursive calls \* Amount of work done by each
    recursive call) + Amount of work done to combine the solutions of
    each sub-problems

    - - = a \* T(n/b) + O(n<sup>d</sup>)

    Thus, amount of work done to combine the solutions of the 'a'
    sub-problems

    - \<= k \* n<sup>d </sup>= k \* (input size)<sup>d</sup>

    Thus amount of work done to combine the solutions of 'a' subproblems
    at level j

    - \<= k \* (n / b<sup>j</sup>)<sup>d</sup>

    Thus amount of work done to combine the solutions of 'a<sup>j</sup>'
    subproblems at level j

    - \<= a<sup>j </sup>\* k \* (n / b<sup>j</sup>)<sup>d </sup>= c
      n<sup>d </sup>(a / b<sup>d</sup>)<sup>j</sup>

    Total work done at all levels = T(n) = c n<sup>d
    $$\sum\limits_{j = 0}^{\log_{b}n}{(\frac{a}{b^{d}})}^{j}$$</sup>

- Here 'a' can be seen as the rate at which the subproblem proliferates
  and

- b<sup>d</sup> can be seen as the rate at which the the work shrinks
  per subproblem.

  - How?

    - Assume

      - Problem size = n,

        t(combine) = n<sup>2</sup>

        Input size is halved. i.e. b = 2 and subproblem size = n/2.

      Now t(combine of subproblem) = (n/2)<sup>2</sup> = n<sup>2</sup>/4

      Shrinkage factor of 'combine'= n<sup>2</sup>/(n<sup>2</sup>/4) = 4
      = 2<sup>2</sup> = b<sup>d</sup>

- The amount of work done to combine the solutions of all subproblems at
  level j can be seen as being determined by the ratio a /
  b<sup>d</sup>. i.e. by the domination of either the

  - The rate of subproblem proliferation
  - The rate of work shrinkage per subproblem

- Thus the recursion tree can be seen as being of 3 types

  - One in which the the rate of subproblem proliferation is **equal**
    to the rate at which work shrinks per subproblem

    - a = b<sup>d</sup>

    - In this case the same amount of work is done at each level.

    - The running time = Amount of work done at a level \* Number of
      levels

      i.e., T(n) = cn<sup>d</sup> \* log<sub>b</sub> n = O(n<sup>d</sup>
      log n)

    - More rigorously speaking,

      $$T{{(n)} = c}n^{d}{{\sum\limits_{j = 0}^{\log_{b}n}\left( \frac{a}{b^{d}} \right)^{j}} = c}n^{d}{{\sum\limits_{j = 0}^{\log_{b}n}1} = c}n^{d}{\left( {\log_{b}{n + 1}} \right) = O}\left( {n^{d}\log n} \right)$$

  - One in which the rate of subproblem proliferation is **lesser** than
    the rate at which work shrinks per subproblem.

    - a \< b<sup>d</sup>

    - In this case the work done goes down over the levels. Seen
      intuitively, it is possible that the work done at the root
      dominates the work done in all other nodes.

      i.e., T(n) = O(n<sup>d</sup>)

    - More rigorously speaking, let (a / b<sup>d</sup>)<sup>j </sup>= r,
      r \< 1 as a \< b<sup>d</sup>

      - T(n) = c n<sup>d
        $$\sum\limits_{j = 0}^{\log_{b}n}{(\frac{a}{b^{d}})}^{j}$$</sup>=
        c n<sup>d</sup> $$\sum\limits_{j = 0}^{\log_{b}n}r^{j}$$= c
        n<sup>d</sup> $$\frac{1}{({1 - r})}$$= O(n<sup>d</sup>)

  - One in which the rate of subproblem proliferation is **greater**
    than the rate at which work shrinks per subproblem.

    - a \> b<sup>d</sup>.

    -  In this case the work done increases with the number of levels.
      Seen intuitively, it is possible that the work done at leaves of
      the tree dominates the work done.

      i.e., T(n) = O(number of leaves \* work done at each leaf) =
      $$a^{\log_{b}n}$$\* O(1)

      - - - = $$a^{\log_{b}n}$$= $$O{(n^{\log_{b}a})}$$

    - More rigorously speaking, let (a / b<sup>d</sup>)<sup>j </sup>= r,
      r \> 1 as a \> b<sup>d</sup>

      - T(n)
        =<sup>$$cn^{d}{\sum\limits_{j = 0}^{\log_{b}n}{(\frac{a}{b^{d}})}^{j}}$$</sup>=
        $$cn^{d}{\sum\limits_{j = 0}^{\log_{b}n}r^{j}}$$=
        $$cn^{d}\frac{r^{({\log_{b}{n + 1}})} - 1}{r - 1}$$<sup> </sup>

        Thus , T(n) \<=<sup>
        $$cn^{d}\frac{r^{({\log_{b}{n + 1}})}}{r - 1}$$</sup>=
        $$cn^{d}r^{({\log_{b}n})}\frac{r}{r - 1}$$=$$O{({n^{d}r^{({\log_{b}n})}})}$$

        - - - - = $$O{({n^{d}{(\frac{a}{b^{d}})}^{({\log_{b}n})}})}$$=
                $$O{(a^{\log_{b}n})}$$= $$O{(n^{({\log_{b}a})})}$$

Running time of various divide and conquer algorithms derived using the
master theorem

<table>
<tbody>
<tr class="odd">
<td>Divide and Conquer Algorithm</td>
<td>Recurrence relation</td>
<td><p>Rate of subproblem proliferation </p>
<p>vs </p>
<p>Rate of work shrinkage at each subproblem</p></td>
<td>Running time</td>
</tr>
<tr class="even">
<td><p>Merge sort</p>
<p>and</p>
<p>Quick sort</p></td>
<td><p><span class="math display">$$T{{(n)} \leqslant
2T}{{(\frac{n}{2})} + O}{(n)}$$</span></p>
<p>a = 2, b = 2, d = 1</p></td>
<td>a = b<sup>d</sup></td>
<td>T(n) = O(n log n)</td>
</tr>
<tr class="odd">
<td>Maximum sub-array</td>
<td><p><span class="math display">$$T{{(n)} \leqslant T}{{(\frac{n}{2})}
+ O}{(n)}$$</span></p>
<p>a = 2, b = 2, d = 1</p></td>
<td>a = b<sup>d</sup></td>
<td>T(n) = O(n log n)</td>
</tr>
<tr class="even">
<td>Binary Search</td>
<td><p><span class="math display">$$T{{(n)} \leqslant T}{{(\frac{n}{2})}
+ O}{(1)}$$</span></p>
<p>a = 1, b = 2, d = 0</p></td>
<td>a = b<sup>d</sup></td>
<td>T(n) = O(log n)</td>
</tr>
<tr class="odd">
<td>Integer Multiplication</td>
<td><p><span class="math display">$$T{{(n)} \leqslant
4T}{{(\frac{n}{2})} + O}{(n)}$$</span></p>
<p>a = 4, b = 2, d = 1</p></td>
<td>a &gt; b<sup>d</sup></td>
<td>T(n) = <span
class="math display"><em>O</em>(<em>n</em><sup>log<sub>2</sub>4</sup>)</span>=
O(n<sup>2</sup>)</td>
</tr>
<tr class="even">
<td>Gaussian Integer Multiplication</td>
<td><p><span class="math display">$$T{{(n)} \leqslant
3T}{{(\frac{n}{2})} + O}{(n)}$$</span></p>
<p>a = 3, b = 2, d = 1</p></td>
<td>a &gt; b<sup>d</sup></td>
<td>T(n) = <span
class="math display"><em>O</em>(<em>n</em><sup>log<sub>2</sub>3</sup>)</span>=
O(n<sup>1.58</sup>)</td>
</tr>
<tr class="odd">
<td>Matrix Multiplication</td>
<td><p><span class="math display">$$T{{(n)} \leqslant
8T}{{(\frac{n}{2})} + O}{(n^{2})}$$</span></p>
<p>a = 8, b = 2, d = 2</p></td>
<td>a &gt; b<sup>d</sup></td>
<td>T(n) = <span
class="math display"><em>O</em>(<em>n</em><sup>log<sub>2</sub>8</sup>)</span>=
O(n<sup>3</sup>)</td>
</tr>
<tr class="even">
<td>Strassen's matrix multiplication</td>
<td><p><span class="math display">$$T{{(n)} \leqslant
7T}{{(\frac{n}{2})} + O}{(n^{2})}$$</span></p>
<p>a = 7, b = 2, d = 2</p></td>
<td>a &gt; b<sup>d</sup></td>
<td>T(n) = <span
class="math display"><em>O</em>(<em>n</em><sup>log<sub>2</sub>7</sup>)</span>=
O(n<sup>2.81</sup>)</td>
</tr>
<tr class="odd">
<td>Fictitious example</td>
<td><p><span class="math display">$$T{{(n)} \leqslant
2T}{{(\frac{n}{2})} + O}{(n^{2})}$$</span></p>
<p>a = 2, b = 2, d = 2</p></td>
<td>a &lt; b<sup>d</sup></td>
<td>T(n) = O(n<sup>2</sup>)</td>
</tr>
</tbody>
</table>
