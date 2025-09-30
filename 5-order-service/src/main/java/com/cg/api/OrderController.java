package com.cg.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.cg.dto.Order;
@RestController
@RequestMapping("/orders")
public class OrderController {
	//v must use POST, but here v use GET 
	@Value("${product.service.url}")
	private String url;;
	@GetMapping("/{pid}/{q}")
	public Order orderProducts(@PathVariable("pid")  int pid,@PathVariable("q")  int q) {
		//call product service
		String url="http://localhost:7000/products/"+pid;
		//a rest client like post man
		RestTemplate template=new RestTemplate();
		//access the product-service and receives json data
		//creates obj of Order and set json data in order obj
		//new Order();
		//return order obj
		 Order order= template.getForObject(url, Order.class);
		 order.setQuantity(q);
		 order.setPrice(order.getPrice()*q);
		return order;
	}
	@Autowired
	private RestTemplate template;
	@GetMapping("/loadbal/{pid}/{q}")
	public Order orderProductsLoadBalance(@PathVariable("pid")  int pid,@PathVariable("q")  int q) {
		//call product service
		//String url="http://product-service/products/"+pid;
		 Order order= template.getForObject(url+"/"+pid, Order.class);
		 order.setQuantity(q);
		 order.setPrice(order.getPrice()*q);
		return order;
	}
}
