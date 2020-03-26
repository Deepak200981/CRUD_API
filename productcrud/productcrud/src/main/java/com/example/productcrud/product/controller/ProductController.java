package com.example.productcrud.product.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.productcrud.product.model.Product;
import com.example.productcrud.product.model.ProductRepository;

@RestController
public class ProductController {
	List<Product>prodList = new ArrayList<>();
	@Autowired
	private ProductRepository productRepository;
	@RequestMapping(value="/prod-item", method=RequestMethod.POST)
	public ResponseEntity<String> createProd(@RequestBody Product prd) {
		System.out.println(prd.getId());
		System.out.println(prd.getName());
		System.out.println(prd.getMnf());
		System.out.println(prd.getSrl_num());
		System.out.println(prd.getBrand());
		System.out.println(prd.getWeight());
		System.out.println(prd.getCost());
		System.out.println(prd.getExp_dt());
		System.out.println(prd.getMnf_dt());
		prodList.add(prd);
		productRepository.save(prd);
		return new ResponseEntity<String>("Product is created", HttpStatus.CREATED);
	}
	
	public ResponseEntity<Product> saveProducts(@RequestBody Product prod) {
		Product prodSave = productRepository.save(prod); 
		return ResponseEntity.ok().body(prodSave);
	}
	
	
	@RequestMapping(value="/item", method=RequestMethod.GET)
	public ResponseEntity<List<Product>> getProducts() {
		System.out.println(prodList.size());
		return new ResponseEntity<List<Product>>(prodList, HttpStatus.OK);
	}
	
	@RequestMapping(value="/item/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> getProdById(@PathVariable("id") int id) {
		for(Product pro:prodList) {
			if(pro.getId()==id) {
				return new ResponseEntity<>(pro, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("Item not found", HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/item/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> delProdById(@PathVariable("id") int id) {
		for(Iterator<Product> itr=prodList.iterator(); itr.hasNext();) {
			Product prud = itr.next();
			if(prud.getId()==id) {
				itr.remove();
				return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/item/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> editPrudById(@RequestBody Product product, @PathVariable("id") int id) {
		for(Product prud: prodList) {
			if(prud.getId()==id) {
				prud.setName(product.getName());
				prud.setMnf(product.getMnf());
				prud.setSrl_num(product.getSrl_num());
				prud.setBrand(product.getBrand());
				prud.setWeight(product.getWeight());
				prud.setCost(product.getCost());
				prud.setExp_dt(product.getExp_dt());
				prud.setMnf_dt(product.getMnf_dt());
			}
		}
		return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
	}
}


















