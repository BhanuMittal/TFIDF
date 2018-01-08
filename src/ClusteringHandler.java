import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class ClusteringHandler {
//    private static final String DIR_PATH = "C:\\Users\\euj346\\Desktop\\workspace\\semanticanalysis\\resources\\CFR-2016";
    private static final String DIR_PATH = "C:\\Users\\euj346\\Downloads\\CFR-2016";
    public static void main(String[] args){
        String directoryPath = DIR_PATH;
        if(args != null && args.length > 0){
            directoryPath = args[0];
        }
        Corpus corpus = new Corpus();
        corpus = FolderBrowser.browseDirectories(new File(directoryPath), corpus);
        TFIDFCalculator.calculateTDIDF(corpus);
        System.out.println("Number of Documents parsed = " + corpus.getNumberOfDocuments());
        printFrequentWords(corpus);
    }
    private static void printFrequentWords(Corpus corpus){
        for(DocumentInfo document : corpus.getDocuments()){
            System.out.println("File = " + document.getFile().getName());
            for(Double tfidf : document.getTopwords().getMostFrequentWords().keySet()){
                System.out.print("Word:" + document.getTopwords().getMostFrequentWords().get(tfidf) + "::TFIDF:" + tfidf + ":::::");
            }
            System.out.println("");
        }
    }
}
