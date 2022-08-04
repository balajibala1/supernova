package demo.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import demo.model.Demo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class DemoService {
    private static final String COLLECTION_NAME = "demo";

    public String save(Demo demo) throws ExecutionException, InterruptedException {
        Firestore firestore= FirestoreClient .getFirestore();
        ApiFuture<WriteResult> collection=firestore.collection(COLLECTION_NAME).document(demo.getName()).set(demo);
        return collection.get().getUpdateTime().toString();
    }

    public String update(Demo demo) throws ExecutionException, InterruptedException {
        Firestore firestore= FirestoreClient .getFirestore();
        ApiFuture<WriteResult> collection=firestore.collection(COLLECTION_NAME).document(demo.getName()).set(demo);
        return collection.get().getUpdateTime().toString();
    }
    public String delete(String name) throws ExecutionException, InterruptedException {
        Firestore firestore= FirestoreClient .getFirestore();
        ApiFuture<WriteResult> collection=firestore.collection(COLLECTION_NAME).document(name).delete();
        return "Deleted Successfully";
    }
    public List<Demo> getDetails() throws ExecutionException, InterruptedException {
        Firestore firestore= FirestoreClient .getFirestore();
        Iterable<DocumentReference> documentReference=firestore.collection(COLLECTION_NAME).listDocuments();
        Iterator<DocumentReference> iterator= documentReference.iterator();
        List<Demo> demoList=new ArrayList<>();
        Demo demo=null;
        while(iterator.hasNext()){
            DocumentReference documentReference1=iterator.next();
            ApiFuture<DocumentSnapshot> future=documentReference1.get();
            DocumentSnapshot documentSnapshot=future.get();
            demo=documentSnapshot.toObject(Demo.class);
            demoList.add(demo);
        }
        return demoList;

    }
}
