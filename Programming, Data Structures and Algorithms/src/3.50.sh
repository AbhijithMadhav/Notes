#! /bin/bash

g++ -Wall 3.50.cpp list.cpp -o /tmp/3.50
g++ -Wall 3.50.cpp list_lib.cpp -o /tmp/3.50.lib

m=2
for n in 1000 1000 100000 1000000
do
	echo "Self memory management, m = $m, n = $n: `time /tmp/3.50 $n $m`"
	echo "Library memory management, m = $m, n = $n: `time /tmp/3.50.lib $n $m`"
done


