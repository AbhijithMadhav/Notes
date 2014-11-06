/*
 * josephus.cpp
 *
 *  Created on: 22-Sep-2010
 *      Author: kempa
 *
 */

struct node
  {
	int item; node* next;
    node(int x)
      { item = x; }
  };
typedef node *Link;

/**
 * Implements an algorithm to solve the Josephus problem
 *
 * Makes use of a circular list as a data structure.
 * The list is linear until the insertion of the last node saving
 *   the setting of one pointer per insertion
 *
 * @param m Position to be be skipped
 * @param n Number of positions
 * @return
 */
int josephusOptimized(int m, int n)
  {
    Link t = new node(1);
    Link x = t;
    for (int i = 2; i <= n; i++)
      x = (x->next = new node(i));
    x->next = t;
    while (x != x->next)
      {
        for (int i = 1; i < m; i++) x = x->next;
        x->next = x->next->next;
      }
    return x->item;
  }

