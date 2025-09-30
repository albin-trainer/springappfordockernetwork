package com.cg.dto;
public class Product {
private int prodId;
private String prodName;
private float price;
private String serverPort;
public Product() {
}
public Product(int prodId, String prodName, float price, String serverPort) {
	super();
	this.prodId = prodId;
	this.prodName = prodName;
	this.price = price;
	this.serverPort = serverPort;
}


public int getProdId() {
	return prodId;
}
public void setProdId(int prodId) {
	this.prodId = prodId;
}
public String getProdName() {
	return prodName;
}
public void setProdName(String prodName) {
	this.prodName = prodName;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public String getServerPort() {
	return serverPort;
}
public void setServerPort(String serverPort) {
	this.serverPort = serverPort;
}


}
