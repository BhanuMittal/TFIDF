import java.util.HashMap;
import java.util.Map;

/**
 * Created by EUJ346 on 5/9/2017.
 */
public class TopWords {
    private Map<Double, String> mostFrequentWords = new HashMap<Double, String>();
    private double minimumFrequency = 0;
    public static Integer maxCount = 20;

    public Map<Double, String> getMostFrequentWords() {
        return mostFrequentWords;
    }

    public void setMostFrequentWords(Map<Double, String> mostFrequentWords) {
        this.mostFrequentWords = mostFrequentWords;
    }

    public double getMinimumFrequency() {
        return minimumFrequency;
    }

    public void setMinimumFrequency(double minimumFrequency) {
        this.minimumFrequency = minimumFrequency;
    }

    public static Integer getMaxCount() {
        return maxCount;
    }

    public static void setMaxCount(Integer maxCount) {
        TopWords.maxCount = maxCount;
    }

    public void addFrequentWord(String word, double tfidf){
        if(mostFrequentWords.size() < maxCount){
            mostFrequentWords.put(tfidf, word);
            if(minimumFrequency == 0){ minimumFrequency = tfidf;}
            minimumFrequency = Math.min(minimumFrequency, tfidf);
        }
        else if(minimumFrequency < tfidf){
            mostFrequentWords.remove(minimumFrequency);
            mostFrequentWords.put(tfidf, word);
            calculateMinimumFrequency();
        }
    }

    private void calculateMinimumFrequency() {
    	minimumFrequency = 10;
        for(Double freq : mostFrequentWords.keySet()){
            minimumFrequency = Math.min(minimumFrequency, freq);
        }
    }
}
