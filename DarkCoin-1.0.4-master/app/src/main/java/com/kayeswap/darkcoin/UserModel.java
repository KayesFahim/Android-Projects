package com.kayeswap.darkcoin;

public class UserModel {
   private String userName;
   private  String userEmail;
   private String userPhone;
   private  String userRef;
   private String userCoin;
   private String paymentCoin;
   private String paymentMethod;


   public UserModel() {
   }

   public UserModel(String userName, String userEmail, String userPhone, String userRef, String userCoin) {
      this.userName = userName;
      this.userEmail = userEmail;
      this.userPhone = userPhone;
      this.userRef = userRef;
      this.userCoin = userCoin;
   }

   public UserModel(String paymentCoin ,String paymentMethod) {
      this.paymentCoin = paymentCoin;
      this.paymentMethod = paymentMethod;
   }



   public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public String getUserEmail() {
      return userEmail;
   }

   public void setUserEmail(String userEmail) {
      this.userEmail = userEmail;
   }

   public String getUserPhone() {
      return userPhone;
   }

   public void setUserPhone(String userPhone) {
      this.userPhone = userPhone;
   }

   public String getUserRef() {
      return userRef;
   }

   public void setUserRef(String userRef) {
      this.userRef = userRef;
   }

   public String getUserCoin() {
      return userCoin;
   }

   public void setUserCoin(String userCoin){
      this.userCoin = userCoin;
   }

   public String getPaymentCoin() {

      return paymentCoin;
   }

   public void setPaymentCoin(String paymentCoin){
      this.paymentCoin = paymentCoin;
   }
   public String getPaymentMethod() {
      return paymentMethod;
   }

   public void setPaymentMethod(String paymentMethod){

      this.paymentMethod = paymentMethod;
   }
}
