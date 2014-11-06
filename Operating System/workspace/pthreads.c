#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

#define NTHREADS 10
void *print_hello_world(void *tid)
{
	int i;
	for (i = 0; i < 1000000; ++i);
	printf("Hello world. Greetings from thread %d\n", (int)tid);
	pthread_exit(NULL);
}

int main()
{
	pthread_t thread[NTHREADS];
	int status, i;

	for (i = 0; i < NTHREADS; ++i)
	{
		printf("Main here. Creating thread %d\n", i);
		status = pthread_create(&thread[i], NULL, print_hello_world, (void*) i);

		if (status != 0)
		{
			printf("Error. pthread_create returned error code %d\n", status);
			exit(-1);
		}
	}
		return 0;
}
