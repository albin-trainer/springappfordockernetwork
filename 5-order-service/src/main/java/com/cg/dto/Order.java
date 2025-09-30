package com.cg.dto;

import lombok.Data;

@Data //@Getter + @Setter
public class Order {
	private int prodId;
	private String prodName;
	private float price;
	private String serverPort;
	private int quantity;
}
