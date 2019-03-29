/* Java program to map out and count the frequency occurrences of words in a given text file. */ 

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class ScannerTest
{
    public static void main(String[] args) throws FileNotFoundException
        {

        Scanner scanner = new Scanner(new File("G:/Script_nt.txt")).useDelimiter("[^a-zA-Z]+");
        Map<String, Integer> map = new HashMap<String, Integer>();

        while (scanner.hasNext())
            {

            String word = scanner.next();

            if (map.containsKey(word))
                {

                map.put(word, map.get(word)+1);

                }
            else
                {

                map.put(word, 1);

                }
            }

        List<Map.Entry<String, Integer>> entries = new ArrayList<Entry<String,Integer>>( map.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {

                return a.getValue().compareTo(b.getValue());

            }
        });

        for(int i = 0; i < map.size(); i++){

            System.out.println(entries.get(entries.size() - i - 1).getKey()+" "+entries.get(entries.size() - i - 1).getValue());

            }
        }
}
