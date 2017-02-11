package Jacob.Sorts;

import Jacob.*;

public class GnomeSort implements Runnable{
	
	private Integer[] toBeSorted;
	private VisualizerFrame frame;
	private boolean fast;
	
	public GnomeSort(Integer[] toBeSorted, VisualizerFrame frame, boolean fast) {
		this.toBeSorted = toBeSorted;
		this.frame = frame;
		this.fast = fast;
	}
	
	public void run() {
		if (fast) {
			sortFast();
		} else {
			sortSlow();
		}
		SortingVisualizer.isSorting=false;
	}
	
	public void sortFast() {
		int temp = 0;
		for(int i = 0; i<toBeSorted.length-1; i++){
			for(int j = i+1; j>0; j--){
				if (toBeSorted[j] < toBeSorted[j-1]){
					temp = toBeSorted[j];
					toBeSorted[j] = toBeSorted[j-1];
					toBeSorted[j-1] = temp;
				}else{
					break;
				}
			}
			frame.reDrawArray(toBeSorted);
			try {
				Thread.sleep(SortingVisualizer.sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void sortSlow() {
		int temp = 0;
		for(int i = 0; i<toBeSorted.length-1; i++){
			for(int j = i+1; j>0; j--){
				if (toBeSorted[j] < toBeSorted[j-1]){
					temp = toBeSorted[j];
					toBeSorted[j] = toBeSorted[j-1];
					toBeSorted[j-1] = temp;
					frame.reDrawArray(toBeSorted, j, j-1);
					try {
						Thread.sleep(SortingVisualizer.sleep);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else{
					break;
				}
			}
		}
	}
}
