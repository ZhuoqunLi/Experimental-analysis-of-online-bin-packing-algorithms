import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Collections;
import java.lang.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.Scanner;
import java.io.File; 
import java.util.Scanner; 

public class mainFunction
{  
  public static void main(String[] args){
    LinkedList<Integer> list = new LinkedList<Integer>();

    int intputSize=0;    
    int binSize=0; 
    int testTimes=0;
     
    String benchMarkOption=JOptionPane.showInputDialog("which benchmark option would you want to run?£¨enter the character to choose£©\na.normal\nb.amazon box\nc.words");
    String runTimes=JOptionPane.showInputDialog("how many tests do you want to do in a round?(enter numbers from 1 to 1500)");
    testTimes=Integer.parseInt(runTimes);
    if(benchMarkOption.equals("a")){
      String inputForSize=JOptionPane.showInputDialog("enter the how bins for optimal solution");
      //String inputForbinSize=JOptionPane.showInputDialog("enter the size of bins"); 
      try{
        intputSize=Integer.parseInt(inputForSize);
        //binSize=Integer.parseInt(inputForbinSize);
        binSize=100;
      }
      catch(NumberFormatException e){
        System.out.println("NumberFormatException: " + e.getMessage());
      }
      System.out.println("inputSize:" + intputSize+"  binSize:"+binSize);  
      for(int z=0;z<testTimes;z++){
        list=inputGenerator(list,intputSize,binSize);
        //System.out.println(list);
        Collections.shuffle(list);
        //System.out.println(list);
        System.out.println("bin numbers:"+intputSize);
        System.out.println("input size:"+list.size());
        //System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        normalCases(list,binSize);
      }
    }
    else if(benchMarkOption.equals("b")){
      String inputForItems=JOptionPane.showInputDialog("how many items in total");
      int itemsNum=0;
      try{
        itemsNum=Integer.parseInt(inputForItems);
      }
      catch(NumberFormatException e){
        System.out.println("NumberFormatException: " + e.getMessage());
      }
      for(int z=0;z<testTimes;z++){
        LinkedList<Integer> binTypes = new LinkedList<Integer>();
        LinkedList<Integer> simInput = new LinkedList<Integer>();
        String dir = System.getProperty("user.dir");
        File file = new File(dir+"\\box_volumn.txt"); 
        System.out.println(dir);
        try(Scanner sc = new Scanner(file)){
          while (sc.hasNextLine()){           
            binTypes.add(Integer.parseInt(sc.nextLine()));
          }
          Collections.sort(binTypes);
          System.out.println(binTypes.size()); 
          //System.out.println(binTypes.toString());
          for(int i=0;i<binTypes.size();i++){
            if(((i>=0)&&(i<13))||((i>=81)&&(i<binTypes.size()))){
              simInput.add(binTypes.get(i));
            }
            else if( ((i>=13)&&(i<26)) ||((i>=67)&&(i<81))){
              simInput.add(binTypes.get(i));
              simInput.add(binTypes.get(i));
            }
            else if(((i>=26)&&(i<39)) || (((i>=53)&&(i<67)))){
              simInput.add(binTypes.get(i));
              simInput.add(binTypes.get(i));
              simInput.add(binTypes.get(i));
            }
            else if((i>=39)&&(i<53)){
              simInput.add(binTypes.get(i));
              simInput.add(binTypes.get(i));
              simInput.add(binTypes.get(i));
              simInput.add(binTypes.get(i));
            }
          }
          //System.out.println(simInput.toString());
          binSize=15000;          
          Random rand = new Random();
          for(int i=0;i<itemsNum;i++){
            list.add(simInput.get(rand.nextInt(simInput.size())));
          }
          //System.out.println(list.toString());
          normalCases(list,binSize);
        }
        catch (IOException e) {
          System.out.println("NumberFormatException: " + e.getMessage());
        }
      }
    }
    else if(benchMarkOption.equals("c")){
      String inputForWords=JOptionPane.showInputDialog("how many words in total");
      int itemsNum=0;
      try{
        itemsNum=Integer.parseInt(inputForWords);
      }
      catch(NumberFormatException e){
        System.out.println("NumberFormatException: " + e.getMessage());
      }
      for(int z=0;z<testTimes;z++){
        LinkedList<String> wordsTypes = new LinkedList<String>();
        LinkedList<Integer> wordInput = new LinkedList<Integer>();
        String dir = System.getProperty("user.dir");
        File file = new File(dir+"\\words.txt"); 
        System.out.println(dir);
        try(Scanner sc = new Scanner(file)){
          while (sc.hasNextLine()){           
            wordsTypes.add(sc.nextLine());
          }
          //System.out.println(wordsTypes.size()); 
          for(int i=0;i<wordsTypes.size();i++){
            wordInput.add((wordsTypes.get(i)).length());
          }
          //System.out.println(wordsTypes.toString());
          //System.out.println(wordInput.toString());
          binSize=100;
          Random rand = new Random();
          for(int i=0;i<itemsNum;i++){
            list.add(wordInput.get(rand.nextInt(wordInput.size())));
          }
          //System.out.println(list.toString());
          normalCases(list,binSize);
        }
        catch (IOException e) {
          System.out.println("NumberFormatException: " + e.getMessage());
        }        
      }
    }
  }
  
  public static void normalCases(LinkedList<Integer> targetList,int bS){
    LinkedList<Integer> list =targetList;
    //int inputSize=iS;
    int binSize=bS;          
    DecimalFormat formatForTime = new DecimalFormat("#,###"); 
    
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
    //mA.printResult();
    System.out.println();
    System.out.println();
        
  }
  
  public static LinkedList<Integer> inputGenerator(LinkedList<Integer> targetList,int inputS,int binS){
    LinkedList<Integer> tempList = new LinkedList<Integer>();
    int intputSize=inputS;    
    int binSize=binS;
    Random rand = new Random();
    
    for(int i=0;i<(intputSize);i++){
      int n = rand.nextInt(binSize) + 1;
      //int n = rand.nextInt(5) + 1;
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
          //n=rand.nextInt(5) + 1;
          remaindSize=remaindSize-n;
          tempList.add(n);
        }
        //System.out.println(n+" "+i+" "+remaindSize);
      }
    }    
    return tempList;
  }
}