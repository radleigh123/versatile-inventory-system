package app;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import java.util.Scanner;

import org.bson.Document;

/**
 * This is a test class for MongoDB
 */
public class mySql {
    public static String con = "mongodb+srv://admin:123@cluster0.owqmodj.mongodb.net/?retryWrites=true&w=majority";
    public static MongoClient client;
    public static MongoDatabase db;
    public static MongoCollection col;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        client = MongoClients.create(con);

        db = client.getDatabase("sampleDB");
        col = db.getCollection("sampleCollection");

        boolean flag = false;

        while (!flag) {
            System.out.println("MAIN MENU");
            System.out.println("1. Create\n2. Read\n3. Update\n4. Delete\n5. Exit");
            System.out.print("Enter choice: ");
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter xp: ");
                    int xp = scan.nextInt();
                    System.out.print("Enter timer: ");
                    int timer = scan.nextInt();
                    System.out.print("Enter name: ");
                    String name = scan.next();

                    insertDocument(new mySqlTest(xp, timer, name));
                    break;
                case 2:
                    System.out.print("Enter name: ");
                    String readName = scan.next();
                    Document readQuery = new Document("name", readName);
                    FindIterable result = col.find(readQuery);
                    MongoCursor cursor = result.iterator();

                    while (cursor.hasNext()) {
                        System.out.println(cursor.next());
                    }
                    break;
                case 3:
                    System.out.print("Enter name: ");
                    readName = scan.next();
                    readQuery = new Document("name", readName);

                    System.out.print("Enter xp: ");
                    int updateExp = scan.nextInt();
                    System.out.print("Enter timer: ");
                    int updateTimer = scan.nextInt();
                    System.out.print("Enter name: ");
                    String updateName = scan.next();

                    col.findOneAndUpdate(readQuery, convertDoc(new mySqlTest(updateExp, updateTimer, updateName)));
                    break;
                case 4:
                    System.out.print("Enter name: ");
                    readName = scan.next();
                    readQuery = new Document("name", readName);
                    col.findOneAndDelete(readQuery);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    flag = true;
                    break;
                default:
                    break;
            }
        }

        /* // CREATE
        mySqlTest test = new mySqlTest(1, 200, "John");
        mySqlTest test2 = new mySqlTest(2, 300, "May");
        mySqlTest test3 = new mySqlTest(3, 400, "Becky");
        mySqlTest test4 = new mySqlTest(4, 500, "Jenny");
        col.insertOne(createDoc(test));
        col.insertOne(createDoc(test2));
        col.insertOne(createDoc(test3));
        col.insertOne(createDoc(test4));
        
        // READ
        Document readQuery = new Document("name", "John");
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
        cursor.close(); */

        scan.close();
    }

    public static void insertDocument(mySqlTest test) {
        col.insertOne(createDoc(test));
    }

    public static Document convertDoc(mySqlTest test) {
        return new Document("$set",
                new Document("xp", test.getXp())
                        .append("timer", test.getTimer())
                        .append("name", test.getName()));
    }

    public static Document createDoc(mySqlTest test) {
        return new Document("xp", test.getXp())
                .append("timer", test.getTimer())
                .append("name", test.getName());
    }
}

class mySqlTest {
    private String name;
    private int timer;
    private int xp;

    public mySqlTest() {
    }

    public mySqlTest(int xp, int timer, String name) {
        this.xp = xp;
        this.timer = timer;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

}
