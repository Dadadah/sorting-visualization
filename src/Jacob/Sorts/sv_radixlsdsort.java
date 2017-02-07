package Jacob.Sorts;

import java.util.ArrayList;

import Jacob.sv_main;

public class sv_radixlsdsort implements Runnable{
	
	public void run() {
		Integer[] toBeSorted = sv_main.toBeSorted;
		radixlsd(toBeSorted, 1);
		sv_main.isSorting=false;
	}
	
	private void radixlsd(Integer[] x, int digit){
		ArrayList<Integer>[] buckets = new ArrayList[10];
		for(int i = 0; i<10; i++){
			buckets[i] = new ArrayList<Integer>();
		}
		int theDig = 0;
		int maxI = 0;
		for(int i = 0; i<x.length; i++){
			theDig = (int) (x[i]%Math.pow(10, digit));
			for(int t = 0; t<digit-1; t++){
				theDig/=10;
			}
			if (x[i] > maxI) maxI = x[i];
			sv_main.frame.reDrawArray(x, -1, -1, i);
			try {
				Thread.sleep(sv_main.sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			buckets[theDig].add(x[i]);
		}
		ArrayList<Integer> finalList = new ArrayList<>();
		for(int i = 0; i<10; i++){
			finalList.addAll(buckets[i]);
		}
		
		Integer[] y = finalList.toArray(new Integer[0]);
		
		sv_main.frame.reDrawArray(y);
		try {
			Thread.sleep(sv_main.sleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (maxI< Math.pow(10, digit)) return;

		radixlsd(y, digit+1);
		
	}

}
