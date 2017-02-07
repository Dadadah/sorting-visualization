package Jacob.Sorts;

import Jacob.SortingVisualizer;

public class ShellSort implements Runnable{
	
	public void run() {
		int temp = 0;
		Integer[] toBeSorted = SortingVisualizer.toBeSorted;
		int j = 0;
		
		for(int gap = toBeSorted.length/2; gap > 0; gap/=2){
			for(int i = gap; i<toBeSorted.length; i++){
				temp = toBeSorted[i];
				for (j = i; j>=gap && temp<toBeSorted[j-gap]; j -= gap){
					toBeSorted[j] = toBeSorted[j-gap];
					SortingVisualizer.frame.reDrawArray(toBeSorted, i, j);
					try {
						Thread.sleep(SortingVisualizer.sleep);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				toBeSorted[j] = temp;
			}
		}
		
		SortingVisualizer.isSorting=false;
	}
}
