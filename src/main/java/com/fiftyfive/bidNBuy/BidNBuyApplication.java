package com.fiftyfive.bidNBuy;

import com.fiftyfive.bidNBuy.dto.ProductDTO;
import com.fiftyfive.bidNBuy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BidNBuyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BidNBuyApplication.class, args);
	}

	@Bean(initMethod="runAfterObjectCreated")
	public BeanInitMethodImpl getFunnyBean() {
		return new BeanInitMethodImpl();
	}
}

class BeanInitMethodImpl {

	@Autowired private ProductService service;

	public void runAfterObjectCreated() {
		System.out.println("yooooooooo......... someone called me");
		service.create(new ProductDTO(null, "Apple iPhone 11", "", 41000.00, null, null));
		service.create(new ProductDTO(null, "Apple iPhone 12", "", 42000.00, null, null));
		service.create(new ProductDTO(null, "Apple iPhone 13", "", 43000.00, null, null));
		service.create(new ProductDTO(null, "Apple iPhone 14", "", 44000.00, null, null));
		service.create(new ProductDTO(null, "Apple iPhone 15", "", 45000.00, null, null));
	}
}
