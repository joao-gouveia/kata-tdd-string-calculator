import java.util.ArrayList;

/**
 * Calculator
 */
public class Calculator {
  public int Add(String numbers) {
    int sum = 0;

    if(numbers.length()>0){

      String delimitor = findDelimitor(numbers);

      String[] nums = parseNumbers(numbers).split(",|\n" + delimitor);
      
      ArrayList<String> invalid = new ArrayList<String>();
      for(int i = 0; i < nums.length; i++){
        if(nums[i].equals(""))
        break;
        if(Integer.parseInt(nums[i])<0){
          invalid.add(nums[i]);
          continue;
        }
        if(Integer.parseInt(nums[i])>1000)
        continue;
        
        sum += Integer.parseInt(nums[i]);
      }
      if(invalid.size()!=0){
        String ret = "negatives not allowed: ";
        for(int i=0;i<invalid.size();++i){
          ret+=invalid.get(i);
          if(i!=invalid.size()-1){
            ret+=",";
          }
          
        }
        throw new IllegalArgumentException(ret);
      }
    }
    return sum;

  }

  private String findDelimitor(String numbers){
    if(numbers.startsWith("//")){
        return "|" + numbers.charAt(2);
    }
    return "";

  }

  private String parseNumbers(String numbers){
    if(numbers.startsWith("//")){
      return numbers.substring(4);
  }
  return numbers;
  }

}