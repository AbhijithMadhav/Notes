/* stack.c */
void push(double);
double pop(void);
void print_top(void);
void duplicate(void);
void swap(void);
void clear(void);

/* buffer.c */
int getch(void);
void ungetch(int);
void ungets(char []);

/* getop.c */
int getop(char []);
#define NUMBER '0' /* signal that a number was found */
#define SIN 's'   /* signal that the sine operator was found */
#define POW 'p'
#define EXP 'e'
#define INVALID_OPERATOR -1
#define IDENTIFIER -2
