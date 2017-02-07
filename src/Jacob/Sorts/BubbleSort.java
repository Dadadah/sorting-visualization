package Jacob.Sorts;

import Jacob.*;

public class BubbleSort implements Runnable{
	
	private Integer[] toBeSorted;
	private VisualizerFrame frame;
	private boolean fast;
	
	public BubbleSort(Integer[] toBeSorted, VisualizerFrame frame, boolean fast) {
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
			frame.reDrawArray(toBeSorted);
			try {
				Thread.sleep(SortingVisualizer.sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (!swapped) break;
		}
	}
	
	public void sortSlow() {
		int temp = 0;
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
				frame.reDrawArray(toBeSorted, j, j+1);
				try {
					Thread.sleep(SortingVisualizer.sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (!swapped) break;
		}
	}

}
