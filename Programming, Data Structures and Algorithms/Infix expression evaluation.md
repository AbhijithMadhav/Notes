Infix expression evaluation

Note: For simplicity, algorithms here assume that the expression is
fully parenthesized, with numbers and characters separated by
whitespace.

<span id="anchor"></span>Iterative Algorithm -
[Implementation](Eclipse%20C++%20Workspace/InfixEvaluation/InfixEvaluation.cpp)

-  What I intuitively did

  - push operator into stack
  - push operands into stack
  - Ignore '('
  - When ')' is encountered, pop 3 times to get hold of operand1,
    operator, operand1 respectively. Evaluate and push the result into
    the stack
  - Continue until the entire infix expression is scanned. The result is
    waiting to be popped out

- Djikstra's two stack algorithm(Source: Algorithms, 4th Edition,
  Sedgewick, Wayne, section 1.3, page 128)\*

  - Maintain two stacks, one for the operands and the other for the
    operators
  - Proceed as above, but pushing operators and operands into different
    stacks
  - When '(' is encountered,
  - pop operand-2 and operand-1 respectively from the operand stack
  - pop the operator from the operator stack
  - Evaluate and push the result back in the operand stack.
  - Continue until the entire infix expression is scanned. The result is
    waiting to be popped out from the operand stack

**Recursive Algorithm -
**[**I**](Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/PrefixEvaluationRecursive/PrefixEvaluationRecursive.cpp)[**mplementation**](Algorithms%20in%20C++,%20Parts%201-4~%20Fundamentals,%20Data%20Structure,%20Sorting,%20Searching%20-%203rd%20Edition%20-%20Sedgewick/Exercises/PrefixEvaluationRecursive/PrefixEvaluationRecursive.cpp)

- Recursive definition of an arithmetic expression involving a binary
  operator

  - exp: exp op exp

    - exp op num

      num op exp

      num op num

- Algorithm

  - Identify if the first operand is a sub-expression or a number

    - if expression, recursively evaluate the expression to obtain
      operand-1
    - if number, operand-1 = number(trivial case)

  - Identify the operator

  - Identify if the second operand is a sub-expression or a number

  - If expression, recursively evaluate the expression to obtain
    operand-2

    - If number, operand-2 = number(trivial case)

  - return operand1 op operand2

Tests to determine if an operand of an expression is a sub-expression or
a number(trivial case)

- If the first character of the expression is a number, then the operand
  is a number

  2 + 3

  22 + ( 42 \* 56 )

- If the first character of the expression if a '(', then the operand is
  another sub-expression

  ( 45 + 24 ) \* 5

  ( 45 + 45 ) \* ( 4 + 34 )

To Do

- Need to check the web for a more neat solution. Especially regarding
  the determination of the nature of operands
- implement in C++ and Java after learning OOPS
