import java.util.LinkedList;
import java.util.ArrayList;

public class BestFit{
  private int binSize;
  private LinkedList<Integer> bfList;
  private int[][] bins;
  private int totalBins=0;
  
  public BestFit(LinkedList<Integer> originalList,int bs){
    bfList=originalList;
    binSize=bs;
    bins=new int[bfList.size()][bfList.size()];
    initArray(bins);
  }
  
  public void bestFitFunction(LinkedList<Integer> targetList){
    for(int i=0;i<targetList.size();i++){//start from the very first element from the linkedlist
      boolean added=false;
      int perfectSpot=perfectIndex(targetList.get(i));
        
      for(int z=0;(z<bins[0].length) &&(added==false);z++){
        if(bins[perfectSpot][z]==0){
          bins[perfectSpot][z]=targetList.get(i);
          added=true;
        }
      }
    }
     //System.out.println("------"); 
  }
  
  public int perfectIndex(int toBeAdded){
    int desIndex=0;
    int currentPerfectGap=binSize;
    
    for(int i=0;(i<bins.length);i++){
      if(bins[0][0]==0){
        desIndex=0;
        break;
      }
      //System.out.println("sum(bins[i]):"+sum(bins[i])+ "    toBeAdded:"+toBeAdded+"      binSize:"+binSize+"   binSize-(sum(bins[i])-toBeAdded:"+(binSize-(sum(bins[i])+toBeAdded))); 
      if(((sum(bins[i])+toBeAdded)<=binSize) && (( binSize-(sum(bins[i])+toBeAdded))<currentPerfectGap)){
        desIndex=i;
        currentPerfectGap=binSize-(sum(bins[i])+toBeAdded);
        //System.out.println("here");
      }
    } 
    //System.out.println(desIndex+"  "+toBeAdded);
    return desIndex;
  }
  
  public int getTotalBins(){
    bestFitFunction(bfList);
    int i;
    for(i=0;i<bins.length;i++){
      if(bins[i][0]==0){
        break;
      }
    }
    totalBins=i;

    return totalBins;
  }
  
  public void initArray(int[][] targetArray){
    for(int i=0;i<targetArray.length;i++){
      for(int j=0;j<targetArray[0].length;j++){
        targetArray[i][j]=0;
      }
    }
  }
  
  public int sum(int []targetBin){
    int sumResult=0;
    
    for(int i=0;(i<targetBin.length) && (targetBin[i]!=0);i++){
      sumResult=sumResult+targetBin[i];
    }
    
    return sumResult;
  }
  
  public void printResult(){
    for(int i=0;i<bins.length;i++){
      if((bins[i][0]!=0)){
        System.out.print("bin "+i+":");
      }
      
      for(int j=0;(j<bins[0].length) && (bins[i][j]!=0);j++){
        System.out.print((bins[i][j]+" "));
      }
      if(bins[i][0]!=0){
        System.out.println("");
      }
    }
  }
  
  
}