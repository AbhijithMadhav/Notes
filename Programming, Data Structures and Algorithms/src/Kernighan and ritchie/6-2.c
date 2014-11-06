#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <stdlib.h>

#define MAXWORD 100
#define VAR_LEN 6

struct key
{
	char* word;
} datatypes[] = {"char", "double", "float", "int", "short", "long",  "signed", "unsigned"};

enum {FALSE, TRUE};

struct tnode{
	char* word;
	int count;
	struct tnode* right;
	struct tnode* left;
};

int main(int argc, char *argv[])
{
	int getword(char*, int);
	int binsearch(char*, struct key[], int);
	struct tnode *addtree(struct tnode *, char *);
	void treeprint(struct tnode *);

	int c, var_len = VAR_LEN;
	char word[MAXWORD], trunc_word[MAXWORD];
	int decl = FALSE;
	struct tnode *root = NULL;
	/*	if (argc == 1)
	var_len = atoi(argv[1]);*/

	while((c = getword(word, MAXWORD)) != EOF)
	{
		if(isalpha(word[0]))
		{
			if (binsearch(word, datatypes, 8) >= 0)
			{
				decl = TRUE;
				continue;
			}
			if (decl == TRUE)
			{
				strncpy(trunc_word, word, var_len);
				root = addtree(root, word);
				while(getword(word, MAXWORD) != ';')
				{
					if (word[0] == '=')
					{
						int temp;
						while(!((temp = getword(word, MAXWORD)) == ',' || temp == ';'))
							;
						if (temp == ';')
						{
							decl = FALSE;
							break;
						}
					}
					else if (word[0] == '[')
						while(getword(word, MAXWORD) != ']')
							;
					else if (isalpha(word[0]))
					{
						strncpy(trunc_word, word, var_len);
						root = addtree(root, word);
					}
					decl = FALSE;
				}

			}
		}
		else
		{
			if (decl == 'TRUE')
			{

			}
		}
	}
	treeprint(root);
	return 0;
}

/* addtree: add a node with w, at or below p */
struct tnode *addtree(struct tnode *p, char *w)
{
	struct tnode *talloc(void);
	char *strdup(char *);

	int cond;
	if (p == NULL) { /* a new word has arrived */
		p = talloc(); /* make a new node */
		p->word = strdup(w);
		p->count = 1;
		p->left = p->right = NULL;

	} else if ((cond = strcmp(w, p->word)) == 0)
	{
		p->count++; /* repeated word */

	}
	else if (cond < 0) /* less than into left subtree */
		p->left = addtree(p->left, w);
	else /* greater than into right subtree */
		p->right = addtree(p->right, w);
	return p;
}

/* treeprint: in-order print of tree p */
void treeprint(struct tnode *p)
{
	if (p != NULL) {
		treeprint(p->left);
		printf("%4d %s\n", p->count, p->word);
		treeprint(p->right);
	}
}


/* talloc: make a tnode */
struct tnode *talloc(void)
{
	return (struct tnode *) malloc(sizeof(struct tnode));

}
char *strdup(char *s) /* make a duplicate of s */
{
	char *p;
	p = (char *) malloc(strlen(s)+1); /* +1 for '\0' */
	if (p != NULL)
		strcpy(p, s);
	return p;
}
/* binsearch: find word in tab[0]...tab[n-1] */
int binsearch(char *word, struct key datatypes[], int n)
{
	int cond;
	int low, high, mid;
	low = 0;
	high = n - 1;
	while (low <= high)
	{
		mid = (low + high) / 2;
		if ((cond = strcmp(word, datatypes[mid].word)) < 0)
			high = mid - 1;
		else if (cond > 0)
			low = mid + 1;
		else
			return mid;
	}
	return -1;
}