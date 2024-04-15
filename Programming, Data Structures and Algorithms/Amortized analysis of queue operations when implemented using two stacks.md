Amortized analysis of queue operations when implemented using two stacks

Operations

ENQUEUE(x)

1.  S1.push(x)

DEQUEUE()

1.  if (S2.empty())
2.   while (! S1.empty())
3.   S2.push(S1.pop())
4.  S2.pop()

Loose upper bound

Aggregate method

Accounting method

Potential method(CLRS 17.3-6, Notes-18)

The DEQUEUE operation when S2 is empty is the exorbitant cost operation.
All elements of S1 will have to be popped and pushed into S2 before a
DEQUEUE via a S2.pop() can be done. Thus before S2 becomes empty enough
potential to do this must have been generated. This can be done by
adding 2 to the total potential whenever an element is put into S1,
i.e., ENQUEUED.

Thus let
$$\Phi{{(D_{i})} = {2 \times \mathit{Number}}}\mathit{of}\mathit{elements}\text{in}{S_{1} = {2 \times k}}$$
