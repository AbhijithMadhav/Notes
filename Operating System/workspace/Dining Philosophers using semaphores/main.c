/*
 * main.c
 *
 *  Created on: 01-Oct-2011
 *      Author: kempa
 */

#define NUM 5
#define MAX_SLEEP_INTERVAL 3

#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>

#include<pthread.h>
#include<semaphore.h>
sem_t chopstick[NUM];

void* philosopher(void *num) {
	static int k = -1;
	k++;
	int *p = num;
	int i = k;

	int left = i;
	int right = (i + 1) % 5;
	do {
	//if ((i % 2) == 0) {
		sem_wait(&chopstick[left]);
		sem_wait(&chopstick[right]);
	//} else {
		//sem_wait(&chopstick[left]);
		//sem_wait(&chopstick[right]);
	//}

	printf("%d : Eating with %d and %d\n", i, left, right);
	sleep(rand() % MAX_SLEEP_INTERVAL); // eating
	printf("%d : Dropping %d and %d\n", i, left, right);

	sem_post(&(chopstick[i]));
	sem_post(&(chopstick[(i + 1) % 5]));
	}while(1);
	return num;
}

void init() {
	for (int i = 0; i < NUM; i++)
		sem_init(&(chopstick[i]), 0, 1);
}

int main() {
	pthread_t p[NUM];

	init();
	for (int i = 0; i < NUM; i++)
		pthread_create(&p[i], NULL, philosopher, (void*)i);

	for (int i = 0; i < NUM; i++)
		pthread_join(p[i], NULL);
	return 0;
}
