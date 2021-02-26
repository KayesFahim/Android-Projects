package com.kayeswap.shahajjo.Services.BloodBank;

public class BloodRequestModel {
     String id;
     String name;
     String phone;
      String blood;
     String location;
   private  String relation;
     private String problem;
    private String time;
   private  String how;
   private String contact;


    public BloodRequestModel() {
    }

    public BloodRequestModel(String id, String name, String phone, String blood, String location, String relation, String problem, String time, String how) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.blood = blood;
        this.location = location;
        this.how = how;
        this.relation = relation;
        this.problem = problem;
        this.time = time;


    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public BloodRequestModel(String contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getPhone() { return phone; }

    public String getBlood() {
        return blood;
    }

    public String getLocation() { return location; }

    public String getRelation() { return relation; }

    public String getProblem() { return problem; }

    public String getTime() { return time; }

    public String getHow() { return how; }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
