Binary search symbol table –
[Implementation](Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Symbol%20Tables/src/BinarySearchST.java)

- Is an ordered symbol table implemented using an ordered array.
- Insertions and deletions are so done such that the ordering is
  maintained.
- As a result insertion and deletion are not efficient. A lot of data
  might have to be moved.
- The symbol table gets its name from the way searching is done. Because
  of the relative ordering maintained comparing the given key with the
  mid-element in the array helps eliminate half the array in one single
  iteration. Thus the worst case search complexity is only O(lg N).

Why not use a linked list instead of an array in a binary search
implementation?

The efficiency of binary search depends on our ability to get to the
middle of any sub-array quickly via indexing and the only way to get to
the middle of a singly linked list is to follow links.

When is the binary search symbol table implementation of binary search
useful?

When there is a static table which is used most of the time only for
queries.

<span id="anchor"></span>Average case of binary search

Let$$C{(n)}$$be the number of array accesses to find the n'th element.

$$\mathit{Average}\mathit{number}\mathit{of}\mathit{array}{{\mathit{accesses} = \frac{\mathit{Total}\mathit{number}\mathit{of}\mathit{array}\mathit{accesses}}{N}} = \frac{{\sum\limits_{i = 1}^{n}C}{(i)}}{N}}$$

Assuming that n is a power of two for convenience,

<table>
<tbody>
<tr class="odd">
<td>Elements found</td>
<td>Number of elements found</td>
<td>Number of iterations the algorithm should be run</td>
<td>Number of accesses per element</td>
<td>Total number of accesses</td>
</tr>
<tr class="even">
<td>Every <span class="math display">$$\left( \frac{N}{2}
\right)^{\mathit{th}}$$</span> element</td>
<td>1</td>
<td>1</td>
<td>1</td>
<td>1</td>
</tr>
<tr class="odd">
<td>Every <span class="math display">$$\left( \frac{N}{4}
\right)^{\mathit{th}}$$</span> element</td>
<td>2</td>
<td>2</td>
<td>2</td>
<td>4</td>
</tr>
<tr class="even">
<td>Every <span class="math display">$$\left( \frac{N}{8}
\right)^{\mathit{th}}$$</span> element</td>
<td>4</td>
<td>3</td>
<td>3</td>
<td>9</td>
</tr>
<tr class="odd">
<td>Every <span class="math display">$$\left( \frac{N}{16}
\right)^{\mathit{th}}$$</span> element</td>
<td>8</td>
<td>4</td>
<td>4</td>
<td>16</td>
</tr>
<tr class="even">
<td><p>.</p>
<p>.</p>
<p>.</p></td>
<td><p>.</p>
<p>.</p>
<p>.</p></td>
<td><p>.</p>
<p>.</p>
<p>.</p></td>
<td><p>.</p>
<p>.</p>
<p>.</p></td>
<td><p>.</p>
<p>.</p>
<p>.</p></td>
</tr>
<tr class="odd">
<td>Every other element</td>
<td><span class="math display">$$\frac{2^{\mathit{\lg}N}}{2} =
\frac{\mathit{\lg}N}{2}$$</span></td>
<td>lg N</td>
<td>lg N</td>
<td><span
class="math display">(<em>lg</em> <em>N</em>)<sup>2</sup></span></td>
</tr>
</tbody>
</table>

Total number of array accesses

=
$$\sum\limits_{k = 1}^{\mathit{\lg}N}{\mathit{Total}\mathit{number}\mathit{of}\mathit{accesses}\mathit{\text{in}}\mathit{the}k'\mathit{th}{\mathit{iteration} \ast \mathit{Number}}\mathit{of}\mathit{elements}\mathit{that}\mathit{can}\mathit{be}\mathit{found}\text{in}k'\mathit{th}\mathit{iteration}}$$

=
$${{{\sum\limits_{k = 1}^{\mathit{\lg}N}i} \ast 2^{i - 1}} = N}\mathit{\lg}N$$

Average number of array accesses = lg (N – 1), i.e. the average case is
just one lesser than the worst case. This is because the number of
elements in the array which get accessed in the last iteration(the worst
case iteration of lg N) is equal to the number elements which get
accessed in all the other iterations together(1 to lg(N) – 1).

Illustration for average case of binary search: N = 15

|                      |                                                                   |                     |
|----------------------|-------------------------------------------------------------------|---------------------|
| Number of iterations | Array elements accessed                                           | Percentage of nodes |
| 1                    | A\[7\]                                                            | ~6.25%              |
| 2                    | A\[3\], A\[11\]                                                   | ~12.5%              |
| 3                    | A\[1\], A\[5\], A\[9\], A\[13\]                                   | ~25%                |
| 4                    | A\[0\], A\[2\], A\[4\], A\[6\], A\[8\], A\[10\], A\[12\], A\[14\] | ~ 50%               |
