package userdata.food;

import userdata.BusinessInformation;

public class FoodData extends BusinessInformation {

    public FoodData(String ID, String title, String category, String type) {
        super(ID, title, category, type);
    }

    @Override
    public String toString() {
        return "FoodData [" + super.toString() + "]";
    }
}
