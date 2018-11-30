import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class mainFunction
{
  public static void main(String[] args){
    
    LinkedList<Integer> list = new LinkedList<Integer>();
    Random rand = new Random();
    int intputSize=5;
    
    for(int i=0;i<intputSize;i++){
      int n = rand.nextInt(100) + 1;
      list.add(n);
    }

    System.out.println(list.size());
    System.out.println(list);
    
    NextFit nT=new NextFit(list);
    System.out.println("NextFit total bins:"+nT.getTotalBins());
    //nT.printResult();
    
    System.out.println("-----------------------------");
    
    FirstFit fT=new FirstFit(list);
    System.out.println("FirstFit total bins:"+fT.getTotalBins());
    //fT.printResult();
    
    System.out.println("-----------------------------");
    
    BestFit bT=new BestFit(list);
    System.out.println("BestFit total bins:"+bT.getTotalBins());
    //bT.printResult();
    System.out.println("-----------------------------");
    
    Harmonic hA=new Harmonic(list);
    System.out.println("v total bins:"+hA.getTotalBins());
    hA.printResult();
  }
}