**Access specifiers in java**

|                                                                               |                                   |
|-------------------------------------------------------------------------------|-----------------------------------|
| **Semantics of various access specifiers at the top level(i.e. For a class)** |                                   |
| **Access specifiers**                                                         | **Visibility**                    |
| public                                                                        | Visible to all classes everywhere |
| package private(no explicit modifier)                                         | Visible only within the package   |

**What is the implication of a class(A) being visible to another
class(B)?**

- An object of type A can be created and used by B.
- Static methods of A can be accessed using the class name(if the lower
  level access specifiers allow) by B.

|                                                                                    |                                                    |                        |                     |     |
|------------------------------------------------------------------------------------|----------------------------------------------------|------------------------|---------------------|-----|
| **Semantics of access specifiers at the lower level(i.e. For members of a class)** |                                                    |                        |                     |     |
| **Access specifiers**                                                              | **Visibility**                                     |                        |                     |     |
| **Inside class**                                                                   | **Inside package(in classes of the same package)** | **Inside child class** | **Everywhere else** |     |
| **public**                                                                         | Yes                                                | Yes                    | Yes                 | Yes |
| **protected**                                                                      | Yes                                                | Yes                    | Yes                 | No  |
| **package private(no explicit modifier)**                                          | Yes                                                | Yes                    | No                  | No  |
| **private**                                                                        | Yes                                                | No                     | No                  | No  |

<span id="anchor"></span>**What is the implication of a class member(a
of A) being visible inside another class(B)?**

- a of A can be accessed using an object of A inside B if a is not
  static.
- a of A can be accessed as A.a inside B.

**What is the implication of a class member(a of A) being visible inside
a child class(C)?**

a is inherited by C
