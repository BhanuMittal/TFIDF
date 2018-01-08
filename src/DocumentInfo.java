import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class DocumentInfo {
    private Map<String, Integer> wordCount = new HashMap<String, Integer>();
    private Map<String, Double> wordTF = new HashMap<String, Double>();
    private TopWords topwords = new TopWords();
    private Integer totalCount = 0;
    private File file;

    public TopWords getTopwords() {
        return topwords;
    }

    public void setTopwords(TopWords topwords) {
        this.topwords = topwords;
    }

    public Map<String, Integer> getWordCount() {
        return wordCount;
    }

    public void setWordCount(Map<String, Integer> wordCount) {
        this.wordCount = wordCount;
    }

    public Map<String, Double> getWordTF() {
        return wordTF;
    }

    public void setWordTF(Map<String, Double> wordTF) {
        this.wordTF = wordTF;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public int inverseCount(String word){
        if(wordCount.containsKey(word)){
            return 1;
        }
        return 0;
    }
}
