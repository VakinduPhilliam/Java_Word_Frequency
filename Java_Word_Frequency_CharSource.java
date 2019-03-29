/* Java program to count and map the frequency occurrences of words in a given text file. */ 

private static final String SOURCE = "com/levelup/java/io/word-occurrences-in-file.txt";
private URI sourceFileURI;

@Before
public void setUp () throws URISyntaxException {

    sourceFileURI = this.getClass().getClassLoader().getResource(SOURCE).toURI();

}


@Test
public void distinct_words_in_file_java() throws IOException {

    File file = new File(sourceFileURI);

    List<String> lines = java.nio.file.Files.readAllLines(
            Paths.get(file.toURI()), Charsets.UTF_8);

    Map<String, Integer> wordOccurrences = new HashMap<String, Integer>();

    // for each line in file

    for (String line : lines) {

        String[] words = line.split(" ");

        // for every word in file

        for (String word : words) {

            word = word.replace(".", "");

            if (!word.trim().isEmpty()) {
                if (wordOccurrences.containsKey(word)) {

                    int count = wordOccurrences.get(word).intValue();
                    wordOccurrences.put(word, new Integer(count + 1));

                } else {

                    wordOccurrences.put(word, new Integer(1));

                }
            }
        }
    }

    logger.info(wordOccurrences);

    assertEquals(80, wordOccurrences.size());
}


@Test
public void count_distinct_words_java8() throws IOException {

    File file = new File(sourceFileURI);

    long uniqueWords = java.nio.file.Files
            .lines(Paths.get(file.toURI()), Charset.defaultCharset())
            .flatMap(line -> Arrays.stream(line.split(" ."))).distinct()
            .count();

    assertEquals(80, uniqueWords);
}


@Test
public void count_distinct_words_in_file_guava () throws IOException {

    File file = new File(sourceFileURI);

    Multiset<String> wordOccurrences = HashMultiset.create(
      Splitter.on(CharMatcher.WHITESPACE)
        .trimResults(CharMatcher.is('.'))
        .omitEmptyStrings()
        .split(Files.asCharSource(file, Charsets.UTF_8).read()));


    logger.info(wordOccurrences);

    assertEquals(80, wordOccurrences.elementSet().size());

}
