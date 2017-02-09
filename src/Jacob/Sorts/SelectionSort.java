package Jacob.Sorts;

import Jacob.*;

public class SelectionSort implements Runnable{
	
	private Integer[] toBeSorted;
	private VisualizerFrame frame;
	private boolean fast;
	
	public SelectionSort(Integer[] toBeSorted, VisualizerFrame frame, boolean fast) {
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
	
	public void sortFast(){
		int temp = 0;
		int selected = 0;
		for(int i = 0; i<toBeSorted.length; i++){
			selected = i;
			for(int j = toBeSorted.length-1; j>i; j--){
				if (toBeSorted[j] <= toBeSorted[selected]){
					selected = j;
				}				
			}
			frame.reDrawArray(toBeSorted);
			try {
				Thread.sleep(SortingVisualizer.sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			temp = toBeSorted[i];
			toBeSorted[i] = toBeSorted[selected];
			toBeSorted[selected]= temp;
		}
	}
	
	public void sortSlow() {
		int temp = 0;
		int selected = 0;
		for(int i = 0; i<toBeSorted.length; i++){
			selected = i;
			for(int j = toBeSorted.length-1; j>i; j--){
				
				if (toBeSorted[j] <= toBeSorted[selected]){
					selected = j;
				}
				frame.reDrawArray(toBeSorted, selected, j-1);
				try {
					Thread.sleep(SortingVisualizer.sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
			}
			temp = toBeSorted[i];
			toBeSorted[i] = toBeSorted[selected];
			toBeSorted[selected]= temp;
		}
		frame.reDrawArray(toBeSorted);
	}

}
