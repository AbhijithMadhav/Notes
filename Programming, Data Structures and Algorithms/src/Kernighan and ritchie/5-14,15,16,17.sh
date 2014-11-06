#! /bin/bash

clear
filename=`basename $0 .sh`

set -x
gcc -std=c99 -Wall ${filename}.c readline_writeline.c dircmp.c foldcmp.c numcmp.c alloc.c getline.c \
    qsort.c swap.c isnumber.c -o $filename
set +x
