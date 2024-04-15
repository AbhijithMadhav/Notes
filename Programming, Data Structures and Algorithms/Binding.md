Linking and Loading

Address binding

Address binding is the replacement of logical address references in a
program(assigned by compilers) to physical ones.

- Logical address references may be

  - Virtual addresses in a system that uses paging
  - Segmentation based addresses in a system that uses segmentation
  - Plain relocatable addresses in systems that don't use either of the
    above

Different types of address binding

- Compile time address binding

  - With this type of address binding, the compiler assigns physical
    addresses to instructions and data at compile time.
  - As a result the program has to always be loaded at the same
    location.
  - Only in old MSDOS .COM format are addresses of programs bound like
    this.
  - If a program is to be loaded at a different location, the whole
    program has to be recompiled.

- Load time address binding

  - With this type of address binding, the compiler assigns relocatable
    logicl addresses to instructions and data at compile time. The
    loader, at load time, depending on where the program is being
    loaded, adjusts the references within the program by adding or
    subtracting an offset.
  - Now, a program may be loaded at different locations each time it is
    executed. It has to be loaded in the same location after a
    swap-out-swap-in though.

- Execution time address binding

  - With this type of address binding, the binding of address is delayed
    until run time
  - This is so because the program may move from one area of the memory
    to the other in the course of its execution as a result of
    swap-out-swap-in.
  - This is the type of binding that takes place in systems using paging
    or segmentation. The address binding here does not involve changing
    memory references within the program but off adjusting entries in
    the page table or segmentation table, depending on where the
    program/parts-of-the-program is/are being loaded.

Dynamic loading

Dynamic loading does not require special support from the operating
system. It is the responsibility of the users to design their programs
to take advantage of such a method. Operating systems may help the
programmer, however, by providing library routines to implement dynamic
loading.

http://en.wikipedia.org/wiki/Dynamic_loading
