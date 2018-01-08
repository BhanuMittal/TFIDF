import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class FolderBrowser {

    public static void main(String[] args){
//        browseDirectories(new File("C:\\Users\\euj346\\Desktop\\workspace\\semanticanalysis\\resources\\CFR-2016"), new Corpus());
        browseDirectories(new File("home\\user\\finalproject\\CFR-2016"), new Corpus());

    }

    public static Corpus browseDirectories(File file, Corpus corpus){
        if(file.isDirectory()){
            File[] directoryListing = file.listFiles();
            if(directoryListing != null) {
                for(File child : directoryListing) {
                    browseDirectories(child, corpus);
                }
            }
        }
        else if(file.isFile()){
            corpus.addDocument(new DocumentReader().parseDocument(file));
        }
        return corpus;
    }
}
