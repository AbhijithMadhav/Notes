/* Program to implement euclid algorithm iteratively */

/* Link with -largtable2 */
#include<stdio.h>
#include<argtable2.h>

int
main (int argc, char *argv[])
{
  int gcd (int, int);
  int n, m, nerrors;
  struct arg_int *n_arg = arg_int0 ("n", NULL, "<n>", "First number");
  struct arg_int *m_arg = arg_int0 ("m", NULL, "<n>", "Second number");
  struct arg_end *end = arg_end (0);
  void *argtable[] = { n_arg, m_arg, end };
  if (arg_nullcheck (argtable) != 0)
    printf ("error: insufficient memory\n");
  n_arg->ival[0] = 6;
  m_arg->ival[0] = 22;
  nerrors = arg_parse (argc, argv, argtable);
  if (nerrors == 0)
    {
      n = n_arg->ival[0];
      m = m_arg->ival[0];
      printf ("GCD of %d and %d : %d\n", n, m, gcd (n, m));
      arg_freetable (argtable, sizeof (argtable) / sizeof (argtable[0]));
      return 0;
    }
  else
    {
      arg_print_errors (stdout, end, argv[0]);
      arg_print_syntaxv (NULL, argtable, "Syntax :");
      arg_freetable (argtable, sizeof (argtable) / sizeof (argtable[0]));
      return 1;
    }
}

int
gcd (int n, int m)
{
  while (n != 0 && m != 0)
    if (n <= m)
      m = m % n;
    else
      n = n % m;
  return n == 0 ? m : n;
}
