package Jacob.Sorts;

import Jacob.*;

public class InsertionSort implements Runnable{
	
	private Integer[] toBeSorted;
	private VisualizerFrame frame;
	private boolean fast;
	
	public InsertionSort(Integer[] toBeSorted, VisualizerFrame frame, boolean fast) {
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
			frame.reDrawArray(toBeSorted, i);
			try {
				Thread.sleep(SortingVisualizer.sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void sortSlow() {
		int temp = 0;
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
				frame.reDrawArray(toBeSorted, i, insert);
				try {
					Thread.sleep(SortingVisualizer.sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			temp = toBeSorted[i];
			for (int j = i; j>insert; j--){
				toBeSorted[j] = toBeSorted[j-1];
			}
			toBeSorted[insert] = temp;
		}
		frame.reDrawArray(toBeSorted);
	}
}
