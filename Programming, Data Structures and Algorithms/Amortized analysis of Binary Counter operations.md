Amortized analysis of incrementing a binary counter

Operations

- INCREMENT(A) – O(k) – A contains k bits

  - Flip all ones from the lsb until a zero is encountered.
  - Flip the zero.

Loose upper bound

- If the counter is k bit, in the worst case incrementing would require
  flipping all bits – O(k)

- For a sequence of n INCREMENT operations, worst case cost is

  $$T{{(n)} = {k \times O}}{(n)}$$

Aggregate analysis

- During a sequence of n INCREMENT operations,

  - 0'th bit flips n times
  - 1<sup>st</sup> bit flips n/2 times
  - 2<sup>nd</sup> bit flips n/4 times
  - 3<sup>rd</sup> bit flips n/8 times
  - .
  - .
  - .
  - (k-1)'th bit flips$$n/2^{k - 1}$$ times

- Total cost for n INCREMENT operations would be

  $$T{{{{(n)} = {{\sum\limits_{i = 0}^{k–1}n}/2^{i}}} < 2n} = O}{(n)}$$

- Would total cost remain the same if DECREMENT(A) were included in the
  sequence of n operations?

  No. Consider a sequence of n operations composed of alternate
  INCREMENT(A) and DECREMENT(A) on a counter initialized
  to$$2^{k - 1}$$. The counter would alternate between 11111... k times
  to 00000... k times. Each operation flipping all bits and costing O(k)
  with total cost becoming O(nk)

Accounting method

Assign a cost of 2 for setting a bit. A cost of 1 for setting a bit and
a credit of 1 to associate with that bit. This credit is used for
resetting a bit.

|                  |                                                     |
|------------------|-----------------------------------------------------|
| Operation        | Amortized cost                                      |
| Flip from 0 to 1 | 2(1 for 0 → 1 and the other for the possible 1 → 0) |
| Flip from 1 to 0 | 0                                                   |

Additional operation of RESET

Modify INCREMENT to store the location of the highest order bit

INCREMENT(A)

1.  i = 0
2.  highOrderBitIndex = -1
3.  while (i \< A.length && A\[i\] == 1)
4.   A\[i\] = 0
5.   i = i + 1
6.  if (i \< A.length)
7.   A\[i\] = 1
8.   highOrderBitIndex = i

RESET(A)

1.  i = highOrderBItIndex
2.  while ( i \>= 0)
3.   A\[i\] = 0
4.   i = i – 1
5.  highOrderBitIndex = -1

|                  |                                                                    |
|------------------|--------------------------------------------------------------------|
| Operation        | Amortized cost                                                     |
| Flip from 0 to 1 | 3(1 for 0 → 1, 1 for 1 → 0, the other for a possible reset(1 → 0)) |
| Flip from 1 to 0 | 0                                                                  |

Potential method

$$\Phi{(D_{i})}$$ = Number of 1's in the counter after the i'th
operation.
