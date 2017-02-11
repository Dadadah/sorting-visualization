package Jacob.Sorts;

import java.util.ArrayList;

import Jacob.SortingVisualizer;
import Jacob.VisualizerFrame;

public class RadixSort implements Runnable{
	
	private Integer[] toBeSorted;
	private VisualizerFrame frame;
	private boolean lsd;
	
	public RadixSort(Integer[] toBeSorted, VisualizerFrame frame, boolean lsd) {
		this.toBeSorted = toBeSorted;
		this.frame = frame;
		this.lsd = lsd;
	}
	
	public void run() {
		if (lsd) radixlsd(toBeSorted, 1);
		else radixmsd(toBeSorted, findDigit(toBeSorted));
		SortingVisualizer.isSorting=false;
	}
	
	private void radixlsd(Integer[] x, int digit){
		ArrayList<Integer>[] buckets = new ArrayList[10];
		for(int i = 0; i<10; i++){
			buckets[i] = new ArrayList<Integer>();
		}
		int theDig = 0;
		int maxI = 0;
		for(int i = 0; i<x.length; i++){
			theDig = (int) (x[i]%Math.pow(10, digit));
			for(int t = 0; t<digit-1; t++){
				theDig/=10;
			}
			if (x[i] > maxI) maxI = x[i];
			frame.reDrawArray(x, -1, -1, i);
			try {
				Thread.sleep(SortingVisualizer.sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			buckets[theDig].add(x[i]);
		}
		ArrayList<Integer> finalList = new ArrayList<>();
		for(int i = 0; i<10; i++){
			finalList.addAll(buckets[i]);
		}
		
		Integer[] y = finalList.toArray(new Integer[0]);
		
		frame.reDrawArray(y);
		try {
			Thread.sleep(SortingVisualizer.sleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (maxI < Math.pow(10, digit)) return;

		radixlsd(y, digit+1);
		
	}
	
	private void radixmsd(Integer[] x, int digit){
		ArrayList<Integer>[] buckets = new ArrayList[10];
		for(int i = 0; i<10; i++){
			buckets[i] = new ArrayList<Integer>();
		}
		int theDig = 0;
		for(int i = 0; i<x.length; i++){
			theDig = (int) (x[i]%Math.pow(10, digit));
			for(int t = 0; t<digit-1; t++){
				theDig/=10;
			}
			frame.reDrawArray(x, -1, -1, i);
			try {
				Thread.sleep(SortingVisualizer.sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			buckets[theDig].add(x[i]);
		}
		ArrayList<Integer> finalList = new ArrayList<>();
		for(int i = 0; i<10; i++){
			finalList.addAll(buckets[i]);
		}
		
		Integer[] y = finalList.toArray(new Integer[0]);
		
		frame.reDrawArray(y);
		try {
			Thread.sleep(SortingVisualizer.sleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (digit == 1) return;
		
		int beginning = 0;
		
		for (int i = 0; i < 10; i++) {
			y = radixmsd(y, digit-1, beginning, beginning + buckets[i].size());
			beginning += buckets[i].size();
		}
	}
	
	private Integer[]  radixmsd(Integer[] x, int digit, int begin, int end){
		ArrayList<Integer>[] buckets = new ArrayList[10];
		for(int i = 0; i<10; i++){
			buckets[i] = new ArrayList<Integer>();
		}
		int theDig = 0;
		for(int i = begin; i<end; i++){
			theDig = (int) (x[i]%Math.pow(10, digit));
			for(int t = 0; t<digit-1; t++){
				theDig/=10;
			}
			frame.reDrawArray(x, -1, -1, i);
			try {
				Thread.sleep(SortingVisualizer.sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			buckets[theDig].add(x[i]);
		}
		ArrayList<Integer> finalList = new ArrayList<>();
		
		for (int i = 0; i < begin; i++) {
			finalList.add(x[i]);
		}
		
		for(int i = 0; i<10; i++){
			finalList.addAll(buckets[i]);
		}
		
		for (int i = end; i < x.length; i++) {
			finalList.add(x[i]);
		}
		
		Integer[] y = finalList.toArray(new Integer[0]);
		
		frame.reDrawArray(y);
		try {
			Thread.sleep(SortingVisualizer.sleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (digit == 1) return y;
		
		int beginning = begin;
		
		for (int i = 0; i < 10; i++) {
			y = radixmsd(y, digit-1, beginning, beginning + buckets[i].size());
			beginning += buckets[i].size();
		}
		
		return y;
	}
	
	private int findDigit(Integer[] x) {
		int max = Integer.MIN_VALUE;
		int digit = 1;
		for (int i : x) {
			if (i > max) max = i;
		}
		while (max > 10) {
			max = max/10;
			digit++;
		}
		return digit;
	}

}
