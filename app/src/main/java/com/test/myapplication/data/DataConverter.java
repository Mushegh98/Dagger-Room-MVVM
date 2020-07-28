package com.test.myapplication.data;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.test.myapplication.data.model.Address;
import com.test.myapplication.data.model.Company;

public class DataConverter {

    @TypeConverter
    public String addressToString(Address address){
        Gson gson = new Gson();
        return gson.toJson(address);
    }

    @TypeConverter
    public Address stringToAddress(String address){
        Gson gson = new Gson();
        return gson.fromJson(address,Address.class);
    }

    @TypeConverter
    public String companyToString(Company company){
        Gson gson = new Gson();
        return gson.toJson(company);
    }

    @TypeConverter
    public Company stringToCompany(String company){
        Gson gson = new Gson();
        return gson.fromJson(company,Company.class);
    }

}
