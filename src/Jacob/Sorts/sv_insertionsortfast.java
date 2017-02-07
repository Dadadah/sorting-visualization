package Jacob.Sorts;

import Jacob.sv_main;

public class sv_insertionsortfast implements Runnable{
	
	public void run() {
		int temp = 0;
		Integer[] toBeSorted = sv_main.toBeSorted;
		int insert = 0;
		for(int i = 1; i<toBeSorted.length; i++){
			insert = i;
			for(int j = i-1; j>=0; j--){
				if (toBeSorted[i] < toBeSorted[j]){
					insert = j;
					if (j == 0){
						break;
					}
				}else{
					break;
				}
				
			}
			temp = toBeSorted[i];
			for (int j = i; j>insert; j--){
				toBeSorted[j] = toBeSorted[j-1];
			}
			toBeSorted[insert] = temp;
			sv_main.frame.reDrawArray(toBeSorted, i);
			try {
				Thread.sleep(sv_main.sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		sv_main.isSorting=false;
	}

}
