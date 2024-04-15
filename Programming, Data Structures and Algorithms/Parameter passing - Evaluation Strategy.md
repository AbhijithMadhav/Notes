Evaluation strategy in parameter passing

Strict evaluation

Arguments are always evaluated completely before invocation of the
function

- Call by value

  - The arguments expression is evaluated, and the resulting value is
    copied to a new memory location which is then bound to the
    corresponding variable in the function.
  - Thus modifications to these variables in the function are localized
    inside the callee and is not visible in the scope of the caller
  - Most common type of evaluation strategy.
  - Used in C, Scheme

- Call by reference

  - The argument expression is evaluated and the function receives an
    implicit reference to the variable used as the argument
  - This typically means that the function can modify the variable used
    as the argument and this can be seen by the caller.

- Call by copy-restore/value-result

  - Works like call by value initially : argument expression is
    evaluated and the resulting value is copied to a new memory location
    which is then bound to the corresponding variable in the function.
  - After the function is executed, it tries to provide the effect of a
    copy-by-reference mechanism by restoring back the possibly modified
    local copies of the callee to the caller.

Non-strict evaluation

Arguments are not evaluated unless they are actually used in the
execution of the function body

- Call by name

  - Similar to the macro expansion and evaluation
  - An argument expression is placed verbatim in the function body of
    the caller, replacing the occurrences of parameter usage.
  - This argument expression is thus evaluated every single time it is
    encountered in function body.

- Call by need

  - Similar to the call by name mechanism except that the argument
    expression evaluated for the first time in the function body of the
    caller is memoized.
  - This memoized value is then used subsequently instead of repeated
    evaluation of the argument expression.
