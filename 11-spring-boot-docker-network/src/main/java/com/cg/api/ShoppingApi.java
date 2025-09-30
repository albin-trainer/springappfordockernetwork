package com.cg.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Product;
import com.cg.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ShoppingApi {
	Logger log=LoggerFactory.getLogger(ShoppingApi.class);
	@Autowired
	private ProductService prodService;
	@GetMapping("test")
	public String test() {
		return "Test";
	}
	@PostMapping
	public Product addNewProduct(@RequestBody @Valid   Product p) {
		log.info("adding new product");
		return prodService.addProductService(p);
	}
	@GetMapping("/{id}")
	public Product searchById(@PathVariable("id")  int id) {
		return prodService.searchProductServiceById(id);
	}
	@PutMapping("/{id}")
	public Product updateProduct(@RequestBody Product p,int id) {
		return null;
	}
	public void delProduct(int id) {
	}
	@GetMapping
	public List<Product> getAllProducts(){
		return prodService.allProductsService();
	}
	//products/searchbyname?name=
	@GetMapping("searchbyname")
	public List<Product> searchByProductName(@RequestParam("name")String name){
		return prodService.searchByName(name);
	}
}
