package Jacob.Sorts;

import Jacob.sv_main;

public class sv_shellsort implements Runnable{
	
	public void run() {
		int temp = 0;
		Integer[] toBeSorted = sv_main.toBeSorted;
		int j = 0;
		
		for(int gap = toBeSorted.length/2; gap > 0; gap/=2){
			for(int i = gap; i<toBeSorted.length; i++){
				temp = toBeSorted[i];
				for (j = i; j>=gap && temp<toBeSorted[j-gap]; j -= gap){
					toBeSorted[j] = toBeSorted[j-gap];
					sv_main.frame.reDrawArray(toBeSorted, i, j);
					try {
						Thread.sleep(sv_main.sleep);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				toBeSorted[j] = temp;
			}
		}
		
		sv_main.isSorting=false;
	}
}
