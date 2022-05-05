package com.mindtree.milestone3.service;

import java.util.List;
import java.util.Optional;

import com.mindtree.milestone3.exception.BrandNameNotFoundException;
import com.mindtree.milestone3.model.Brand;
import com.mindtree.milestone3.model.Mobile;
import com.mindtree.milestone3.repository.BrandRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

    @Autowired
    BrandRepo repo;

    public List<Brand> getAllBrands() {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        return repo.findAll(sort);
    }

    // get brand name with mobile
    public Brand getBrand(String name) {
        Optional<Brand> brand = repo.findById(name);
        if (!brand.isPresent()) {
            throw new BrandNameNotFoundException("No such Brand there in database");
        }
        Brand brand2 = brand.get();
        return brand2;

    }

    // create brand
    public Brand createBrand(Brand brand) {
        Brand brand1 = repo.save(brand);
        return brand1;
    }

    // create mobile
    public Brand createMobile(String name, List<Mobile> mobile) {
        Optional<Brand> Brand = repo.findById(name);
        if (!Brand.isPresent()) {
            throw new BrandNameNotFoundException("No such Brand there in database");
        }
        Brand Brand2 = Brand.get();

        Brand2.getMobiles().addAll(mobile);
        Brand Brand1 = repo.save(Brand2);
        return Brand1;
    }

    // get all mobile datas
    public List<Mobile> retrieveMobile(String name) {
        Optional<Brand> brand = repo.findById(name);
        if (!brand.isPresent()) {
            throw new BrandNameNotFoundException("No such Brand there in database");
        }
        Brand brand2 = brand.get();
        return brand2.getMobiles();
    }

    // update cost
    public Brand updateMobileCost(String bname, String mname, double cost) {
        Optional<Brand> brand = repo.findById(bname);
        if (!brand.isPresent()) {
            throw new BrandNameNotFoundException("No such Brand there in database");
        }
        Brand brand2 = brand.get();
        List<Mobile> mobile = brand2.getMobiles();
        for (Mobile mobile2 : mobile) {
            if (mobile2.getName().equals(mname)) {
                mobile2.setPrice(cost);
            }
        }
        repo.save(brand2);
        return brand2;
    }
}
