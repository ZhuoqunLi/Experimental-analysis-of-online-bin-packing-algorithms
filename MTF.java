import java.util.LinkedList;
import java.util.Arrays; 

public class MTF{
  private int binSize;
  private LinkedList<Integer> mtfList;
  private LinkedList<Integer> positionList=new LinkedList<Integer>();
  private int[][] bins;
  private int totalBins=0;
  
  public MTF(LinkedList<Integer> originalList,int bs){
    mtfList=originalList;
    binSize=bs;
    bins=new int[mtfList.size()][mtfList.size()];
    initArray(bins);
  }
  
  public void mtfFunction(LinkedList<Integer> targetList){
    boolean added;
    for(int i=0;i<targetList.size();i++){//start from the very first element from the linkedlist
      added=false;
      for(int j=0;(j<bins.length) &&(added==false);j++){
        
        if((sum(bins[j])+targetList.get(i))<=binSize){
          for(int z=0;(z<bins[0].length) &&(added==false);z++){
            if(bins[j][z]==0){
              bins[j][z]=targetList.get(i);
              added=true;
              //if((bins[j][1]!=0)){
              if((z>0)){
                shiftArray(bins,j);
              }
            }
            //System.out.println(Arrays.toString(bins));
          }
        }
      }
    }
  }
  
  public int[][] shiftArray(int[][] targetArray,int targetIndex){
    int[] storedRemovedArray=targetArray[targetIndex];
    for(int i=targetIndex;i>0;i--){
      targetArray[i]=targetArray[i-1];
    }
    targetArray[0]=storedRemovedArray;
    return targetArray;
  }
  
  public int getTotalBins(){
    mtfFunction(mtfList);
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
  public LinkedList<Integer> printWaste(){
    LinkedList<Integer> wasteList= new LinkedList<Integer>();
    for(int i=0;i<bins.length;i++){
      int wasteSum=0;
      int sum=0;
      for(int j=0;(j<bins[0].length) && (bins[i][j]!=0);j++){
        sum=sum+bins[i][j];        
      }
      if(bins[i][0]!=0){
        wasteSum=binSize-sum;
        wasteList.add(wasteSum);
      }
    }
    return wasteList;
  }

}