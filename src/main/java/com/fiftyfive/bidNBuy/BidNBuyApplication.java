package com.fiftyfive.bidNBuy;

import com.fiftyfive.bidNBuy.dto.ProductDTO;
import com.fiftyfive.bidNBuy.enums.ProductCategory;
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
		service.create(new ProductDTO(null, "Apple iPhone 13 (128GB) - Pink", "https://m.media-amazon.com/images/I/61l9ppRIiqL._SL1500_.jpg", 62000.00, ProductCategory.Mobiles, null, null, null , null));
		service.create(new ProductDTO(null, "Apple iPhone 14 Pro 128GB Deep Purple", "https://m.media-amazon.com/images/I/61HHS0HrjpL._SL1500_.jpg", 123000.00, ProductCategory.Mobiles, null, null, null , null));
		service.create(new ProductDTO(null, "Samsung Galaxy S22 5G (Phantom White, 8GB RAM, 128GB Storage)", "https://m.media-amazon.com/images/I/71HUnJvHsbL._SL1500_.jpg", 53000.00, ProductCategory.Mobiles, null, null, null , null));
		service.create(new ProductDTO(null, "Sony MHC-V43D Wireless Bluetooth Party Speaker (Black)", "https://m.media-amazon.com/images/I/71djbDBVznL._SL1500_.jpg", 62000.00, ProductCategory.Speakers, null, null, null , null));
		service.create(new ProductDTO(null, "JBL Partybox 310 | Portable Bluetooth Party Speaker | 240W Monstrous Pro Sound | Dynamic Light Show (Black)", "https://m.media-amazon.com/images/I/71isiSO138L._SL1500_.jpg", 42000.00, ProductCategory.Speakers, null, null, null , null));
		service.create(new ProductDTO(null, "JBL PartyBox 100 by Harman Portable Bluetooth Party Speaker (160 Watts, Black)", "https://m.media-amazon.com/images/I/81a-xiedCKL._SL1500_.jpg", 32000.00, ProductCategory.Speakers, null, null, null , null));
		service.create(new ProductDTO(null, "Sony WF-1000XM4 Active Noise Cancellation Bluetooth 5.2 TWS Bluetooth in Ear Earbuds", "https://m.media-amazon.com/images/I/61G9yF+ZbEL._SL1500_.jpg", 17000.00, ProductCategory.Earphones, null, null, null , null));
		service.create(new ProductDTO(null, "Bose Quietcomfort Noise Cancelling Bluetooth Truly Wireless in Ear Earbuds with Mic", "https://m.media-amazon.com/images/I/610DtEDib2L._SL1500_.jpg", 21000.00, ProductCategory.Earphones, null, null, null , null));
		service.create(new ProductDTO(null, "Beats Fit Pro – True Wireless Noise Cancelling Earbuds – Active Noise Cancelling", "https://m.media-amazon.com/images/I/41oloud8vxL._SL1500_.jpg", 21500.00, ProductCategory.Earphones, null, null, null , null));
	}
}
