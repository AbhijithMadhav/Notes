#! /bin/bash

gcc -Wall -lm 2.5.c -o /tmp/2.5

/tmp/2.5 | grep -v lg | awk '{ print $1 " " $2}' > /tmp/temp1

/tmp/2.5 | grep -v lg | awk '{ print $1 " " $3}' > /tmp/temp2

graph -T X -X "N" -C /tmp/temp1 -T X -L "10lgN vs 2N^2" -C /tmp/temp2

rm -f /tmp/2.5 /tmp/temp1 /tmp/temp2

