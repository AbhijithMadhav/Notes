Activity Selection / Interval scheduling–
[Implementation](https://github.com/AbhijithMadhav/Algorithm-Design/blob/master/Design of Algorithms/Greedy Strategy/algo/greedy/ActivitySelection.java)

See class notes

Problem

- Given a set of activities, A = {a<sub>f1</sub>, a<sub>f2</sub>, …,
  a<sub>fn </sub>\| a<sub>k</sub> is an activity with a finish time of
  k}, with the respective start and finish times, S = {s<sub>1</sub>,
  s<sub>2</sub>, …, s<sub>n</sub>} and F = {f<sub>1</sub>,
  f<sub>2</sub>, …, f<sub>n</sub>}, determine the maximum subset of
  non-overlapping activities, M<sub>ij</sub> = {a<sub>i</sub>,
  a<sub>i+1</sub>, …, a<sub>j</sub>}.
- For convenience assume that the activities are ordered by their finish
  times.

Problem characteristics

Optimal substructure

If a<sub>k</sub> is an activity in the maximal subset of non-overlapping
activities, M<sub>ij</sub>,

$$\begin{matrix}
{{M_{\mathit{ij}} = \varnothing}\mathit{if}{A = \varnothing}} \\
{{M_{\mathit{ij}} = \mathit{\max}}\{{{M_{\mathit{i...k} - 1} + a_{k}} + M_{{k + 1.}..j}}\}\mathit{for}\mathit{every}{a_{k} \in A}\text{or}\mathit{for}{{i \leq k} \leq j}}
\end{matrix}$$

In other words, if c\[i, j\] is the maximal number of activities,

$$\begin{matrix}
{c{{\lbrack{i,j}\rbrack} = 0,}\mathit{if}{A = \varnothing}} \\
{c{{\lbrack{i,j}\rbrack} = \mathit{\max}}\{ c{{{\lbrack{i,{k - 1}}\rbrack} + 1} + c}{\lbrack{{k + 1,}j}\rbrack}\}\mathit{for}\mathit{every}{a_{k} \in A}\text{or}\mathit{for}{{i \leq k} \leq j}}
\end{matrix}$$

Thus the optimal solution involves solving subproblems for each k and
then making a choice based on the size of the subset formed.

Greedy choice

$${M_{\mathit{ij}} = {a_{i} \cup M_{\mathit{kj}}}}\mathit{where}{f_{i} < s_{k}}\text{and}\nexists M_{\mathit{hj}}\mathit{such}\mathit{that}{f_{h} < f_{k}}$$

i.e., the maximal subset of an activity set, M<sub>ij</sub>, consists of
the task with the earliest finish time, a<sub>i</sub>, along with the
maximal subset of the activity subset, M<sub>kj</sub>, whose activity
with the earliest finish time, a<sub>k</sub>, starts only after
a<sub>i</sub> finishes and there is no other activity subset,
M<sub>hj</sub>, with an activity, a<sub>h</sub>, which finishes earlier
than a<sub>k</sub>.

Running time

Running time is easy to see. All one needs is a scan across the *n*
**sorted** activities to determine the maximal subset if an iterative
implementation is done. In a recursive implementation the n iterations
translate to a tail recursion resulting in n recursive calls. Thus the
running time is $$\Theta{({n\log n})}$$
