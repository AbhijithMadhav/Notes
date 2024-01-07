**Operating System**

-   [Processes](Processes.md) – [To do](g../To%20do.md#Processes)

    -   [Context Switching](gContext%20Switching.md)
    -   [Threads](gThreads.md)
    -   [CPU scheduling](gProcess%20Scheduling.md)
    -   [Signals](gSignals.md)

-   Inter-process communication – [To do](g../To%20do.md#IPC)

    -   [Shared Memory](gShared%20Memory.md) - [Inspecting SHM
        Processes](gInspectingSHMProcesses.txt)
    -   [Message Passing](gMessage%20Passing.md) -
        [Pipes](gPipes.md)

-   [Synchronization and concurrency among
    Processes](gProcess%20synchronization.md)

    -   [Locks](gLocks.md)

    -   [Atomic Hardware
        primitives](gAtomic%20hardware-primitives%20for%20synchronization.md)

    -   [Semaphores](gSemaphores.md)

        -   [Bounded buffer using counting
            semaphores](gworkspace/Bounded%20Buffer%20using%20counting%20semaphores/main.c)(Figure
            23)
        -   Readers-Writers using counting-semaphores(Figure 24)
        -   [Dining Philosophers problem using
            semaphores](gOperating%20System%20Concepts%20-%208th%20Edition%20-%20Silberschatz,%20Galvin,%20Gagne/src/Dining%20Philosophers%20using%20semaphores/main.c)(Figure
            25)

    -   [Monitors](gMonitors.md)

        -   [Bounded buffer using condition
            variables](gOperating%20System%20Concepts%20-%208th%20Edition%20-%20Silberschatz,%20Galvin,%20Gagne/Exercises/Bounded%20Buffer%20using%20condition%20variables/main.c)
        -   [Bounded buffer using
            monitors](gOperating%20System%20Concepts%20-%208th%20Edition%20-%20Silberschatz,%20Galvin,%20Gagne/Exercises/Bounded%20buffer%20using%20monitors/src/BoundedBuffer.java)
        -   [Dining Philosophers problem using
            condition-variables](gOperating%20System%20Concepts%20-%208th%20Edition%20-%20Silberschatz,%20Galvin,%20Gagne/Exercises/Dining%20Philosophers%20using%20condition%20variables/main.c)

-   [Deadlock](gDeadlocks.md) – [To do](../../To%20do.md#Deadlock)

    -   [Deadlock prevention](gDeadlock%20Prevention.md)
    -   [Deadlock avoidance](gDeadlock%20Avoidance.md)
    -   [Deadlock
        ](gDeadlock%20detection%20and%20recovery.md)[detection and
        ](gDeadlock%20detection%20and%20recovery.md)[recovery](../Deadlock%20detection%20and%20recovery.md)
    -   [Handling deadlocks in the concurrency control component of
        database
        systems](g../Databases/Handling%20deadlocks%20in%20concurrency%20control%20systems.md)

-   Memory management and virtual memory – [To
    do](g../To%20do.md#Memory%20management)

    -   [Memory management](gMemory%20management.md)

        -   [Contiguous memory allocation
            schemes](gContiguous%20Memory%20Allocation%20Scheme.md)
        -   [Paging](g../Computer%20Organization%20and%20Architecture/Virtual%20Memory.md)
        -   [Segmentation](gSegmentation.md)

    -   [Virtual
        memory](g../Computer%20Organization%20and%20Architecture/Virtual%20Memory.md)

        -   [Structure of Page
            Tables](g../Computer%20Organization%20and%20Architecture/Virtual%20Memory%20-%20Structure%20of%20Page%20Tables.md)
        -   [Page
            Replacement](g../Computer%20Organization%20and%20Architecture/Virtual%20Memory%20-%20Page%20Replacement.md)
        -   [Frame
            allocation](g../Computer%20Organization%20and%20Architecture/Virtual%20Memory%20-%20Frame%20allocation.md)
        -   [Memory usage of Page
            tables](g../Computer%20Organization%20and%20Architecture/Virtual%20Memory%20-%20Memory%20usage%20of%20Page%20tables.md)
        -   [Translation Lookaside
            buffer(TLB)](g../Computer%20Organization%20and%20Architecture/Virtual%20Memory%20-%20Translation-Lookaside%20buffer(TLB).md)
        -   [Design
            issues](g../Computer%20Organization%20and%20Architecture/Virtual%20Memory%20-%20Design%20issues.md)
        -   [Thrashing](g../Computer%20Organization%20and%20Architecture/Virtual%20Memory%20-%20Thrashing.md)
        -   [Memory Mapped
            Files](g../Computer%20Organization%20and%20Architecture/Virtual%20Memory%20-%20Memory%20Mapped%20Files.md)

-   File system – [To do](g../To%20do.md#File%20System)

    -   [Binary Files](gBinary%20Files.md)

    -   [File system structure](gFile%20System%20Structure.md)

    -   [File system
        implementation](gFile%20System%20Implementation.md)

        -   [Important data structures of a file
            system](gImportant%20data%20structures%20of%20a%20file%20system.md)
        -   [Directory Structure
            Implementation](gDirectory%20implementation.md)
        -   [File Allocation
            Methods](gFile%20Allocation%20Methods.md)
        -   [Free Space Management](gFree%20Space%20Management.md)
        -   [Design considerations of a file
            system](gDesign%20considerations%20of%20a%20file%20system.md)
        -   [File System Recovery](gFile%20System%20Recovery.md)
        -   File System Backup
        -   [NFS](gNetwork%20File%20System.md)

-   IO

    -   [Application IO interface](gApplication%20IO%20interface.md)

-   Protection and security – [To do](g../To%20do.md#Protection)

****Gate questions****

-   Processes, threads, scheduling

    -   TG - 2240 – 22, 39
    -   TG – 2241 – 4, 5, 6
    -   TG – 2242 – 32
    -   TG – 2233 – 14, 15, 26
    -   TG – 2251 – 18
    -   TG – 2253 – 34, 36
    -   TG – 2254 – 35
    -   ****TG – 2258 – ****12****
    -   G – 2003 – 77
    -   G – 2004 – 11, 12, 46
    -   G – 2005 – 72
    -   ****G – 2007 – ****16, 17, 55****
    -   G – 2008 – 37, 66
    -   G – 2009 – 32
    -   G – 2010 – 25
    -   G – 2011 – 6, 16, 35
    -   ****G – 20****12**** – ****5, ****31****

-   Inter-process communication

    -   TG – 2232 - 1

-   Synchronization and concurrency among Processes

    -   TG – 2240 – 41
    -   TG – 2242 – 48, 49
    -   TG – 2232 – 20
    -   TG – 2254 - 3
    -   G – 2003 – 80
    -   G – 2004 – 48
    -   ****G – 2007 – ****58****
    -   G – 2008 -63
    -   G – 2009 – 33
    -   G – 2010 – 23, 45
    -   ****G – 2012 – ****30****

-   Deadlock

    -   TG – 2240 – 40
    -   TG – 2241 – 45
    -   TG – 2234 – 48, 49
    -   TG – 2251 – 32
    -   TG – 2254 – 36, 37
    -   TG – 2257 – 23
    -   ****TG – 2258 – ****13****
    -   ****TG – 2259 – ****11****
    -   G – 2005 – 71
    -   ****G – 2007 – ****57****
    -   G – 2008 - 65
    -   G – 2009 – 30
    -   ****G – 2010 – ****46****

-   Memory management and virtual memory

    -   TG – 2232 – 21
    -   TG – 2233 – 9
    -   TG – 2234 – 44, 9, 7
    -   TG – 2241 – 47
    -   TG – 2242 – 31
    -   TG – 2251 – 54, 55
    -   TG – 2253 – 9, 35
    -   TG – 2254 – 1, 2, 29, 52, 53
    -   TG – 2255 – 19, 42
    -   TG – 2256 – 1, 2, 47, 48, 49
    -   TG – 2257 – 47
    -   TG – 2259 – 12
    -   ****TG – 2258 – 28****32, 33****
    -   G – 2003 – 26, 76, 78, 79
    -   G – 2004 – 21, 47,
    -   G – 2005 – 22
    -   ****G – 2007 – ****56, ****82, 83****
    -   G – 2008 - 67
    -   G – 2009 – 9, 10, 34
    -   G – 2010 – 24
    -   G – 2011 – 20
    -   ****G – 2012 – ****42****

-   File system

    -   TG – 2242 – 3
    -   G – 2003 – 25
    -   G – 2004 – 49
    -   G – 2005 – 21
    -   ****G – 2008 – ****20****
    -   ****G – 2012 – ****43****

-   Protection and security.

[](gSignals.md)