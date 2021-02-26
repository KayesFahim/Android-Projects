package com.kayeswap.shahajjo.Services.Covid19.CoronaHelpDesk;

public class CovidHelpDeskModel{
        String name;
        String contact;

        public CovidHelpDeskModel() {

        }

        public CovidHelpDeskModel(String name, String contact) {
            this.name = name;
            this.contact = contact;
        }



        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
