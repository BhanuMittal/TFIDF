
public class TFIDFCalculator {
    public static void calculateTDIDF(Corpus corpus){
        Double tfidf;
        for (DocumentInfo document : corpus.getDocuments()) {
            for (String word : document.getWordCount().keySet()) {
                tfidf = Double.valueOf(document.getWordCount().get(word)) / Double.valueOf(document.getTotalCount());
                int inverseCount = 0;
                for (DocumentInfo inverseDocument : corpus.getDocuments()) {
                    inverseCount = inverseCount + inverseDocument.inverseCount(word);
                }
                Double idf = Double.valueOf(corpus.getNumberOfDocuments()) / Double.valueOf(inverseCount);
                tfidf = tfidf*Math.log(idf);
                document.getWordTF().put(word,tfidf);
                document.getTopwords().addFrequentWord(word, tfidf);
            }
        }
    }
}
