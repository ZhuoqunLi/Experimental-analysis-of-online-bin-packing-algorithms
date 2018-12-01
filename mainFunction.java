import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

public class mainFunction
{
  
  
  public static void main(String[] args){   
    LinkedList<Integer> list = new LinkedList<Integer>();    
    int intputSize=1000;    
    int binSize=100;
    Random rand = new Random();
    
    for(int i=0;i<intputSize;i++){
      int n = rand.nextInt(binSize) + 1;
      int remaindSize=binSize-n;
      list.add(n);
      while(remaindSize>0){
        n=rand.nextInt(remaindSize) + 1;
        remaindSize=remaindSize-n;
        list.add(n);
        if((remaindSize<=15)&&(remaindSize>0)){
          list.add(remaindSize);
          remaindSize=0;
        }
        //System.out.println(n+" "+i+" "+remaindSize);
      }
    }
    
    System.out.println(list.size());
    //System.out.println(list);
    Collections.shuffle(list);
    //System.out.println(list);
    
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
    System.out.println("Harmonic total bins:"+hA.getTotalBins());
    //hA.printResult();
  }
}