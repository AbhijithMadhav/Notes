Strongly connected components –
[Implementatio](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Graphs/src/StronglyConnectedComponents.java)[n(Kosraju's
algorithm)](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Graphs/src/StronglyConnectedComponents.java)

- Two vertices are strongly connected if they are mutually reachable. A
  digraph is strongly connected if all its vertices are strongly
  connected to each other.

  -  Note that in a DAG each vertex is its own strong component.

- Decomposing a digraph into its strongly connected components is a
  classic application depth-first search.

- Many algorithms that work with directed graphs begin with such a
  decomposition. After decomposition, such algorithms run separately on
  each strongly connected component and then combine the solutions
  according to the structure of connections among components.

Problem statement

- - Are two given vertices in this graph strongly connected OR are do
    the two given vertices belong to the same strongly connected
    component?
  - How many strongly connected components does this graph have?
  - To which strongly connected component does a vertex belong to?

Solution

- - In case of a directed graph, SCC's can be determined by doing a DFS
    on the vertices of the reverse of the digraph in the order
    determined by the topological order of the **of the graph.**

Why does the solution work?

- - We can mark all vertices of a particular SCC by starting a DFS in
    that SCC. Thus, we can identify all SCC's of a digraph by starting
    DFS in each SCC.
  - But, as SCC's of a graph are connected to each other, the DFS
    intended to traverse and mark vertices of a particular SCC,
    $$C_{1}$$, may drop into other SCC's, say $$C_{2}$$ in this case,
    and start marking vertices of $$C_{2}$$ as those belonging to
    $$C_{1}$$.
  - Thus the requirement is a sequence of SCC's,
    $$\langle{C_{1,}C_{2,}\ldots,C_{n}}\rangle$$, such that there is no
    path from $$C_{i}$$ to $$C_{i + 1}$$. A path from $$C_{i + 1}$$ to
    $$C_{i}$$ does not pose a problem like the above as vertices of
    $$C_{i}$$ are already marked and can be filtered off when the DFS in
    $$C_{i + 1}$$ spills to $$C_{i}$$. Also there cannot be a path from
    $$C_{i}$$ to $$C_{i + 1}$$ and one from $$C_{i + 1}$$ to $$C_{i}$$
    as that would mean that $$C_{i + 1}$$ and $$C_{i}$$ are not two
    SCC's but one.
  - The topological ordering of the digraph gives an exact complement of
    such an ordering. It gives a sequence of SCC's,
    $$\langle{C_{1,}C_{2,}\ldots,C_{n}}\rangle$$, such that there is a
    path from $$C_{i}$$ to $$C_{i + 1}$$.
  - If we now reverse the digraph, the said ordering,
    $$\langle{C_{1,}C_{2,}\ldots,C_{n}}\rangle$$ of G is such that in
    $$G^{T}$$, there is no path from $$C_{i}$$ to $$C_{i + 1}$$, which
    matches out requirement.
  - Thus proceeding in the topological order on the reverse of a graph
    helps determine all strongly connected components.
