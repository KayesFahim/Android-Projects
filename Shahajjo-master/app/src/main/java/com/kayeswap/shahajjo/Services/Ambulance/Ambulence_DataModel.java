package com.kayeswap.shahajjo.Services.Ambulance;

public class Ambulence_DataModel {
        String name;
        String contact;
        String location;

        public Ambulence_DataModel() {
        }

        public Ambulence_DataModel(String name,String contact, String location) {
            this.name = name;
            this.contact = contact;
            this.location = location;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }


        public String getLocation() {
            return location;
        }

        public void setLocation(String address) {
            this.location = address;
        }
    }

