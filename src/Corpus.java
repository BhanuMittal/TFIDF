import java.util.ArrayList;
import java.util.List;


public class Corpus {
    private List<DocumentInfo> documents = new ArrayList<DocumentInfo>();

    private Integer numberOfDocuments;
    public List<DocumentInfo> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentInfo> documents) {
        this.documents = documents;
    }

    public void addDocument(DocumentInfo document){
        documents.add(document);
    }

    public Integer getNumberOfDocuments() {
        return documents.size();
    }

    public void setNumberOfDocuments(Integer numberOfDocuments) {
        this.numberOfDocuments = numberOfDocuments;
    }
}
