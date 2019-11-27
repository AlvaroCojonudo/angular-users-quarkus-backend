package org.acme.rest.json;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject MongoClient mongoClient;

    public List<User> list(){
        List<User> list = new ArrayList<>();
        MongoCursor<Document> cursor = getCollection().find().iterator();

        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                User user = new User();
                user.setName(document.getString("name"));
                user.setSurname(document.getString("surname"));
                user.setBirth(document.getString("birth"));
                user.setUsername(document.getString("username"));
                list.add(user);
            }
        } finally {
            cursor.close();
        }
        return list;
    }

    public void add(User user){
        Document document = new Document()
                .append("name", user.getName())
                .append("surname", user.getSurname())
                .append("birth", user.getBirth())
                .append("username", user.getUsername());
        getCollection().insertOne(document);
    }

    public void delete(User user){
        Document document = new Document()
                .append("name", user.getName())
                .append("surname", user.getSurname())
                .append("birth", user.getBirth())
                .append("username", user.getUsername());
        getCollection().deleteOne(document);
    }


    private MongoCollection getCollection(){
        return mongoClient.getDatabase("user").getCollection("user");
    }
}