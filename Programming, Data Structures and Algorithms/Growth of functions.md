Growth of functions

How can the running time of an algorithm be quantified mathematically?

By a polynomial function on the input size, say n.

$$f{{(n)} = {\sum\limits_{i = 0}^{k}c_{i}}}x^{i}$$

What does order of growth of an algorithm talk about?

- It talks about how the running time of an algorithm grows with
  increase in input size of the problem the algorithm is solving
- The highest order term of the equation representing the running time
  of the algorithm is representative of the effect of the whole
  equation. This is because, for large n, the highest order term
  contributes significantly more to the running time compared to the
  other terms, to the extent of masking the contributions of the other
  lower order terms.
- The order of growth thus uses/refers to only the highest order term
  and ignores the lower order term
- Also the co-efficients of the highest order terms only suggest a
  constant variation from the highest term itself and are hence also
  ignored

Definition : Asymptote

Asymptote means equivalent

Asymptotic notation

- Provides us with tools to specify the **bounds** of the order of
  growth in the running time of algorithms.
- By bounds, it is meant to specify the boundaries w.r.t which the
  running time will vary.

Set like conventions of the asymptotic notations

- The below two properties mentioned w.r.t. $$\Theta$$function applies
  to the $$O,\Omega,o,\omega$$ notations as well

  - $$\Theta$$of a given function, g(n),** **is a set of functions
    specified by$$\Theta{({g{(n)}})}$$, for a given function, g(n).
  - f(n) =
    $$\Theta{({g{(n)}})}$$means$$f{{(n)} \in \Theta}{({g{(n)}})}$$.

$$\Theta$$notation - $$\Theta$$of a given function, g(n)

- Helps specify a a tight(upper and lower) asymptotic bound within which
  the running time of an algorithm(with a specific type of input
  actually) varies.

- Graphically, the curve of all f(n) in $$\Theta{({g{(n)}})}$$always
  lies **between** c<sub>**1**</sub>g(n) and c<sub>**2**</sub>g(n),
  **inclusive**, for all n $$@$$n<sub>0</sub>

- The running time of an algorithm when described using the
  $$\Theta$$notation **does not** indicate the running time on every
  possible type of input, but rather on a particular type of input.

  - **Example** : Running time of insertion sort is
    $$\Theta{(n^{2})}$$does not imply a tight bound of
    $$\Theta{(n^{2})}$$on every type of input, as insertion sort runs in
    $$\Theta{(n)}$$on arrays which are already sorted.

- While determining a polynomial representing the running time of an
  algorithm belonging to a $$\Theta{({g{(n)}})}$$, a suitable
  c<sub>1</sub>, c<sub>2</sub>, and n<sub>0 </sub>must be found.*
  *Setting c<sub>1</sub> to a value that is slightly smaller than the
  coefficient of the highest-order term of f(n) and setting
  c<sub>2</sub> to a value that is slightly larger permits the
  inequalities in the definition of $$\Theta$$notation to be satisfied.

$$O$$ notation – $$O$$ of a given function, g(n)

- Helps specify an upper bound for the order of growth of a function
- The running time of an algorithm when described using the $$O$$
  notation indicates the worst case running time of an algorithm.
- Graphically, the curve of all f(n) in $$O{({g{(n)}})}$$always lies
  **below** cg(n), **inclusive,** for all n $$@$$n<sub>0</sub>

$$\Omega$$notation - $$\Omega$$of a given function, g(n)

- Helps specify a lower bound for the order of growth of a function
- The running time of an algorithm when described using
  the$$\Omega$$notation indicates the best case running time of the
  algorithm.
- Graphically, the curve of all f(n) in $$\Omega{({g{(n)}})}$$always
  lies **above** cg(n), **inclusive,** for all n $$@$$n<sub>0</sub>

$$o$$ notation –$$o$$of a given function, g(n)

- Helps specify a asymptotic upper bound that is **not tight** on the
  growth of a function.
- Graphically, the curve of all f(n) in $$o{({g{(n)}})}$$always lies
  **below** cg(n), **exclusive**, for all n $$@$$n<sub>0</sub>

$$\omega$$ notation – $$\omega$$ of a given function, g(n)

- Helps specify a asymptotic upper bound that is **not tight** on the
  growth of a function.
- Graphically, the curve of all f(n) in $$\omega{({g{(n)}})}$$always
  lies **above** cg(n), **exclusive**, for all n $$@$$n<sub>0</sub>

Asymptotic notations(AN) in equalities and inequalities

- AN is use on the RHS(only) of an equation and is not a part of a
  complex formula on the RHS

  - Interpretation - The function on the LHS is a member of the set
    represented by the F-AN on the RHS

- In general when it appears in an equation it stands for some anonymous
  function which we do not care to name.

- AN appears in the LHS of an equation

  - Interpretation – No matter what function the AN on the LHS
    represents, a AN on the right side can be replaced with a suitable
    function to satisfy the equality.

When is a function asymptotically non-negative?

A function, f(n), is asymptotically non-negative if f(n) is non-negative
whenever n is sufficiently large.

Properties of asymptotic notation

- Transitivity

  - $$f{{(n)} = \Theta}{({g{(n)}})}$$ and
    $$g{{(n)} = \Theta}{({h{(n)}})}$$ imply
    $$f{{(n)} = \Theta}{({h{(n)}})}$$
  - $$f{{(n)} = O}{({g{(n)}})}$$and $$g{{(n)} = O}{({h{(n)}})}$$ imply
    $$f{{(n)} = O}{({h{(n)}})}$$
  - $$f{{(n)} = \Omega}{({g{(n)}})}$$ and
    $$g{{(n)} = \Omega}{({h{(n)}})}$$ imply
    $$f{{(n)} = \Omega}{({h{(n)}})}$$

- Reflexivity

  - $$f{{(n)} = \Theta}{({f{(n)}})}$$
  - $$f{{(n)} = O}{({f{(n)}})}$$
  - $$f{{(n)} = \Omega}{({f{(n)}})}$$

- Symmetry

  - $$f{{(n)} = \Theta}{({g{(n)}})}$$ if and only if
    $$g{{(n)} = \Theta}{({f{(n)}})}$$

- Transpose symmetry

  - $$f{{(n)} = O}{({g{(n)}})}$$if and only if
    $$g{{(n)} = \Omega}{({f{(n)}})}$$
  - $$f{{(n)} = o}{({g{(n)}})}$$if and only if
    $$g{{(n)} = \omega}{({f{(n)}})}$$

- If f (x) = O(g(x)), and g(x) = O(f (x)), then f (x) = Θ(g(x)).

Analogy between comparisons of asymptotic notation of two functions and
comparisons of two real number a and b

- $$f{{(n)} = \Theta}{({g{(n)}})}$$ is like a = b
- $$f{{(n)} = O}{({g{(n)}})}$$ is like $$a \leq b$$
- $$f{{(n)} = \Omega}{({g{(n)}})}$$ is like $$a \geq b$$
- $$f{{(n)} = o}{({g{(n)}})}$$ is like a \< b
- $$f{{(n)} = \omega}{({g{(n)}})}$$ is like a \> b

Theorem 1

Let f (n) and g(n) be functions such that

f (n)

= A.

x→∞ g(n)

lim

Then

1\. If A = 0, then f (n) = O(g(n)), and f (n) = Θ(g(n)).

2\. If A = ∞, then f (n) = Ω(g(n)), and f (n) = Θ(g(n)).

3.  If A = 0 is finite, then f (n) = Θ(g(n)).
4.  

References

1.  Introduction to Algorithms - 3rd Edition - Cormen, Leiserson,
    Rivest, Stein
