import java.util.LinkedList;
import java.util.ArrayList;

public class NextFit{
  private int binSize;
  private LinkedList<Integer> nfList;
  private int[][] bins;
  private int totalBins=0;
  private int startBin=0;
  
  public NextFit(LinkedList<Integer> originalList,int bs){
    nfList=originalList;
    binSize=bs;
    bins=new int[nfList.size()][nfList.size()];
    initArray(bins);
  }
  
  public void nextFitFunction(LinkedList<Integer> targetList){
    for(int i=0;i<targetList.size();i++){//start from the very first element from the linkedlist
      boolean added=false;
      for(int j=startBin;(j<bins.length) &&(added==false);j++){
        
        if((sum(bins[j])+targetList.get(i))<=binSize){
          for(int z=0;(z<bins[0].length) &&(added==false);z++){
            if(bins[j][z]==0){
              bins[j][z]=targetList.get(i);
              added=true;
              //System.out.println(bins[j][z]+" "+i+" "+j+" "+targetList.get(i));
            }
          }
        }
        startBin=j;
      }
     //System.out.println("------"); 
    }
  }
  
  public int getTotalBins(){
    nextFitFunction(nfList);
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