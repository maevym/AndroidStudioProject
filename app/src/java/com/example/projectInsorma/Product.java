package com.example.projectinsorma_maevymarvella;

public class Product {
    String ProductName, ProductDescription, ProductRating, ProductPrice;
    int ProductImage;
    Integer ProductId;

    public Product(String productName, String productDescription, String productRating, String productPrice, int productImage, Integer productId) {
        ProductName = productName;
        ProductDescription = productDescription;
        ProductRating = productRating;
        ProductPrice = productPrice;
        ProductImage = productImage;
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductDescription() {
        return ProductDescription;
    }

    public void setProductDescription(String productDescription) {
        ProductDescription = productDescription;
    }

    public String getProductRating() {
        return ProductRating;
    }

    public void setProductRating(String productRating) {
        ProductRating = productRating;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(String productPrice) {
        ProductPrice = productPrice;
    }

    public int getProductImage() {
        return ProductImage;
    }

    public void setProductImage(int productImage) {
        ProductImage = productImage;
    }

    public Integer getProductId() {
        return ProductId;
    }

    public void setProductId(Integer productId) {
        ProductId = productId;
    }
}
