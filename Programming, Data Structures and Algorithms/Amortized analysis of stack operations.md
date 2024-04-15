Amortized analysis of stack operations

Operations

- - PUSH(S, x) – O(1)
  - POP(S, x) – O(1)
  - MULTIPOP(S, k) – O(k)

Loose upper bound

For a sequence of n operations, worst case cost,

- $$T{{(n)} = \mathit{Number}}\mathit{of}{\mathit{operations} \times \mathit{worst}}\mathit{case}\mathit{cost}\mathit{of}\mathit{worst}{\mathit{operation} = {n \times O}}{{(n)} = O}{(n^{2})}$$

Aggregate analysis

- Key observation is that the total number of POP(S, x) operations
  including that in MULTIPOP(S, x) can be atmost equal to the number of
  PUSH(S, x) operations(After all you can't pop more elements than you
  have pushed in), which is a maximum of n for a sequence of n
  operations.

- Thus for a sequence of n operations, worst case cost is O(n).

- Amortized cost of each operation = Average cost of an operation =
  O(n)/n = O(1)

- Would the cost be O(n) for any sequence of n operations if there was a
  MULTIPUSH(S, a\[k\]) operation?

  - Consider a sequence of n operations composed of alternate
    MULTIPUSH(S, a\[n\]) and MULTIPOP(S, n) operations. Total cost would
    be

    $$T{{(n)} = O}{{{(2n)} \times n} = O}{(n^{2})}$$

The accounting method

<table>
<tbody>
<tr class="odd">
<td>Operation</td>
<td>Amortized cost</td>
</tr>
<tr class="even">
<td>PUSH</td>
<td><p>Associate a 2 with the pushed element</p>
<p>(1 for PUSH and the other for possible POP)</p></td>
</tr>
<tr class="odd">
<td>POP</td>
<td>0</td>
</tr>
<tr class="even">
<td>MULTIPOP</td>
<td>0</td>
</tr>
</tbody>
</table>

For any sequence of n
operations,$$T{{(n)} = {n \times O}}{{({{2 + 0} + 0})} = O}{(n)}$$

Suppose the stack size never exceeds k. This is done by copying the
entire stack for backup purposes after every k operations. What would be
the total amortized cost?

<table>
<tbody>
<tr class="odd">
<td>Operation</td>
<td>Amortized cost</td>
</tr>
<tr class="even">
<td>PUSH</td>
<td><p>Associate a 3 with the pushed element</p>
<p>(1 for PUSH, 1 for possible POP and 1 for possible copy)</p></td>
</tr>
<tr class="odd">
<td>POP</td>
<td>0</td>
</tr>
<tr class="even">
<td>MULTIPOP</td>
<td>0</td>
</tr>
</tbody>
</table>

For any sequence of n
operations,$$T{{(n)} = {n \times O}}{{({{3 + 0} + 0})} = O}{(n)}$$

Potential method

$$\Phi{(D_{i})}$$= Number of elements in the stack after the i'th
operation.

$$\Phi{{(D_{n})} - \Phi}{{(D_{0})} \geq 0}$$ as there cannot be negative
amount of elements in the stack

<table>
<tbody>
<tr class="odd">
<td>Operation</td>
<td>Amortized cost</td>
</tr>
<tr class="even">
<td>PUSH(S, x)</td>
<td><span class="math display">$${\widehat{c_{i}} = {1 + {({{({\Phi_{i -
1} + 1})} - \Phi_{i - 1}})}}} = 2$$</span></td>
</tr>
<tr class="odd">
<td>POP(S)</td>
<td><span class="math display">$${\widehat{c_{i}} = {1 + {({{({\Phi_{i -
1} - 1})} - \Phi_{i - 1}})}}} = 0$$</span></td>
</tr>
<tr class="even">
<td><p>MULTIPOP(S, k)</p>
<p>Assume k' = min(k, |S|) elements are popped</p></td>
<td><span class="math display">$${\widehat{c_{i}} = k}{{' + {({{-
k}'})}} = 0}$$</span></td>
</tr>
</tbody>
</table>

The total amortized cost for n operations is$${n \times 2} = 2n$$

What is the total cost of executing n operations if the stack begins
with $$s_{0}$$objects and finished with $$s_{n}$$objects?

The above calculation shows that,
$${2n = {{\sum\limits_{i = 1}^{n}c_{i}} + (}}{s_{n} - s_{0}})$$

$$\Rightarrow{{\sum\limits_{i = 1}^{n}c_{i}} = {{2n - s_{n}} + s_{0}}}$$.
This is O(n) as$$s_{o} \leq n$$.
