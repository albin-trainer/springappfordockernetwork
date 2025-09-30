package com.cg.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.cg.dto.Product;
@Service
public class ProductService {
List<Product> plist= new ArrayList<>();
@Autowired
private Environment env;
void init() {
	String port=env.getProperty("local.server.port");
	plist.add(new Product(101, "T Shirt", 1000, port)  );
	plist.add(new Product(102, "Bag", 2000, port)  );
	plist.add(new Product(103, "Shoes", 4000, port)  );
	plist.add(new Product(104, "Watch", 5000, port)  );
	plist.add(new Product(105, "Laptop", 100000, port)  );

}
public Product searchByProductId(int id) {
	init();
	return plist.stream().filter(p->p.getProdId()==id).findFirst().get();
}
}
