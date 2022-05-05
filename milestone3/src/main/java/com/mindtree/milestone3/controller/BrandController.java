package com.mindtree.milestone3.controller;

import java.util.Arrays;
import java.util.List;

import com.mindtree.milestone3.model.Brand;
import com.mindtree.milestone3.model.Mobile;
import com.mindtree.milestone3.service.BrandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrandController {

    @Autowired
    BrandService service;
    
    // fetch all brand and corresponding mobiles based on brand name in ascending order
    @GetMapping("/brands")
    public ResponseEntity<List<Brand>> getBrands() {
        return new ResponseEntity<List<Brand>>(service.getAllBrands(), HttpStatus.OK);
    }
    
    //get brand
    @GetMapping("/brands/{name}")
    public ResponseEntity<Brand> getBrand(@PathVariable String name) {
        return new ResponseEntity<Brand>(service.getBrand(name), HttpStatus.FOUND);
    }

    // create brand
    @PostMapping("/brands")
    public ResponseEntity<Brand> createBrand(@RequestBody Brand brand) {
        return new ResponseEntity<Brand>(service.createBrand(brand), HttpStatus.CREATED);
    }

    // get all mobiles
    @GetMapping("/brands/{name}/mobiles")
    public ResponseEntity<List<Mobile>> getMobile(@PathVariable String name) {
        return new ResponseEntity<List<Mobile>>(service.retrieveMobile(name), HttpStatus.FOUND);
    }

    // Create mobile and assign to a brand
    @PostMapping("/brands/{name}/mobiles")
    public ResponseEntity<Brand> createMobile(@PathVariable String name , @RequestBody Mobile[] mobiles) {
        List<Mobile> mobile = Arrays.asList(mobiles);
        return new ResponseEntity<Brand>(service.createMobile(name, mobile), HttpStatus.CREATED);
    }

    // update mobile price
    @PutMapping("/brands/{bname}/mobiles/{mname}/{cost}")
    public ResponseEntity<Brand> updateMobileCost(@PathVariable String bname, @PathVariable String mname,
            @PathVariable double cost) {
        return new ResponseEntity<Brand>(service.updateMobileCost(bname, mname, cost), HttpStatus.OK);
    }

}
