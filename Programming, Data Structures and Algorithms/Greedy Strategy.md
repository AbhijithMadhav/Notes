Greedy strategy

- A greedy algorithm obtains an optimal solution to a problem by making
  a sequence of choices, each of which is a locally optimal one, in the
  hope that these choices lead to a globally optimal solution.
- All solutions which can be solved using dynamic programming can also
  be solved by making greedy choices(just that the solution may not be
  the optimal one).
- This is a heuristic based approach and thus will not always produce an
  optimal solution. So we use it only when it does
- Typical dynamic programming based solutions to problems with optimal
  substructure have multiple subproblems based on several choices
  leading towards a solution. At each step each step we solve to get all
  solutions. We then make a choice and choose the best among them. In
  the greedy method, we instead make a choice(the greedy one) before
  handed and thus eliminate all but one possible way towards an optimal
  solution at each step.
- If greedy strategy works for a particular problem, choosing dynamic
  programming over it is is an overkill.

**Typical structure of a iterative greedy solution**

- Initially the set of chosen items is empty i.e., solution set.

- At each step

  - Consider adding an item to the solution set by using a
    selection-function/greedy-strategy.

  - IF set is feasible THEN

    - Add the current item.

    ELSE IF the set is not be feasible

    - Reject items under consideration (and never consider again).

<table>
<tbody>
<tr class="odd">
<td>Greedy algorithm</td>
<td>Greedy strategy employed at each step/iteration of the greedy
solution</td>
<td>Contrast with dynamic solution</td>
</tr>
<tr class="even">
<td>Fractional knapsack</td>
<td>Select the item(largest possible fraction) with the highest value
per unit weight.</td>
<td>Determine value of all possible packings. Select the one with the
maximum value</td>
</tr>
<tr class="odd">
<td><p><a href="Activity%20Selector.odt">Activity selection</a>/Interval
scheduling</p></td>
<td><p>Select that activity which has the </p>
<ul>
<li>Earliest finish time among the remaining activities.</li>
<li>Whose start time is greater than the finish time of the last
activity in the solution set.</li>
</ul></td>
<td>Determine all possible legal sets of activities. Select the one
which has the largest number of activities.</td>
</tr>
<tr class="even">
<td>All interval scheduling</td>
<td></td>
<td></td>
</tr>
<tr class="odd">
<td>Scheduling with penalty</td>
<td></td>
<td></td>
</tr>
<tr class="even">
<td>Huffmans coding</td>
<td></td>
<td></td>
</tr>
<tr class="odd">
<td><a href="Maximize%20requests.odt">Cabs – Maximizing
requests</a></td>
<td></td>
<td></td>
</tr>
<tr class="even">
<td><a href="Minimize%20cabs.odt">Cabs – Minimizing cabs</a></td>
<td></td>
<td></td>
</tr>
<tr class="odd">
<td>Scheduling jobs with deadlines and profits</td>
<td>Select the job with the highest profit per time unit</td>
<td>Determine all possible legal schedules. Select the one which has the
largest total profit</td>
</tr>
<tr class="even">
<td><p><a href="Minimum%20spanning%20tree.odt#Prims%20Algorithm">Prims
algorithm</a><a href="Minimum%20spanning%20tree.odt#Prims%20Algorithm">
for minimum </a><a
href="Minimum%20spanning%20tree.odt#Prims%20Algorithm">spanning
trees</a></p></td>
<td>Select a vertex from the among the neighbouring ones which is at the
least distance from the construction-in-progress MST.</td>
<td>Determine all possible spanning trees. Select the one with the
minimum weight.</td>
</tr>
<tr class="odd">
<td><p><a
href="../../../../tmp/Minimum%20spanning%20tree.odt#Kruskals%20Algorithm">Kruskal's
algorith</a><a
href="../../../../tmp/Minimum%20spanning%20tree.odt#Kruskals%20Algorithm">m</a><a
href="../../../../tmp/Minimum%20spanning%20tree.odt#Kruskals%20Algorithm">
</a><a
href="../../../../tmp/Minimum%20spanning%20tree.odt#Kruskals%20Algorithm">for
</a><a
href="../../../../tmp/Minimum%20spanning%20tree.odt#Kruskals%20Algorithm">minimum
spanning trees</a></p></td>
<td>Select an edge with the least weight which does not form a cycle the
construction-in-progress MST.</td>
<td></td>
</tr>
<tr class="even">
<td><a href="../../../../tmp/Dijkstra&#39;s%20algorithm.odt">Dijkstra's
</a><a href="../../../../tmp/Dijkstra&#39;s%20algorithm.odt">algorithm
</a><a href="../../../../tmp/Dijkstra&#39;s%20algorithm.odt">shortest
path</a></td>
<td>Select a vertex from the among the neighbouring ones which is at the
least distance from the source vertex of the construction-in-progress
shortest-path spanning tree.</td>
<td>For each vertex, determine all possible paths from the source
vertex. Pick the shortest one.</td>
</tr>
</tbody>
</table>
