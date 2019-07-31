package DynamicArrays;

public class DynamicArr {
	private int[] data = new int[10];
	private int maxindex = -1;
	
	public void add(int element){
		if(maxindex < sizeof() -1){
			doublelength();
		}
		data[++maxindex] = element;
	}
	
	public int sizeof(){
		return maxindex;
	}
	
	public void add(int element, int index) throws IndexOutOfBound{
		if(index < 0 || index > maxindex +1){
			IndexOutOfBound e = new IndexOutOfBound();
			throw e;
		}
		for(int i = maxindex; i >= index; i--){
			data[i+1] = data[i];
		}
		data[index] = element;
		++maxindex;
	}
	
	public void remove(int index) throws IndexOutOfBound{
		if(index < 0 || index > maxindex){
			IndexOutOfBound e = new IndexOutOfBound();
			throw e;
		}
		for(int i = index; i < maxindex; i++){
			data[i] = data[i+1];
		}
	}
	
	public void doublelength(){
		int[] temp = new int[data.length*2];
		for(int i = 0; i < data.length; i++){
			temp[i] = data[i];
		}
		temp = data;
	}
}
