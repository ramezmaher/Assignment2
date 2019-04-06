
public class MySpecialLinkedListUtils {
public static int counter(LinkedListNode n) {
	LinkedListNode h=n;
	int count=0;
	while (h!=null) {
		count++;
		h=h.next;
	}
	return count;
}
 public static double[] summary(LinkedListNode n) {
	 LinkedListNode h = n;
	 double arr[] = new double [5];
	 double sum=0,min=n.getValue(),max=n.getValue(),avr=0,mid=n.getValue();
	 int count=0;
	 while (h.next != null) {
		 sum+=h.getValue();
		 if (h.getValue() >max) {
			 max = h.getValue();
		 }
		 else if (h.getValue() < min) {
			 min = h.getValue();
		 }
		 h=h.next;
		 count++;
	 }
	 sum+=h.getValue();
	 if (h.getValue() >max) {
		 max = h.getValue();
	 }
	 else if (h.getValue() < min) {
		 min = h.getValue();
	 }
	 count++;
	 h=n;
	 while (h.next != null) {
		 avr+= ((h.getValue()*1.0)/(count*1.0));
		 h=h.next;
	 }
	 avr+=((h.getValue()*1.0)/(count*1.0));
	 h=n;
	 mid=getMiddle(h).value;
	 arr[0]=sum;
	 arr[1]=avr;
	 arr[2]=mid;
	 arr[3]=max;
	 arr[4]=min;
	 return arr;
 }
public static LinkedListNode reverse(LinkedListNode n) {
	LinkedListNode temp,cur,prev;
	cur=n;
	prev=null;
	temp=null;
	while(cur!=null) {
		temp=cur.next;
		cur.next=prev;
		prev=cur;
		cur=temp;
	}
	n=prev;
	return n;
} 
public static LinkedListNode evenIndexedElements(LinkedListNode m) {
	LinkedListNode cur,temp;
	cur=m;
	temp=cur.next;
	while(temp !=null && temp.next != null) {
		cur.next=temp.next;
		cur=temp.next;
		temp=cur.next;
	}
	if (temp.next == null) {
		cur.next =null;
	}
	cur=m;
	return cur; 
}
public static LinkedListNode insertionSort(LinkedListNode n) {
	LinkedListNode cur = n,temp = null;
	   while(cur != null && temp != n )
	   {
	      LinkedListNode h = cur;
	      for( ; h.next != temp;  h = h.next)
	      {
	        if(h.value >= h.next.value)
	        {
	          int val = h.value;
	          h.value = h.next.value;
	          h.next.value = val;
	        }
	      }
	      temp = h;
	      cur = n;
	   }
	   return n;
	
}
public static LinkedListNode sortedMerge(LinkedListNode a, LinkedListNode b)  
{ 
    LinkedListNode result = null; 
    if (a == null) 
        return b; 
    if (b == null) 
        return a; 
    if (a.getValue() <= b.getValue())  
    { 
        result = a; 
        result.next = sortedMerge(a.next, b); 
    }  
    else 
    { 
        result = b; 
        result.next = sortedMerge(a, b.next); 
    } 
    return result; 

} 
public static LinkedListNode mergeSort(LinkedListNode h)  
{ 
    if (h == null || h.next == null) 
    { 
        return h; 
    } 
    LinkedListNode middle = getMiddle(h); 
    LinkedListNode nextofmiddle = middle.next;  
    middle.next = null;
    LinkedListNode left = mergeSort(h); 
    LinkedListNode right = mergeSort(nextofmiddle);  
    LinkedListNode sortedlist = sortedMerge(left, right); 
    return sortedlist; 
}  
public static LinkedListNode getMiddle(LinkedListNode h)  
{ 
    if (h == null) 
        return h; 
    LinkedListNode fastptr = h.next; 
    LinkedListNode slowptr = h;  
    while (fastptr != null) 
    { 
        fastptr = fastptr.next; 
        if(fastptr!=null) 
        { 
            slowptr = slowptr.next; 
            fastptr=fastptr.next; 
        } 
    } 
    return slowptr; 
} 
public static LinkedListNode removeCentralNode(LinkedListNode n) {
	int count = counter(n),v=0;
	LinkedListNode h=n,temp = null;
	if (count %2 == 0 ) {
		while (v<((count/2)-2)) {
			h=h.next;
			v++;
		}
		temp = h.next.next;
		h.next=temp;
		return n;
}
	else {
		while (v<((count/2)-1)) {
			h=h.next;
			v++;
		}
		temp = h.next.next;
		h.next=temp;
		return n;
	}
}
public static boolean palindrome(LinkedListNode n) {
	int count = counter(n),v=count-1;
	LinkedListNode z=n;
	int arr[]= new int [count];
	for (int i=0;i<count;i++) {
		arr[i] = z.getValue();
		z=z.next;
	}
		for (int i=0; i<(count/2);i++) {
			if (arr[i] != arr[v])
				return false;
			v--;
		}
		return true;
}
}