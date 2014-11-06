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

#define N 10
typedef int item;
item buffer[N];
int in = 0, out = 0, counter = 0;

pthread_cond_t full, empty;
pthread_mutex_t mutex;

#define SLEEP_INTERVAL 3

// Initialise semaphores and locks
void init() {
	pthread_cond_init(&full, NULL);
	pthread_cond_init(&empty, NULL);
	pthread_mutex_init(&mutex, NULL);
}

void insertItem(item i) {
	pthread_mutex_lock(&mutex);

	if (counter == N)
		pthread_cond_wait(&empty, &mutex);

	buffer[in] = in;
	printf("Produced %d\n", buffer[in]);
	in = (in + 1) % N;
	counter++;

	pthread_cond_signal(&full);
	pthread_mutex_unlock(&mutex);

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
	pthread_mutex_lock(&mutex);

	if (counter == 0)
		pthread_cond_wait(&full, &mutex);

	printf("Consumed %d\n", buffer[out]);
	out = (out + 1) % N;
	counter--;

	pthread_cond_signal(&empty);
	pthread_mutex_unlock(&mutex);
}

// Consumer thread
void* consumer(void *p) {
	while (1) {
		sleep(rand() % SLEEP_INTERVAL);
		consumeItem(rand());
	}
	return p;
}

int main() {
	pthread_t p, c;
	pthread_attr_t attr;
	pthread_attr_init(&attr);
	long t = 0;

	init();
	pthread_create(&p, &attr, producer, (void*) t);
	pthread_create(&c, &attr, consumer, (void*) t);

	pthread_join(p, NULL);
	pthread_join(c, NULL);
	return 0;

}
