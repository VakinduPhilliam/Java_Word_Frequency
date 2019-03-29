/* Java program to count the frequency occurrences of words in a given text file. */ 

public static void countThe(File textDoc) throws IOException {

        Scanner scannerInput = new Scanner(textDoc);
        int count = 0;   

        while (scannerInput.hasNext()) {  // Is there a next item?

            String nextWord = scannerInput.next();  // Reads next item
            System.out.println(nextWord);  // Just checking to see if I got in the loop

            if (nextWord.equals("The")){

                count++;

                // Replace with "A" and save to new file

            }  // End if

            if (nextWord.equals("the")) {

                count++;

                // Replace with "a" and save to new file

            }  // End if

        }  // End while loop

        System.out.println("The file contains " + count + " occurrences of \"the\"");

 }  // Ends countThe method

