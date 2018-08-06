import java.util.HashMap;

public class Model {

	static HashMap<Integer, Long> memory = new HashMap<Integer, Long>();

    private static Long getValueFromMemory(Integer value){
        return memory.get(value);

    }

    private static void addValueToMemory(Integer value, Long result){
        memory.put(value, result);

    }

  
    public void clearMemory(){
        memory.clear();
    }

   
   static long computePower(int power){ 
	   
       if (power <= 0){
    	   return 1;
       }
         
        return 2 * computePower(power-1); 
   }



    public static long compute2Power(int power){
        if (power < 0){
            throw new IllegalArgumentException();
        }
        Long value = getValueFromMemory(power);
        if(value != null){     
            return value;
        }else{
            value = computePower(power);
            addValueToMemory(power, value);
            return value;
        }
    }
}
