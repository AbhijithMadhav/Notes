Maximize requests

N cabs.

R is the set of requests. Not all requests can be satisfied.

Each request is a pickup from stop A to stop B. There is a pickup time
interval in which the pickup must be made.

Taxi's do not come back once they reach B.

Sort requests by their earliest start time. Such a sorting will result
in the grouping of requests with overlapping pickup time intervals. Let
the groups be$$G_{1,}\ldots,G_{k}$$ such that
$${{{\mid G_{1} \mid} + \ldots} + {\mid G_{n} \mid}} = {\mid R \mid}$$ -
$$O{({R\log R})}$$

Now sort the groups by the number of requests they contain in the
non-increasing order. - $$O{({R\log R})}$$

k = 1 // taxi index

while there are no unserviced requests

For each group$$G_{i}$$

if$${\mid G_{i} \mid} \geq c$$

Assign to Taxi\[k++\]

if (k \> n)

exit

else

c--

break;

c--
