/*
 * main.cpp
 *
 *  Created on: 04-Jun-2011
 *      Author: kempa
 */

/*
 * 5.91 Write a recursive program that removes all the leaves with a given key
 *  from a tournament
 */

#include<iostream>
using std::cout;
using std::endl;

#include<cstdlib>
#include"node.h"
#include"constructTournamentTree.h"
#include "printTree.h"
#include "height.h"
#include "removeFromTournament.h"

#include<vector>
using std::vector;

#define MAX 10

int main()
{
	srand(time(NULL));
	int n = rand() % MAX + 1;
	//n = 3;
	int *a = new int[n];
	cout << "Participants : ";
	for (int i = 0; i < n; i++)
	{
		a[i] = rand() % 100;
		cout << a[i] << " ";
	}
	cout << endl;

	node<int> *root = constructTournamentTree(a, 0, n - 1);

	cout << "Original tournament structure" << endl;
	show(root, height(root));

	int withdrawal = rand() % n;
	//withdrawal = 0;
	root = removeFromTournament(root, a[withdrawal]);
	cout << "Tournament after the withdrawal of " << a[withdrawal] << endl;
	show(root, height(root));

	cout << endl;
	return 0;
}
