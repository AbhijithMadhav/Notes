Network flow problem

Problem statement

Given

- A directed graph, G = (V, E)
- Each$$e \in E$$has a capacity,$$c_{e} \in \mathbb{N}$$, associated
  with it indicating the maximum amount of flow, $$f_{e}$$, that can
  pass through it.
- All vertices except the source, s, and target, t, abide by the flow
  conservation.$${\sum\limits_{e \in {\mathit{outgoing}\mathit{edges}{(v_{i})}}}f_{e}} = {\sum\limits_{e \in {\mathit{outgoing}\mathit{edges}{(v_{i})}}}f_{e}}$$
- The source vertex, s, has no incoming edge.
- The target vertex, t, has no outgoing edge.
- The total flow in the graph is the flow originating at the source,
  i.e.,$$f = {\sum\limits_{e \in {\mathit{outgoing}\mathit{edges}{(s)}}}f_{e}}$$
- Find the maximum possible flow in the graph. It is loosely
  bounded$$C = {\sum\limits_{{e \in \mathit{outgoing}}\mathit{edges}{(s)}}c_{e}}$$

Idea

- Increase flow along augmenting paths

  - Augmenting path: Find an undirected path from s to t such that:

    - Can increase flow on forward edges (not full).
    - Can decrease flow on backward edge (not empty).

- Termination: All paths from s to t are blocked by either a

  - Full forward edge.
  - Empty backward edge.

**Ford-Fulkerson Algorithm – O(CE)**

- Start with 0 flow.

- While there exists an augmenting path: – O(C)

  - find an augmenting path - O(V + E) = O(E) – Each node has atleast
    one edge incident
  - compute bottleneck capacity - O(E)
  - increase flow on that path by bottleneck capacity - O(E)

Why it works?

- At every augmentation the value of the flow increases.

  After an augmentation flow will decrease only if it contains backward
  edges. But this cannot happen as the target vertex has no outgoing
  edges. So atleast the edge connecting t is a forward edge and this
  leads to an increase in flow in the augmentation.

- The algorithm terminates

  The maximum value of the flow is C. The flow is initially zero. At
  every augmentation the value of the flow has to increase by atleast
  one. Thus in the worst case, after C augmentations FF terminates.

- Algorithm computes max-flow

  Because there are no more augmenting paths. All paths are blocked by
  full forward edges(can't inject any more flow along those paths) or by
  empty backward edges(can't add flow along the paths connected by a
  backward edge by removing flow from the backward edge. See slide 21)

How to compute the min-cut (A, B)?

- Run FF algorithm on the graph
- There are no augmenting paths with respect to f.
- Compute A = set of vertices connected to s by an undirected path with
  no full forward or empty backward edges using a graph traversal
  algorithm.
- B = V - A
- The **forward **edges connecting A to B constitute the min-cut edges.

How to find an augmenting path?

Use BFS

Bad case for Ford-Fulkerson

Even with integer capacities, number of augmenting paths could be equal
to the maxflow which could be an exponential in the input size.

Edmond-Karp algorithm

Performance

Applications

- Multiple sources and destination

  - A master source and a master target

- **Problems with circulation demands -**

  A network has certain supply nodes and certain demand nodes. Is a
  feasible circulation possible?

  - All vertices,$$s_{i}$$, with a supply,$$\mathit{supply}_{s_{i}}$$,
    are represented as source vertices in the flow network.
  - All vertices,$$t_{i}$$, with a demand, $$\mathit{demand}_{t_{i}}$$,
    are represented as target vertices in the flow network.
  - Add a new source s with an edge $$({s,s_{i}})$$from s to every
    supply node$$s_{i} \in S$$.
  - Add a new sink t with an edge $$({t_{i},t})$$from every
    node$$t_{i} \in T$$to t.
  - The capacity of
    edges<sub>$${({s,s_{i}})} = \mathit{supply}_{s_{i}}$$</sub>
  - The capacity of
    edges<sub>$${({t_{i},t})} = \mathit{demand}_{d_{i}}$$</sub>
  - Now the network has a feasible flow if and only if the total flow
    =$$\sum\mathit{demand}_{t_{i}}$$.

- Problems with circulation demands and lower bound on edge flows.

  A network has certain supply nodes and certain demand nodes. Some of
  its edges may also have a minimum flow requirement. Is a feasible
  circulation possible?

  - Remove the minimum flow requirement(say l) on edges, e, by
    performing the folloiwng transformations.

    - $${C_{e} = C_{e}}–l$$(indicating that there is already a flow
      equal to the lower bound)
    - $$\mathit{supply}_{\text{from}}$$ += l(indicating that the from
      vertex of this edge needs an extra supply equal to the lower
      bound)
    - demand_to -= l(indicating that the demand of the to vertex has
      reduced by the lower bound of the edge due to the implicit flow)

  - This now essentially reduces to the problem with circulation demand
    flow. If the circulation demand flow constraint is satisfied the
    network satisfies the lower bound flows too.

- Bipartite matching

  - Create digraph G' = (L ∪ R ∪ {s, t}, E' ).
  - Direct all edges from L to R, and assign unit capacity.
  - Add source s, and unit capacity edges from s to each node in L.
  - Add sink t, and unit capacity edges from each node in R to t.
  - Maximum cardinality of matching = $$\mid M \mid$$ = Max flow in G'
  - If$${{\mid M \mid} = \mathit{\min}}{({{\mid L \mid},{\mid R \mid}})}$$,
    then we have a perfect matching

- Number of edge-disjoint paths in a directed graph

  - Given G, s and t
  - Set$$c{{({u,v})} = 1,}\forall{{({u,v})} \in G}$$
  - flow = k implies number of edge-disjoint paths is k
  - As k = O(E), Ford-Fulkerson algorithm can be used$$({O{(E^{2})}})$$

- Number of edge-disjoint paths in an undirected graph

  - Given G, s and t
  - Construct G', a directed graph with two opposite edges between every
    pair of vertices.
  - Set$$c{{({u,v})} = 1,}\forall{{({u,v})} \in G}$$
  - flow = k implies number of edge-disjoint paths is k
  - It may seem that two paths may be edge-disjoint in this directed
    graph and yet share an edge in the undirected graph G.
  - However, in flow terms, the flow by one these two edges is cancelled
    out.

- Survey design

- 

- Baseball elimination

- Airline scheduling

- Matrix rounding

- Vertex cover
