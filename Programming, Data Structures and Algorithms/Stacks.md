Stacks

- A stack is an ADT comprising of two basic operations: insert(push) a
  new item and remove(pop) the newly inserted item.
- Items in a stack are removed according to the last-in-first-out
  principle.

Examples of stack clients

- [Infix expression evaluation](Infix%20expression%20evaluation.odt)
- [Prefix expression
  evaluation](Eclipse%20C++%20Workspace/PrefixEvaluation/PrefixEvaluation.cpp)
- [Postfix evaluation evaluation](PostfixEvaluation.txt)
- [Infix to postfix
  conversion](Eclipse%20C++%20Workspace/InfixToPostfix/InfixToPostfix.cpp)
- [Postfix to infix
  conversion](Eclipse%20C++%20Workspace/PostfixToInfix/PostfixToinfix.cpp)
- Depth First Search

Implementation

We can implement the push and pop operations for the pushdown stack ADT
in constant time, using either arrays or linked lists.

- Using arrays

  - [Using fixed sized
    arrays](Eclipse%20C++%20Workspace/StackUsingArray/STACK.cxx)

    - Need to know the maximum number of entries to allocate space
      initially
    - Array implementation uses the amount of apce necessary to hold the
      maximum number of items expected throughout the computation

  - Using dynamic arrays

  - Chose array if we need a huge stack that is usually full

- Using linked lists

  - Insertion and deletion at the start of the list will result in a
    stack implementation
  - No need of head node for the same reason???
  - Uses space proportional to the number of items in the stack but
    always uses extra space for one link per item and uses extra time to
    allocate memory for each push operation and deallocate memory for
    each pop
  - Use linked list if the stack's size varies dramatically and other
    other data structures could make use of the space not being used
    when the stack has only a few items in it.
