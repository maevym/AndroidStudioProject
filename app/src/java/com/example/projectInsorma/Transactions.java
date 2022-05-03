package com.example.projectinsorma_maevymarvella;

public class Transactions {
    Integer UserID, ProductID, TransactionID;
    String TransactionDate, Quantity;

    public Transactions(Integer userID, Integer productID, Integer transactionID, String transactionDate, String quantity) {
        UserID = userID;
        ProductID = productID;
        TransactionID = transactionID;
        TransactionDate = transactionDate;
        Quantity = quantity;
    }

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public Integer getProductID() {
        return ProductID;
    }

    public void setProductID(Integer productID) {
        ProductID = productID;
    }

    public Integer getTransactionID() {
        return TransactionID;
    }

    public void setTransactionID(Integer transactionID) {
        TransactionID = transactionID;
    }

    public String getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        TransactionDate = transactionDate;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }
}
