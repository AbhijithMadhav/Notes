Queues

- A queue is an abstract data type or collection that is based on the
  first-in-first-out(FIFO) policy. The element added first is the first
  to be removed.

- The important operations provided by this ADT are

  - Enqueueing – The process of adding an element into the queue is
    called enqueueing and element.
  - Dequeueing – The process of removing an element from the queue is
    called dequeueing the element.

Dynamic array implementation

- A dynamic array is an array which re-sizes automatically when there is
  no space for a new element.

- The intuitive method of implementing a queue ADT using an array is by
  treating the front and back of an array as the front and back of the
  queue. Enqueueing and dequeueing is done by maintaining pointers to
  the front and back of the queue. But this is impractical as the array
  space freed up by dequeueing is blocked and cannot be reused(Figure
  8). Thus after a number of deletions, the ADT(the queue) will contain
  a few elements whereas the underlying data structure(the array) will
  still occupy huge space reflecting the peak usage.

- To use space efficiently the queue ADT is implemented as a circular
  buffer instead of a straight forward dynamic array implementation. As
  a result array space freed up by dequeueing can be reused.

- The implementation of the queue as a circular buffer is tricky. A
  naïve circular buffer implementation using only 'front' and 'rear'
  indexes cannot distinguish between a full and an empty Q(Figure 7).
  This can be overcome by

  - Always using an empty slot in the underlying array –
    [Implementation](workspace/ADT/src/QArrayEmptySlot.java)

    - Disadvantage is that if the queue is small and the queue slots are
      big or implemented in hardware leaving a slot open is inefficient
      utilization of space.

  - Keeping track of the number of items in the queue –
    [Implementation](workspace/ADT/src/QArrayCount.java)

    - Access to the count variable by the enqueue and dequeue operations
      have to be synchronized together with the queue and the 'front'
      index.

Linked list implementation

The linked list implementation is straight forward

References

- Sedgewick 3 and 4 edition
- <http://en.wikipedia.org/wiki/Circular_buffer>

Can do

- [Mirroring](http://en.wikipedia.org/wiki/Circular_queue#Mirroring)
- [Read / Write
  Counts](http://en.wikipedia.org/wiki/Circular_queue#Read_.2F_Write_Counts)
- [Absolute
  indices](http://en.wikipedia.org/wiki/Circular_queue#Absolute_indices)
- [Record last
  operation](http://en.wikipedia.org/wiki/Circular_queue#Record_last_operation)
