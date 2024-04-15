Subset sum

Given a set of n positive integers,
$${S = \{}a_{1,}a_{2,}\ldots,a_{n}\}$$, and a positive integer W, is
there a subset of S whose elements sum to W?

$$X{{\lbrack{i,j}\rbrack} = \mathit{TRUE}}$$ only if there is a subset
of $${\{ a_{1,}a_{2}}{,\ldots,a_{i}\}}$$ whose elements sum to $$j$$.
$${{1 \leq i} \leq n},{{0 \leq j} \leq W}$$

$$X{{\lbrack{i,j}\rbrack} = \left\{ \begin{matrix}
{X{{\lbrack{i–1,j}\rbrack} \vee X}{\lbrack{i–1,{j - a_{i}}}\rbrack}}
\end{matrix} \right.}$$
