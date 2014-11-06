#!/bin/bash

best_iamat=99999
best_damat=99999
for n_ichips in 1 2 4 8
do
    icache_size=`expr 32 \* 1024 \* $n_ichips`
	for n_dchips in 1 2 4 8
	do
		dcache_size=`expr 32 \* 1024 \* $n_dchips`
		for iblock_size in 16 32 64 128 256
		do
			n_iblocks=`expr $icache_size / $iblock_size`
			for dblock_size in 16 32 64 128 256
			do
				n_dblocks=`expr $dcache_size / $dblock_size`
				for iassociativity in $n_iblocks 1 16 32 64 128
				do
			        access_time_for_iassoc=0
			        [ $iassociativity -eq $n_iblocks ] && access_time_for_iassoc=1
					for dassociativity in $n_dblocks 1 16 32 64 128
					do
				        access_time_for_dassoc=0
				        [ $dassociativity -eq $n_dblocks ] && access_time_for_dassoc=1
						miss_rate=`./d4-7/dineroIV -informat d -l1-isize $icache_size \
							       l1-dsize $dcache_size -l1-ibsize $iblock_size \
								   -l1-dbsize $dblock_size -l1-dassoc $dassociativity \
								   -l1-iassoc $iassociativity < cc1.din  \
								   | awk '/ Demand miss rate/ { print $4 }'`
						imiss_rate=`echo $miss_rate | cut -f1 -d" "`
						dmiss_rate=`echo $miss_rate | cut -f2 -d" "`
                       i_amat=`bc << END
((1 - $imiss_rate) * (1.5 + ($access_time_for_iassoc * 0.2))) + ($imiss_rate * (8 + 2 * $iblock_size))
END
`
						d_amat=`bc << END
((1 - $dmiss_rate) * (1.5 + ($access_time_for_dassoc * 0.2))) + ($dmiss_rate * (8 + 2 * $dblock_size))
END
`

						echo i cache size: $icache_size
						echo d cache size: $dcache_size
						echo i block size: $iblock_size
						echo d block size: $dblock_size
						echo associativity of instruction cache: $iassociativity
						echo associativity of data cache: $dassociativity
						echo i miss rate: $imiss_rate
						echo d miss rate: $dmiss_rate
						echo Average memory access time of icache: $i_amat ns
						echo Average memory access time of dcache: $d_amat ns
	                    echo ""
					done
				done
			done
		done
	done
done
