package Jacob.Sorts;

import Jacob.sv_main;

public class sv_selectionsortfast implements Runnable{
	
	public void run() {
		int temp = 0;
		Integer[] toBeSorted = sv_main.toBeSorted;
		int first = 0;
		for(int i = 0; i<toBeSorted.length; i++){
			first = i;
			for(int j = toBeSorted.length-1; j>i; j--){
				
				if (toBeSorted[j] <= toBeSorted[first]){
					first = j;
				}				
			}
			sv_main.frame.reDrawArray(toBeSorted);
			try {
				Thread.sleep(sv_main.sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			temp = toBeSorted[i];
			toBeSorted[i] = toBeSorted[first];
			toBeSorted[first]= temp;
		}
		sv_main.isSorting=false;
	}

}
