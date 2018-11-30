import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class mainFunction
{
  public static void main(String[] args){
    
    LinkedList<Integer> list = new LinkedList<Integer>();
    Random rand = new Random();
    intputSize=100;
    
    for(int i=0;i<intputSize;i++){
      int n = rand.nextInt(50) + 1;
      list.add(n);
    }

    System.out.println(list.size());
    
    
    FirstFit fT=new FirstFit(list);
    System.out.println("total bins:"+fT.getTotalBins());
    //System.out.println(fT.toString());
    fT.printResult();
  }
}