package Jacob.Sorts;

import Jacob.sv_main;

public class sv_mergesort implements Runnable{
	
	public void run() {
		Integer[] toBeSorted = sv_main.toBeSorted;
		inPlaceSort(toBeSorted);
		sv_main.isSorting=false;
	}
	public void inPlaceSort ( Integer[] x )
	   {  inPlaceSort (x, 0, x.length-1);  }

   private void inPlaceSort ( Integer[] x, int first, int last )
   {
      int mid, lt, rt;
      int tmp;

      if ( first >= last ) return;

      mid = (first + last) / 2;

      inPlaceSort (x, first, mid);
      inPlaceSort (x, mid+1, last);

      lt = first;  rt = mid+1;
      // One extra check:  can we SKIP the merge?
      if ( x[mid] <= x[rt])
         return;

      while (lt <= mid && rt <= last)
      {
         // Select from left:  no change, just advance lt
         if ( x[lt] <= x[rt])
            lt++;
         // Select from right:  rotate [lt..rt] and correct
         else
         {
            tmp = x[rt];     // Will move to [lt]
            for (int i = rt-lt;i>0; i--){
            	x[lt+i] = x[lt+i-1];
            }
            x[lt] = tmp;
            // EVERYTHING has moved up by one
            lt++;  mid++;  rt++;
         }
         sv_main.frame.reDrawArray(x, mid, rt, lt);
			try {
				Thread.sleep(sv_main.sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
      }
      // Whatever remains in [rt..last] is in place
   }
}
