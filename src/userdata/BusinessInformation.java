package userdata;

public class BusinessInformation {
    private String ID;
    private String title;
    private String category;
    private String type;

    public BusinessInformation(String ID, String title, String category, String type) {
        this.ID = ID;
        this.title = title;
        this.category = category;
        this.type = type;
    }

    public String getID() {
        return ID;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "[" + title + ", " + category + ", " + type + "]";
    }
}
