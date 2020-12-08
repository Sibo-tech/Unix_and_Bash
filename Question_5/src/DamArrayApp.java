package src;
import java.io.*;

public class DamArrayApp{
   private DamArrayApp(){}
   
   //private static String path = "C:/Users/sibon/Desktop/Zaio_deliverables/Unix/Question_5/bin/DamLevels.csv";
   //private static String nFilePath = "C:/Users/sibon/Desktop/Zaio_deliverables/Unix/Question_5/bin/DamLevels.txt";
   
   private static String[] lineValues;
   private static String line = ""; 

   
   private static BufferedReader readFile;
   private static FileWriter  writeFile; 
      
   public static void main(final String[] args){
      try{
         readFile = new BufferedReader(new FileReader("C:/Users/sibon/Desktop/Zaio_deliverables/Unix/Question_5/bin/DamLevels.csv"));
         writeFile = new FileWriter("C:/Users/sibon/Desktop/Zaio_deliverables/Unix/Question_5/bin/DamLevels.csv",true);
      
         if(args.length > 0){ printDam(args[0]); }
         else{ printAll(); }
               
         
         writeFile.close();
      
      }catch(final FileNotFoundException e){ System.out.println("File does not exist"); }
       catch(final IOException e){ System.out.println("What file now");  }
 
   }
   
   public static void printDam(final String damName){

      String tName; String oName;     
      try{
         while((line = readFile.readLine()) != null){
            lineValues = line.split(",");
            
            //Cleaning data to make it easier to compare dam Names.
            tName      = lineValues[2];            
            tName = tName.replace(" ",""); tName = tName.substring(1, tName.length() -1);
            oName = damName.replace(" ","");
            
            if(tName.equalsIgnoreCase(oName)){
               if(lineValues.length >= 25){
         
                  writeFile.write("Dam Name: "+damName +" FSC: "+lineValues[10]+" Dam Level: "+lineValues[25]+"\n");
               }
               else{ System.out.println("Dam Does not contain Enough Values to display.");}  
            }else{System.out.println("Dam Not Found.");}
         }
      
      }catch(final IOException e){ System.out.println("Could not read line"); }
   }
   
   public static void printAll(){
      String dam = "";
      try{
         while((line = readFile.readLine()) != null){
            lineValues = line.split(",");
            if(lineValues.length >= 25){
                                    
               dam = lineValues[2].replace(" ","");
               if(dam.contains("Dam")){
                  writeFile.write("Dam Name: "+lineValues[2] +" FSC: "+ lineValues[10]+" Dam Level  "+lineValues[25]+"\n");
               }
            } 
         }
       }catch(final IOException e){
            System.out.println("Could not read line");}
      
      }      
  }