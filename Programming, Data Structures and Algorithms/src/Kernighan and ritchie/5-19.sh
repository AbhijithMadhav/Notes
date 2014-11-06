#! /bin/bash

file=`basename $0 .sh`
clear
set -x
gcc -g -Wall -std=c99 ${file}.c gettoken.c buffer.c -o $file
set +x
