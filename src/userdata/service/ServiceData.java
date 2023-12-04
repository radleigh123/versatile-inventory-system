package userdata.service;

import userdata.BusinessInformation;

public class ServiceData extends BusinessInformation {

    public ServiceData(String ID, String title, String category, String type) {
        super(ID, title, category, type);
    }

    @Override
    public String toString() {
        return "ServiceData [" + super.toString() + "]";
    }
}
