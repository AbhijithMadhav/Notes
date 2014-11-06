#! /bin/bash

# 3.50 Run empirical studies comparing the running times of the memory-allocation functions in Program 3.14 with new and delete (see Exercise 3.49) for
# Program 3.13 with M = 2 and N = 103, 104, 105, and 106.

LD_LIBRARY_PATH=$PWD/UniformMemoryAllocationForList/Debug g++ -O3 -Wall -I $PWD/UniformMemoryAllocationForList $PWD/3.50/3.13.cpp -lUniformMemoryAllocationForList -L$PWD/UniformMemoryAllocationForList/Debug -o $PWD/3.50/3.50
LD_LIBRARY_PATH=$PWD/VariableMemoryAllocationForList/Debug g++ -O3 -Wall -I $PWD/UniformMemoryAllocationForList $PWD/3.50/3.13.cpp -lVariableMemoryAllocationForList -L$PWD/VariableMemoryAllocationForList/Debug -o $PWD/3.50/3.50.lib

echo "This output displays the time efficiency of a simple uniform sized memory allocation scheme over a general purpose memory allocation scheme"
echo

m=2
for n in 1000 1000 100000 1000000
do
	echo m = $m, n = $n
	printf "Simple uniform sized memory management : "
    TIME="System = %S, User = %U" time $PWD/3.50/3.50 $n $m > /dev/null
    printf "General purpose, variable sized memory management(new and delete from C++ library) : "
    TIME="System = %S, User = %U" time $PWD/3.50/3.50.lib $n $m >/dev/null
    echo
done


