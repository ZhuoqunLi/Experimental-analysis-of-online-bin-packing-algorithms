import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Collections;
import java.lang.*;
import java.text.DecimalFormat;

public class mainFunction
{
  
  
  public static void main(String[] args){
    for(int i=0;i<1000;i++){
      LinkedList<Integer> list = new LinkedList<Integer>();
      int intputSize=1500;    
      int binSize=100;
      DecimalFormat formatForTime = new DecimalFormat("#,###"); 
      
      list=inputGenerator(list,intputSize,binSize);
      
      System.out.println("bin numbers:"+intputSize);
      System.out.println("input size:"+list.size());
      //System.out.println(list);
      Collections.shuffle(list);
      //System.out.println(list);
      
      System.out.println("-----------------------------");
      long beginning = System.nanoTime();    
      NextFit nT=new NextFit(list,binSize);
      System.out.println("NextFit total bins:"+nT.getTotalBins());
      long durationTime = System.nanoTime() - beginning;
      System.out.println(formatForTime.format(durationTime));
      //nT.printResult();    
      System.out.println("-----------------------------");  
      beginning = System.nanoTime();
      FirstFit fT=new FirstFit(list,binSize);
      System.out.println("FirstFit total bins:"+fT.getTotalBins());
      durationTime = System.nanoTime() - beginning;
      System.out.println(formatForTime.format(durationTime));
      //fT.printResult();    
      System.out.println("-----------------------------");  
      beginning = System.nanoTime();
      BestFit bT=new BestFit(list,binSize);
      System.out.println("BestFit total bins:"+bT.getTotalBins());
      durationTime = System.nanoTime() - beginning;
      System.out.println(formatForTime.format(durationTime));
      //bT.printResult();
      System.out.println("-----------------------------"); 
      beginning = System.nanoTime();
      Harmonic hA=new Harmonic(list,binSize);
      System.out.println("Harmonic total bins:"+hA.getTotalBins());
      durationTime = System.nanoTime() - beginning;
      System.out.println(formatForTime.format(durationTime));
      //hA.printResult();
      System.out.println("-----------------------------");
      beginning = System.nanoTime();
      MTF mA=new MTF(list,binSize);
      System.out.println("MTF total bins:"+mA.getTotalBins());
      durationTime = System.nanoTime() - beginning;
      System.out.println(formatForTime.format(durationTime));
      System.out.println();
      System.out.println();
      //mA.printResult();
    }
  }
  
  public static LinkedList<Integer> inputGenerator(LinkedList<Integer> targetList,int inputS,int binS){
    LinkedList<Integer> tempList = new LinkedList<Integer>();
    int intputSize=inputS;    
    int binSize=binS;
    Random rand = new Random();
    
    for(int i=0;i<(intputSize);i++){
      int n = rand.nextInt(binSize) + 1;
      int remaindSize=binSize-n;
      //System.out.println(n+" "+i+" "+remaindSize);
      tempList.add(n);
      while(remaindSize>0){
        if(remaindSize<=1){
          tempList.add(remaindSize);
          remaindSize=0;
        }
        else{
          n=rand.nextInt(remaindSize) + 1;
          remaindSize=remaindSize-n;
          tempList.add(n);
        }
        //System.out.println(n+" "+i+" "+remaindSize);
      }
    }    
    return tempList;
  }
}