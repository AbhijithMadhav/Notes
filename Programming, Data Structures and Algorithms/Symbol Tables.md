Symbol Tables

Symbol table

- An abstract data structure for key-value pairs that supports two basic
  operations: insert a new pair into the table and search for the value
  associated with the given key.
- Also called dictionaries.

Important characteristics

- Insertion of key-value pair already in the table results in the new
  **value** replacing the older one. As a result only one value is
  associated with each key.

- One can think of the symbol table being an associative array
  abstraction with keys being indexes and values are array entries

- Deletion

  - Lazy deletion – Associated the key to be deleted with a null. Later
    perhaps remove all such keys
  - Eager deletion – Remove key from table immediately

- Must make key types immutable. For if they key are allowed to be
  modified, the order ensured(by ordered symbol tables) by the symbol
  table might get invalidated making the symbol table inconsistent.

Variations of a symbol table

<table>
<tbody>
<tr class="odd">
<td>Ordered</td>
<td>Unordered</td>
</tr>
<tr class="even">
<td>Symbol tables maintain an ordering in the keys which helps implement
an expanded API that defines various natural and useful operations
involving keys in order</td>
<td>No ordering among keys maintained.</td>
</tr>
<tr class="odd">
<td><p>void put(Key key, Value val)</p>
<p>Value get(Key key)</p>
<p>void delete(Key key)</p>
<p>Key min()</p>
<p>Key max()</p>
<p>Key floor(Key key)</p>
<p>int rank(Key key)</p>
<p>Key select(int k)</p>
<p>void deleteMin()</p>
<p>Void deleteMax()</p></td>
<td><p>void put(Key key, Value val)</p>
<p>Value get(Key key)</p>
<p>void delete(Key key)</p>
<p>-Inefficient-</p>
<p>-Inefficient-</p>
<p>-Inefficient-</p>
<p>-Inefficient-</p>
<p>-Inefficient-</p>
<p>-Inefficient-</p>
<p>-Inefficient-</p></td>
</tr>
<tr class="even">
<td>Cannot be used with keys that do not have a natural ordering.</td>
<td><p>Can be used with keys that are not comparable.</p>
<p>Ex: Symbol tables with pictures or songs as keys</p></td>
</tr>
<tr class="odd">
<td><p>Implementations</p>
<ul>
<li>Binary search symbol table</li>
<li>Binary search tree</li>
<li><p>Balanced search trees</p>
<ul>
<li>2-3 trees</li>
<li>AVL trees</li>
<li>B and B+ trees</li>
</ul></li>
</ul></td>
<td><p>Implementations</p>
<ul>
<li>Sequential search symbol table</li>
<li>Hash Tables</li>
</ul></td>
</tr>
</tbody>
</table>

Cost Model

Most implementations of the symbol table use compares as their primary
operation. In a few implementations that don't, the number of array
accesses are factored into the complexity calculation

Example : In the binary search implementation though compares are used,
it is the array access which is the key operation in terms of
contribution to cost

Characteristics of a sample search client

- Searches and inserts are intermixed
- The number of distinct keys are not small.
- Substantially more searches than inserts are likely.
- Search and insert patterns, though unpredictable, are not random.

<table>
<tbody>
<tr class="odd">
<td></td>
<td>Average and Worst cost of key operations </td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr class="even">
<td>Implementation</td>
<td>Insertion into an N-element ST</td>
<td>Search hits in an N-element ST</td>
<td>Memory usage</td>
<td></td>
<td></td>
</tr>
<tr class="odd">
<td>Average</td>
<td>Worst</td>
<td>Average</td>
<td>Worst</td>
<td></td>
<td></td>
</tr>
<tr class="even">
<td><a href="Sequential-Search%20Symbol%20Table.md">Unordered linked
list implementation</a></td>
<td><a href="#Inserting into a sequential ST">N comparisons</a></td>
<td><a href="#Inserting into a sequential ST">N comparisons</a></td>
<td><p>N/2</p>
<p>comparisons </p></td>
<td>N comparisons</td>
<td></td>
</tr>
<tr class="odd">
<td><a href="Binary%20Search%20Symbol%20Table.md">Ordered array
implementation</a></td>
<td>N array accesses</td>
<td>2N array access</td>
<td><p><a href="#Average case of binary search">lg(N)</a></p>
<p><a href="#Average case of binary search">comparisons</a></p></td>
<td><p>lg(N)</p>
<p>comparisons</p></td>
<td></td>
</tr>
<tr class="even">
<td><p><a href="Binary%20Search%20Trees.md">Binary </a><a
href="Binary%20Search%20Trees.md">search </a><a
href="Binary%20Search%20Trees.md">tree</a></p>
<p>(BST)</p>
<p> <a href="../To%20do.md#Binary%20Search%20Tree">To do</a></p></td>
<td><p>1.39 lg(N)</p>
<p>comparisons</p></td>
<td><p>N</p>
<p>comparisons</p></td>
<td><p>1.39 lg(N)</p>
<p>comparisons</p></td>
<td>N comparisons</td>
<td></td>
</tr>
<tr class="odd">
<td></td>
<td><a href="Balanced%20Search%20Trees.md">Balanced search
trees</a></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr class="even">
<td><strong>AVL </strong><a
href="AVL%20Trees.md"><strong>T</strong></a><strong>rees</strong></td>
<td></td>
<td>lg(N)</td>
<td></td>
<td>lg(N)</td>
<td></td>
</tr>
<tr class="odd">
<td><strong>B and B+ trees</strong></td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr class="even">
<td>2-3 trees</td>
<td><p>lg(N)</p>
<p>comparisons</p></td>
<td><p>2lg(N)</p>
<p>comparisons</p></td>
<td><p>lg(N)</p>
<p>comparisons </p></td>
<td>2lg(N) comparisons</td>
<td></td>
</tr>
<tr class="odd">
<td><p>Left leaning red black trees</p></td>
<td><p>lg(N)</p>
<p>comparisons</p></td>
<td><p>2lg(N)</p>
<p>comparisons</p></td>
<td><p>lg(N)</p>
<p>comparisons </p></td>
<td>2lg(N) comparisons</td>
<td></td>
</tr>
<tr class="even">
<td>2-3-4 trees</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr class="odd">
<td>Red Black trees</td>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr class="even">
<td></td>
<td><a href="Hashing.md">Has</a><a href="Hashing.md">h Tables</a> – <a
href="../To%20do.md#Hashing"><strong>To do</strong></a></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
<tr class="odd">
<td><p>Unordered array with hashing implementation</p>
<p><a
href="Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Symbol%20Tables/src/SeparateChainingHashST.java">Hashing
with separate chaining</a></p>
<p>(array of lists)</p></td>
<td><p>~N/M</p>
<p>comparisons</p></td>
<td><p>&lt;lg(N)</p>
<p>comparisons</p></td>
<td><p>~N/M</p>
<p>comparisons</p></td>
<td>&lt;lg(N) comparisons</td>
<td></td>
</tr>
<tr class="even">
<td><p><a
href="Algorithms,%204th%20Edition%20-%20Sedgewick,%20Wayne/Exercises/Symbol%20Tables/src/LinearProbingHashST.java">Hashing
with linear probing</a>**</p>
<p>(parallel arrays)</p></td>
<td><p>½</p>
<p>comparisons</p></td>
<td><p>c lg(N)</p>
<p>comparisons</p></td>
<td><p>3/2</p>
<p>comparisons</p></td>
<td><p> c lg(N)</p>
<p>comparisons</p></td>
<td></td>
</tr>
</tbody>
</table>

\*\* Keeping load factor with array resizing \<= ½

<span id="anchor"></span>Inserting into a sequential symbol table

A search has to be made to ensure that there are no duplicates. An
element is inserted only if there is no duplicate, else it is updated.
Thus to insert into a N-element list, N comparisons are needed
