void construct(int);
Node newNode(int);
void deleteNode(Node);
void insert(Node, Node);
Node remove(Node);
Node next(Node);
Item item(Node);
#include <iostream.h>
#include <stdlib.h>
#include "list.h"
int main(int argc, char *argv[])
  { int i, N = atoi(argv[1]), M = atoi(argv[2]); 
    Node t, x;
    construct(N); 
    for (i = 2, x = newNode(1); i <= N; i++)
      { t = newNode(i); insert(x, t); x = t; }
    while (x != next(x))
      {
        for (i = 1; i < M; i++) x = next(x);
        deleteNode(remove(x)); 
      }
    cout << item(x) << endl;
    return 0;
  }

