package heap;

public class Heap {
	HeapNode array[];
	int count;
	public Heap(int N) {
		array = new HeapNode[N];
		count = 0;
	}
	
	boolean isEmpty() {
		return count == 0;
	}

	
	void swapNode(int index1,int index2) {
		HeapNode tmpNode;
		tmpNode = array[index1];
		array[index1] = array[index2];
		array[index2] = tmpNode;
	}
	
	void percolateDown(int no) {
		int left,right;
		left = 2 * no + 1;
		right = 2 * no + 2;
		while((left<count && array[no].data<array[left].data)|| (right<count&&array[no].data<array[right].data)) {
			if(right >= count || array[left].data>array[right].data) {
				swapNode(no,left);
				no = left;
			}
			else {
				swapNode(no,right);
				no = right;
			}
			left = 2 * no + 1;
			right = 2 * no + 2;
		}
	}
	
	HeapNode deleteMax() {
		HeapNode tmp;
		tmp = array[0];
		array[0] = array[count -1];
		percolateDown(0);
		count--;
		return tmp;
	}
	
	void insert(HeapNode node) {
		count++;
		array[count-1]= node;
		percolateDown(count-1);
	}
	
	void percolateUp(int no) {
		int parent;
		parent = (no-1)/2;
		while(parent>=0 && array[parent].data<array[no].data) {
			swapNode(parent,no);
			no = parent;
			parent = (no-1)/2;
		}
	}
	
	int search(int name) {
		int i;
		for(i = 0; i< count;i++) {
			if(array[i].name == name) {
				return i;
			}
		}
		return -1;
	}
	
	
	void update(int k,int newValue) {
		int oldValue = array[k].data;
		array[k].data = newValue;
		if(oldValue > newValue) {
			percolateDown(k);
		}
		else {
			percolateUp(k);
		}
	}
	
	
	
}
