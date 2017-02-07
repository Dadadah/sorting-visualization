package Jacob.Sorts;

import Jacob.sv_main;

public class sv_gnomesortfast implements Runnable{
	
	public void run() {
		int temp = 0;
		Integer[] toBeSorted = sv_main.toBeSorted;
		for(int i = 1; i<toBeSorted.length-1; i++){
			for(int j = i+1; j>0; j--){
				if (toBeSorted[j] < toBeSorted[j-1]){
					temp = toBeSorted[j];
					toBeSorted[j] = toBeSorted[j-1];
					toBeSorted[j-1] = temp;
				}else{
					break;
				}
			}
			sv_main.frame.reDrawArray(toBeSorted);
			try {
				Thread.sleep(sv_main.sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		sv_main.isSorting=false;
	}

}
