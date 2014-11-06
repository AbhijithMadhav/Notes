/*
 * producerConsumer.c
 *
 *  Created on: 30-Sep-2011
 *      Author: kempa
 */

#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>

#include<pthread.h>
#include <semaphore.h>

#define N 10
typedef int item;
item buffer[N];
int in = 0, out = 0, counter = 0;

sem_t full, empty;
pthread_mutex_t mutex;

#define SLEEP_INTERVAL 7

// Initialise semaphores and locks
void init() {
	sem_init(&full, 0, 0);
	sem_init(&empty, 0, N);
	pthread_mutex_init(&mutex, NULL);
}

void insertItem(item i) {
	sem_wait(&empty);
	pthread_mutex_lock(&mutex);

	buffer[in] = in;
	printf("Produced %d\n", buffer[in]);
	in = (in + 1) % N;
	counter++;

	pthread_mutex_unlock(&mutex);
	sem_post(&full);
}

// Producer thread
void* producer(void *p) {
	while (1) {
		sleep(rand() % SLEEP_INTERVAL);
		insertItem(rand());
	}
	return p;
}


void consumeItem() {
	sem_wait(&full);
	pthread_mutex_lock(&mutex);

	printf("Consumed %d\n", buffer[out]);
	out = (out + 1) % N;
	counter--;

	pthread_mutex_unlock(&mutex);
	sem_post(&empty);
}

// Consumer thread
void* consumer(void *p) {
	while (1) {
		sleep(rand() % SLEEP_INTERVAL);
		consumeItem(rand());
	}
	return p;
}

int main()
{
	pthread_t p, c;
	pthread_attr_t attr;
	pthread_attr_init(&attr);
	long t = 0;

	init();
	pthread_create(&p, &attr, producer, (void*)t);
	pthread_create(&c, &attr, consumer, (void*)t);

	pthread_join(p, NULL);
	pthread_join(c, NULL);
	return 0;

}
