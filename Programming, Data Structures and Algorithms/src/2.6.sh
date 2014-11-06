#! /bin/bash

gcc -Wall -lm 2.6.c -o /tmp/2.6

/tmp/2.6 | grep -v lg | awk '{ print $1 " " $2}' > /tmp/temp1

/tmp/2.6 | grep -v lg | awk '{ print $1 " " $3}' > /tmp/temp2

/tmp/2.6 | grep -v lg | awk '{ print $1 " " $4}' > /tmp/temp3

graph -T X /tmp/temp1 -T X /tmp/temp2 -T X -X "N" -C \
         -L "Values of N for which N^(3/2) is in between (N/2 * (lgN)^2) and (2N * (lgN)^2)"

#rm -f /tmp/1.6 /tmp/temp1 /tmp/temp2 /tmp/temp3

