#! /bin/bash 
gcc -Wall main.c

if [ $? -eq 0 ]
then
#./a.out < input | sed -e '/creating new/d' -e '/time is/d' -e '/future time /d' -e '/scheduling arrival/d' > out
./a.out < input > out
fi
