#!/bin/bash

clear
file=`basename $0 .sh`
set -x
gcc -Wall -std=c99 -g ${file}.c buffer.c -o $file
