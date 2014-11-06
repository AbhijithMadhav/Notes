/*
 * main.c
 *
 *  Created on: 11-Oct-2011
 *      Author: kempa
 */

#define NUM 5
#define MAX_SLEEP_INTERVAL 3

#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>

#include<pthread.h>
pthread_cond_t chopstick[NUM];
pthread_mutex_t mutex;

void* philosopher(void *num) {
	static int k = -1;
	k++;
	int i = k;
	int left = i;
	int right = (i + 1) % 5;
	do {
		pthread_mutex_lock(&mutex);
		if ((i % 2) == 0) {
			pthread_cond_wait(&chopstick[left], &mutex);
			pthread_cond_wait(&chopstick[right], &mutex);
		} else {
			pthread_cond_wait(&chopstick[right], &mutex);
			pthread_cond_wait(&chopstick[left], &mutex);
		}
		pthread_mutex_lock(&mutex);
		printf("%d : Eating with %d and %d\n", i, left, right);
		sleep(rand() % MAX_SLEEP_INTERVAL); // eating
		printf("%d : Dropping %d and %d\n", i, left, right);

		pthread_mutex_lock(&mutex);
		pthread_cond_signal(&(chopstick[i]));
		pthread_cond_signal(&(chopstick[(i + 1) % 5]));
		pthread_mutex_unlock(&mutex);

	} while (1);
	return num;
}

void init() {
	for (int i = 0; i < NUM; i++)
		pthread_cond_init(&(chopstick[i]), NULL);
}

int main() {
	pthread_t p[NUM];

	init();
	for (int i = 0; i < NUM; i++)
		pthread_create(&p[i], NULL, philosopher, (void*) i);

	for (int i = 0; i < NUM; i++)
		pthread_join(p[i], NULL);
	return 0;
}
