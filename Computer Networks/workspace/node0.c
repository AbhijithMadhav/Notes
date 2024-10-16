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
extern int INFINITY;

#define MYID 0

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

	/* Initializing my distance vector */
	dt0.costs[MYID][0] = 0;
	dt0.costs[MYID][1] = 1;
	dt0.costs[MYID][2] = 3;
	dt0.costs[MYID][3] = 7;

	/* Initializing distance vector of my neighbours*/
	for (i = 1; i < 4; i++)
		for (j = 0; j < 4; j++)
			dt0.costs[i][j] = INFINITY;

	/* Prepare a routing packet and send my neighbours my distance vector
	 * in it */
	pkt.sourceid = 0;
	for (i = 0; i < 4; i++)
		pkt.mincost[i] = dt0.costs[MYID][i];
	for ( i = 1; i < 4; i++)
	{
		pkt.destid = i;
		tolayer2(pkt);
	}
}


void rtupdate0(struct rtpkt *rcvdpkt)
{
	int i;
	for (i = 1; i < 4; i++) // for each neighour
	{
		if (rcvdpkt->mincost[i] + dt0.costs[MYID][rcvdpkt->sourceid] < dt0.costs[MYID][i])
			dt0.costs[MYID][i] = rcvdpkt->mincost[i] + dt0.costs[MYID][rcvdpkt->sourceid];
	}

}


void printdt0(struct distance_table *dtptr)
{
  printf("                via     \n");
  printf("   D0 |    1     2    3 \n");
  printf("  ----|-----------------\n");
  printf("     1|  %3d   %3d   %3d\n",dtptr->costs[1][1],
	 dtptr->costs[1][2],dtptr->costs[1][3]);
  printf("dest 2|  %3d   %3d   %3d\n",dtptr->costs[2][1],
	 dtptr->costs[2][2],dtptr->costs[2][3]);
  printf("     3|  %3d   %3d   %3d\n",dtptr->costs[3][1],
	 dtptr->costs[3][2],dtptr->costs[3][3]);
}

void linkhandler0(int linkid, int newcost)

/* called when cost from 0 to linkid changes from current value to newcost*/
/* You can leave this routine empty if you're an undergrad. If you want */
/* to use this routine, you'll need to change the value of the LINKCHANGE */
/* constant definition in prog3.c from 0 to 1 */
	
{
}

