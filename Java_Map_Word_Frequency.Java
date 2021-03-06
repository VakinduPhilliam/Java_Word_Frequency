/* Java program to map frequency occurrences of words in a given text file. */ 

   Scanner file = new Scanner(new File("text.txt")).useDelimiter("[^a-zA-Z]+");
   HashMap<String, Integer> map = new HashMap<>();

   while (file.hasNext()){

        String word = file.next().toLowerCase();

        if (map.containsKey(word)) {

            map.put(word, map.get(word) + 1);

        } else {

            map.put(word, 0);

        }
    }

    ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
    Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {

        @Override
        public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {

            return a.getValue().compareTo(b.getValue());

        }
    });

    for(int i = 0; i < 10; i++){

        System.out.println(entries.get(entries.size() - i - 1).getKey());

    }