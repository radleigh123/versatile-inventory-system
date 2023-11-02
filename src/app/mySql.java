package app;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class mySql {
    public static String con = "mongodb+srv://admin:123@cluster0.owqmodj.mongodb.net/?retryWrites=true&w=majority";
    public static MongoClient client;
    public static MongoDatabase db;
    public static MongoCollection col;

    public static void main(String[] args) {
        client = MongoClients.create(con);

        db = client.getDatabase("sampleDB");
        col = db.getCollection("sampleCollection");

        /* Document sampleDocument = new Document("_id", "1").append("name", "John Smith");
        col.insertOne(sampleDocument); */

        // CREATE
        mySqlTest test = new mySqlTest(1, 200, "John Smith");
        // col.insertOne(convertDoc(test));

        // READ
        Document readQuery = new Document("name", "John Inting");
        FindIterable result = col.find(readQuery);
        MongoCursor cursor = result.iterator();
        System.out.println(cursor.next());

        // UPDATE
        mySqlTest updateTest = new mySqlTest();
        updateTest.setXp(3);
        updateTest.setTimer(400);
        updateTest.setName("John Inting");
        col.findOneAndUpdate(readQuery, convertDoc(updateTest));
        result = col.find(readQuery);
        cursor = result.iterator();
        System.out.println(cursor.next()); // Print again

        // DELETE
        col.findOneAndDelete(readQuery);

        cursor.close();
    }

    public static Document convertDoc(mySqlTest test) {
        return new Document("$set",
                new Document("xp", test.getXp())
                        .append("timer", test.getTimer())
                        .append("name", test.getName()));
    }
}
