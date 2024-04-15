Universal hashing

Simple uniform hashing assumption(SUHA)

- The hash functions that we use uniformly and independently distribute
  keys among the integer values 0 and m – 1. In other words this means
  that if there are n different keys, exactly n/m of them will hash onto
  the same value.

- Probability of two keys, say,$$k_{1}$$and$$k_{2}$$, having the same
  hash function is 1/m under the uniform hashing assumption.

  - Associated with$$h{(k_{1})}$$are (n - 1)/m other keys apart
    from$$k_{1}$$.
  - $$P{{\left\{ {h{{(k_{2})} = h}{(k_{1})}} \right\} = \frac{{({n–1})}/m}{n}} \equiv {1/m}}$$

Universal hashing

- The nature of hashing, fitting in n keys into m slots where
  $${\mid U \mid} \gg m$$, ensures that however uniformly a hash
  function distributes the keys, there is always a pathological data set
  which can be cause all n keys to hash into the same slot causing the
  unsuccessful search time to be $$\Theta{(n)}$$
- The solution is thus to not use a fixed hash function but to use a
  random hash function from a family of hash functions which realize the
  simple uniform hashing assumption(To a great extent). This way no
  single set of data always invokes the worst case running time.
- Universal hash functions are a collection of hash functions, H, such
  for any two distinct keys $$k,{l \in U}$$the number of hash
  functions$$h \in H$$for which h(k) = h(l) is **at
  most**$${\mid H \mid}/m$$.
- In other words with a hash function randomly chosen from H, the
  probability that two distinct keys are hashed to the same slot is at
  most 1/m.

<!-- -->

- 
