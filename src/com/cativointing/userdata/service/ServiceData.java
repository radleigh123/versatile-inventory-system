package com.cativointing.userdata.service;

import com.cativointing.userdata.BusinessInformation;

public class ServiceData extends BusinessInformation {

    public ServiceData(String ID, String title, String category, String type) {
        super(ID, title, category, type);
    }

    public void loadData() {
        
    }

    @Override
    public String toString() {
        return "ServiceData [" + super.toString() + "]";
    }
}
