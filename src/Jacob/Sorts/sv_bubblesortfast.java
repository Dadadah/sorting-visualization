package Jacob.Sorts;

import Jacob.sv_main;

public class sv_bubblesortfast implements Runnable{
	
	public void run() {
		int temp = 0;
		Integer[] toBeSorted = sv_main.toBeSorted;
		boolean swapped = false;
		for(int i = 0; i<toBeSorted.length-1; i++){
			swapped = false;
			for(int j = 1; j<toBeSorted.length-i; j++){
				if (toBeSorted[j-1]> toBeSorted[j]){
					temp = toBeSorted[j-1];
					toBeSorted[j-1] = toBeSorted[j];
					toBeSorted[j]= temp;
					swapped = true;
				}
			}
			sv_main.frame.reDrawArray(toBeSorted);
			try {
				Thread.sleep(sv_main.sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (!swapped) break;
		}
		sv_main.isSorting=false;
	}

}
