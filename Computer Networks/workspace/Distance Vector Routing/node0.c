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
#define MYID 0
int connectcosts0[4] = { 0,  1,  3, 7 };

/*
 * cost[i][j]: i represents 'via', j represents the destination
 *             from '0'
 */
struct distance_table 
{
  int costs[4][4];
} dt0;


/* students to write the following two routines, and maybe some others */

void rtinit0() 
{
	int i, j;
	struct rtpkt pkt;
	void tolayer2(struct rtpkt );

	printf("Node %d: Initializing at %f\n", MYID, clocktime);

	/* Initializing my distance vector */
	for (i = 0; i < 4; i++)
		dt0.costs[MYID][i] = connectcosts0[i];

	/* Initializing distance vector of my neighbours*/
	for (i = 0; i < 4; i++)
	{
		if ( i == MYID)
			continue;
		for (j = 0; j < 4; j++)
			dt0.costs[i][j] = INFINITY;
	}

	/* Prepare a routing packet and send my neighbours my distance vector
	 * in it */
	pkt.sourceid = MYID;
	for (i = 0; i < 4; i++)
		pkt.mincost[i] = dt0.costs[MYID][i];
	for ( i = 0; i < 4; i++)
	{
		/* Send my distance vector only to my neighbours */
		if ( i == MYID || connectcosts0[i] == INFINITY)
			continue; // if node is myself or a non-neighbour
		pkt.destid = i;
		tolayer2(pkt);
	}
}


void rtupdate0(struct rtpkt *rcvdpkt)
{
	int j, updated = NO, via;
	void printdt0(struct distance_table*);
	printf("Node %d: Distance vector, [", MYID);
	for ( j = 0; j < 4; j++)
		printf("%d ", rcvdpkt->mincost[j]);
	printf("], received from %d at %f\n", rcvdpkt->sourceid, clocktime);

	/* update the distance table using received vector*/
	via = rcvdpkt->sourceid;
	for (j= 0; j < 4; j++)
	{
		dt0.costs[via][j] = connectcosts0[via] + rcvdpkt->mincost[j];

		/* normalize the value back to INFINITY */
		if (dt0.costs[via][j] > INFINITY)
			dt0.costs[via][j] = INFINITY;
	}

	/* update the distance vector of '0' */
	updated = NO;
	for (j = 0; j < 4; j++)
		if (dt0.costs[MYID][j] > dt0.costs[via][j])
		{
			dt0.costs[MYID][j] = dt0.costs[via][j];
			updated = YES;
		}

	if (updated)
	{
		struct rtpkt pkt;
		int i;
		void tolayer2(struct rtpkt );
		printf("	Distance vector updated to [");
		for ( j = 0; j < 4; j++)
			printf("%d ", dt0.costs[MYID][j]);
		printf("]\n");
		printdt0(&dt0);
		pkt.sourceid = MYID;
		for (i = 0; i < 4; i++)
			pkt.mincost[i] = dt0.costs[MYID][i];
		for ( i = 0; i < 4; i++)
		{
			/* Send distance vector only to my neighbours */
			if ( i == MYID || connectcosts0[i] == INFINITY)
				continue; // if node is myself or a non-neighbour
			pkt.destid = i;
			tolayer2(pkt);
		}
	}
}


void printdt0(struct distance_table *dtptr)
{
  printf("               dest     \n");
  printf("   D0 |    0    1    2    3 \n");
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

void linkhandler0(int linkid, int newcost)

/* called when cost from 0 to linkid changes from current value to newcost*/
/* You can leave this routine empty if you're an undergrad. If you want */
/* to use this routine, you'll need to change the value of the LINKCHANGE */
/* constant definition in prog3.c from 0 to 1 */
	
{
}

