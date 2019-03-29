/* Java program to count and map out the frequency occurrences of words in a given text file. */ 
/* Basically this program identifies duplicate words in a file and counts the number of times they occur. */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;

public class CountLineWordsDuplicateWords {

     public FileReader fr = null;
     public BufferedReader br =null;

     public String [] stringArray;
     public int counLine = 0;
     public int arrayLength ;

     public String s="";
     public String stringLine="";
     public String filename ="";
     public String wordname ="";

public CountLineWordsDuplicateWords(){

    try{

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the filename: ");

        filename = scan.nextLine();
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Please enter a word: ");

        wordname = scan.nextLine();
        fr = new FileReader(filename);
        br = new BufferedReader(fr);

        while((s = br.readLine()) != null){

            stringLine = stringLine + s;

            //System.out.println(s);

            stringLine = stringLine + " ";

            counLine ++;

        }



        //System.out.println("Contents of file: " + stringLine);

        stringArray = stringLine.split(" ");
        arrayLength = stringArray.length;

        //System.out.println("The total number of words in the text file is "+arrayLength);

        /*Duplicate String count code */

        for (int i = 0; i < arrayLength; i++) {

            int c = 1 ;

            for (int j = i+1; j < arrayLength; j++) {

                if(stringArray[i].equalsIgnoreCase(stringArray[j])){

                    c++;

                    for (int j2 = j; j2 < arrayLength; j2++) {

                        stringArray[j2] = stringArray[j2+1];
                        arrayLength = arrayLength - 1;

                    }

                    //System.out.println(wordname);

                    if (stringArray[i].equalsIgnoreCase(wordname)){

                     System.out.println("The word "+wordname+" is present "+c+" times in the specified file.");

                    }


            }   //End of Inner for block

       //System.out.println("The word "+stringArray[i]+" is present "+c+" times in the specified file.");


        }

    }   //End of Outer for block


        System.out.println("Total number of lines: "+counLine);


        //System.out.println();


        fr.close();
        br.close();

    } catch (Exception e) {

        e.printStackTrace();

    }
  }
}
