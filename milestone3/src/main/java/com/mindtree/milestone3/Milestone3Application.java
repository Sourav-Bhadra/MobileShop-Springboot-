package com.mindtree.milestone3;

import java.util.ArrayList;
import java.util.List;

import com.mindtree.milestone3.model.Brand;
import com.mindtree.milestone3.model.Mobile;
import com.mindtree.milestone3.service.BrandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Milestone3Application implements CommandLineRunner{

	@Autowired
	BrandService service;

	public static void main(String[] args) {
		SpringApplication.run(Milestone3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Brand brand = new Brand("Samsung", 101);
		Mobile Mobile1 = new Mobile(1, "J7 DUO", 15000.00);
		Mobile Mobile2 = new Mobile(2, "Galaxy A32", 14000.00);
		Mobile Mobile3 =new Mobile(3, "Galaxy Monster33", 20000.00);
		List<Mobile> Mobiles = new ArrayList<>();
		Mobiles.add(Mobile1);
		Mobiles.add(Mobile2);
		Mobiles.add(Mobile3);
		brand.setMobiles(Mobiles);
		service.createBrand(brand);
		
	}

}
