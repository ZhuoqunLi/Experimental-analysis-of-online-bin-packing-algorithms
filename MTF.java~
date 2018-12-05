import java.util.LinkedList;

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
    for(int i=0;i<targetList.size();i++){//start from the very first element from the linkedlist
      boolean added=false;
      for(int j=0;(j<bins.length) &&(added==false);j++){       
        if((sum(bins[j])+targetList.get(i))<=binSize){
          for(int z=0;(z<bins[0].length) &&(added==false);z++){
            if(bins[j][z]==0){
              bins[j][z]=targetList.get(i);
              added=true;
              //System.out.println(j+" "+targetList.get(i));
              if((positionList.size()!=0)&&(positionList.contains(new Integer(j)))){//current bin already have item in it, then we need to move it to front
                //System.out.println("in");
                positionList.remove(new Integer(j));
                positionList.addFirst(new Integer(j));
                //System.out.println(positionList.toString());
              }
              else{
                positionList.add(new Integer(j));
                //System.out.println("add");
              }
              //System.out.println(bins[j][z]+" "+i+" "+j+" "+targetList.get(i));
            }
          }
        }
      }
     //System.out.println("------"); 
    }
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
    int position;
    //System.out.print("positionList:"+positionList.toString());
    for(int i=0;i<positionList.size();i++){
      position=positionList.indexOf(new Integer(i));
      if((bins[position][0]!=0)){
        System.out.print("bin "+i+":");
      }
      
      for(int j=0;(j<bins[0].length) && (bins[position][j]!=0);j++){
        System.out.print((bins[position][j]+" "));
      }
      if(bins[position][0]!=0){
        System.out.println("");
      }
    }
  }
}