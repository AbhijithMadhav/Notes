#! /bin/bash

g++ ./3.29.c -o /tmp/3.29

n=2
m=10
while [ $n -le 1000 ]
do
	echo $n `/tmp/3.29 $n $m`
	n=`expr $n + 1`;
done > /tmp/3.29.temp

graph -T X /tmp/3.29.temp -X "N" -Y "Josephus Function" -L "M = $m"
