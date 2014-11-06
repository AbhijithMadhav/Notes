#include <stdio.h>

extern struct rtpkt {
  int sourceid;       /* id of sending router sending this pkt */
  int destid;         /* id of router to which pkt being sent
                         (must be an immediate neighbor) */
  int mincost[4];    /* min cost to node 0 ... 3 */
  };

extern int TRACE;
extern int YES;
extern int NO;
extern float clocktime;

#define INFINITY 999
#define MYID 3
int connectcosts3[4] = { 7, INFINITY, 2, 0 };

/*
 * cost[i][j]: i represents 'via', j represents the destination
 *             from '3'
 */
struct distance_table 
{
  int costs[4][4];
} dt3;


/* students to write the following two routines, and maybe some others */

void rtinit3()
{
	int i, j;
	struct rtpkt pkt;
	void tolayer2(struct rtpkt );

	printf("Node %d: Initializing at %f\n", MYID, clocktime);

	/* Initializing my distance vector */
	for (i = 0; i < 4; i++)
		dt3.costs[MYID][i] = connectcosts3[i];

	/* Initializing distance vector of my neighbours*/
	for (i = 0; i < 4; i++)
	{
		if ( i == MYID)
			continue;
		for (j = 0; j < 4; j++)
			dt3.costs[i][j] = INFINITY;
	}

	/* Prepare a routing packet and send my neighbours my distance vector
	 * in it */
	pkt.sourceid = MYID;
	for (i = 0; i < 4; i++)
		pkt.mincost[i] = dt3.costs[MYID][i];
	for ( i = 0; i < 4; i++)
	{
		/* Send my distance vector only to my neighbours */
		if ( i == MYID || connectcosts3[i] == INFINITY)
			continue; // if node is myself or a non-neighbour
		pkt.destid = i;
		tolayer2(pkt);
	}
}


void rtupdate3(struct rtpkt *rcvdpkt)
{
	int j, updated = NO, via;
	void printdt3(struct distance_table*);
	printf("Node %d: Distance vector, [", MYID);
		for ( j = 0; j < 4; j++)
			printf("%d ", rcvdpkt->mincost[j]);
		printf("], received from %d at %f\n", rcvdpkt->sourceid, clocktime);


	/* update the distance table for the received vector*/
	via = rcvdpkt->sourceid;
	for (j= 0; j < 4; j++)
	{
		dt3.costs[via][j] = connectcosts3[via] + rcvdpkt->mincost[j];

		/* normalize the value back to INFINITY */
		if (dt3.costs[via][j] > INFINITY)
			dt3.costs[via][j] = INFINITY;
	}

	/* update the distance vector of '3' */
	updated = NO;
	for (j = 0; j < 4; j++)
		if (dt3.costs[MYID][j] > dt3.costs[via][j])
		{
			dt3.costs[MYID][j] = dt3.costs[via][j];
			updated = YES;
		}

	if (updated)
	{
		struct rtpkt pkt;
		int i;
		void tolayer2(struct rtpkt );
		printf("	Distance vector updated to [");
		for ( j = 0; j < 4; j++)
			printf("%d ", dt3.costs[MYID][j]);
		printf("]\n");

		printdt3(&dt3);
		pkt.sourceid = MYID;
		for (i = 0; i < 4; i++)
			pkt.mincost[i] = dt3.costs[MYID][i];
		for ( i = 0; i < 4; i++)
		{
			/* Send distance vector only to my neighbours */
			if ( i == MYID || connectcosts3[i] == INFINITY)
				continue; // if node is myself or a non-neighbour
			pkt.destid = i;
			tolayer2(pkt);
		}
	}
}


void printdt3(struct distance_table *dtptr)
{
  printf("               dest     \n");
  printf("   D3 |    0    1    2    3 \n");
  printf("  ----|------------------------\n");
  printf("     0|  %3d   %3d   %3d   %3d\n",dtptr->costs[0][0],
  	 dtptr->costs[0][1],dtptr->costs[0][2], dtptr->costs[0][3]);
  printf("     1|  %3d   %3d   %3d   %3d\n",dtptr->costs[1][0],
	 dtptr->costs[1][1],dtptr->costs[1][2], dtptr->costs[1][3]);
  printf("via  2|  %3d   %3d   %3d   %3d\n",dtptr->costs[2][0],
	 dtptr->costs[2][3],dtptr->costs[2][2], dtptr->costs[2][3]);
  printf("     3|  %3d   %3d   %3d   %3d\n",dtptr->costs[3][0],
	 dtptr->costs[3][1],dtptr->costs[3][2], dtptr->costs[3][3]);
  printf("\n");
}







