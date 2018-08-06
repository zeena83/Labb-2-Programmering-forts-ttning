
import java.util.HashMap;

public class Model {
	
	 HashMap<Integer,Long> memory = new HashMap<Integer,Long>();
	 
	 Integer value;
	 Long result;
	 
	
	 
	 
	
	 public long computePower(int value){
		 if(value <= 0 )
			 return 1;
		 else{
			 return 2 * computePower(value-1);
		 }
	 }
	 
	private void addValueToMemory(Integer value, Long result){
		 memory.put(value, result);
	 }
	 private Long getValueFromMemory(Integer value){
		 return memory.get(value);
	 }
	 public long compute2Power(int value){
		 if(value < 0)
			 throw new  IllegalArgumentException();
		 else if(value >= 0){
			 return 2 * computePower(value-1);
		 }
		 else{
				
			  return computePower(value);
		 }

			 
	 }
	 public void clearMemory(){
		 memory.clear();
	 }
	 
}