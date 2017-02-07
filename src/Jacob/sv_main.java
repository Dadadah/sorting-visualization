package Jacob;

import Jacob.Sorts.*;

public class sv_main {

	public static sv_frame frame;
	
	public static Integer[] toBeSorted;
	private static Thread sortingThread;
	public static boolean isSorting = false;
	public static int count = 100;
	public static int sleep = 20;
	public static int scale = 1;
	public static int blockSize = (int) Math.max(Math.floor(400/count), 1);
	
	public static void main(String[] args) {

		frame = new sv_frame();
		reset(true);
		frame.setLocationRelativeTo(null);
	}
	
	public static void reset() {
		reset(false);
	}
	
	public static void reset(boolean init){
		if (isSorting) return;
		toBeSorted = new Integer[count];
		blockSize = (int) Math.floor(400/count);
		for(int i = 0; i<toBeSorted.length; i++){
			toBeSorted[i] = (int) (count*Math.random()*scale);
		}
		if (init) {
			frame.preDrawArray(toBeSorted);
		} else {
			frame.reDrawArray(toBeSorted);
		}
	}
	
	public static void startSort(String type){
		
		if (sortingThread == null || !isSorting){
			
			reset(true);
			
			isSorting = true;

			switch(type){
			case "Bubble":
				sortingThread = new Thread(new sv_bubblesort());
				break;

			case "Selection":
				sortingThread = new Thread(new sv_selectionsort());
				break;

			case "Insertion":
				sortingThread = new Thread(new sv_insertionsort());
				break;
				
			case "Gnome":
				sortingThread = new Thread(new sv_gnomesort());
				break;

			case "Merge":
				sortingThread = new Thread(new sv_mergesort());
				break;
				
			case "Radix":
				sortingThread = new Thread(new sv_radixlsdsort());
				break;
				
			case "Shell":
				sortingThread = new Thread(new sv_shellsort());
				break;
				
			case "Bubble(fast)":
				sortingThread = new Thread(new sv_bubblesortfast());
				break;

			case "Selection(fast)":
				sortingThread = new Thread(new sv_selectionsortfast());
				break;

			case "Insertion(fast)":
				sortingThread = new Thread(new sv_insertionsortfast());
				break;
				
			case "Gnome(fast)":
				sortingThread = new Thread(new sv_gnomesortfast());
				break;
				
			default:
				isSorting = false;
				return;
			}
			
			sortingThread.start();
			
		}
		
	}

}
