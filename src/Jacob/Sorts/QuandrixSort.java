package Jacob.Sorts;

import Jacob.SortingVisualizer;

public class QuandrixSort implements Runnable{

	public void run() {
		int temp = 0;
		Integer[] toBeSorted = SortingVisualizer.toBeSorted;
		int i = 0;

		if (toBeSorted.length % 3 == 0) {
			SortingVisualizer.isSorting=false;
			return;
		}

		boolean swapped = false;
		int doubleCheck = 0;
		boolean end = false;
		while(doubleCheck < 3){
			if (end) {
				swapped = false;
				end = false;
			}

			int j = i + 1;
			int k = j + 1;

			if (k < toBeSorted.length) {
				if (toBeSorted[k] < toBeSorted[j]) {
					temp = toBeSorted[j];
					toBeSorted[j] = toBeSorted[k];
					toBeSorted[k] = temp;
					swapped = true;
				}
				SortingVisualizer.frame.reDrawArray(toBeSorted, k, j);
				try {
					Thread.sleep(SortingVisualizer.sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (j < toBeSorted.length) {
				if (toBeSorted[j] < toBeSorted[i]) {
					temp = toBeSorted[i];
					toBeSorted[i] = toBeSorted[j];
					toBeSorted[j] = temp;
					swapped = true;
				}
				SortingVisualizer.frame.reDrawArray(toBeSorted, j, i);
				try {
					Thread.sleep(SortingVisualizer.sleep);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (k < toBeSorted.length) {
					if (toBeSorted[k] < toBeSorted[j]) {
						temp = toBeSorted[j];
						toBeSorted[j] = toBeSorted[k];
						toBeSorted[k] = temp;
						swapped = true;
					}
					SortingVisualizer.frame.reDrawArray(toBeSorted, k, j);
					try {
						Thread.sleep(SortingVisualizer.sleep);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

			i += 3;
			if (i >= toBeSorted.length) {
				i = i % toBeSorted.length;
				end = true;
				if (!swapped) {
					doubleCheck++;
				} else {
					doubleCheck = 0;
				}
			}
		}

		SortingVisualizer.isSorting=false;
	}
}
