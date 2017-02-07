package Jacob;

import Jacob.Sorts.*;

public class sv_main {

	public static sv_frame frame;
	
	public static Integer[] toBeSorted;
	private static Thread sortingThread;
	public static boolean isSorting = false;
	public static int count = 30;
	public static int sleep = 20;
	public static int scale = 1;
	public static final int blockSize = (int) Math.floor(400/count);
	
	public static void main(String[] args) {

		frame = new sv_frame();
		toBeSorted = new Integer[count];
		init();
		frame.setLocationRelativeTo(null);
	}
	
	public static void init(){
		if (isSorting) return;
		for(int i = 0; i<toBeSorted.length; i++){
			toBeSorted[i] = (int) (Math.random()*count*(Math.random()*scale));
		}
		frame.preDrawArray(toBeSorted);
	}
	
	public static void reset(){
		if (isSorting) return;
		for(int i = 0; i<toBeSorted.length; i++){
			toBeSorted[i] = (int) (count*Math.random()*scale);
		}
		frame.reDrawArray(toBeSorted);
	}
	
	public static void startSort(String type){
		
		if (sortingThread == null || !isSorting){
			
			reset();
			
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
