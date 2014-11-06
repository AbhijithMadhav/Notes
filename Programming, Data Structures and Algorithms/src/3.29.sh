#! /bin/bash

g++ ./3.29.c -o 3.29
for n in 1000 10000 100000 1000000
do
	for m in 2 3 5 10
	do
		echo "For N = $n, M = $m, Remaining person: `./3.29 $n $m`"
	done
done
