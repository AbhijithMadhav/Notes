**Minimize cabs**

Unlimited cabs. Capacity is c passengers.

R is the set of requests. All requests must be satisfied.

Each request is a pickup from stop A to stop B. There is a pickup time
interval in which the pickup must be made.

Taxi's do not come back once they reach B.

Taxi's cannot idle

Sort requests by their earliest start time. Such a sorting will result
in the grouping of requests with overlapping pickup time intervals. Let
the groups be$$G_{1,}\ldots,G_{k}$$ such that
$${{{\mid G_{1} \mid} + \ldots} + {\mid G_{n} \mid}} = {\mid R \mid}$$ -
$$O{({R\log R})}$$. Each group
$$G_{i}$$needs$$\left\lceil \frac{\mid G_{i} \mid}{c} \right\rceil$$taxis
for a total of
$$\sum\limits_{i = 1}^{n}\left\lceil \frac{\mid G_{i} \mid}{c} \right\rceil$$.

while there are no more unserviced requests

x = number of overlapping requests

if$$x \geq c$$

Assign c of them to taxi

else if x \< c

Assign these x requests to the taxi

Sort requests by their earliest end time.

while there are no more unserviced requests

Consider the first request in the list of unserviced request.

Pick a max of c – 1 more requests proceeding orderly in the list of
unserviced requests.

Assign these 1 + c requests to a new taxi t. Remove them from the
unserviced list.
