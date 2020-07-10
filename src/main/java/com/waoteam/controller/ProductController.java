package com.waoteam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses; 

import com.waoteam.entity.Product;
import com.waoteam.service.ProductService;

@RestController
@Api(tags = "", value = "Product")
@RequestMapping(value="/api")
public class ProductController {

	@Autowired
	private ProductService service;
	
	
	@ApiOperation(value = "Add Product")
	@ApiResponses(
	    value = {
	        @ApiResponse(code = 100, message = "100 is the message"),
	        @ApiResponse(code = 200, message = "Successful Hello World")
	    }
    )
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	
	@ApiOperation(value = "Add Products")
	@ApiResponses(
	    value = {
	        @ApiResponse(code = 100, message = "100 is the message"),
	        @ApiResponse(code = 200, message = "Successful Hello World")
	    }
    )
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products) {
		return service.saveProducts(products);
	}
	
	@ApiOperation(value = "Get Products")
	@GetMapping("/products")
	public List<Product> findAllProducts() {
		return service.getProducts();
	}
	
	@ApiOperation(value = "Get Product By ID")
	@ApiResponses(
	    value = {
	        @ApiResponse(code = 100, message = "100 is the message"),
	        @ApiResponse(code = 200, message = "Successful Hello World")
	    }
    )
	@GetMapping("/productById/{id}")
    public ResponseEntity<Object> findProductById(@PathVariable int id) {
        return new ResponseEntity<Object>(service.getProductById(id), HttpStatus.OK);
    }
	
	@ApiOperation(value = "Get Product By Name")
	@ApiResponses(
	    value = {
	        @ApiResponse(code = 100, message = "100 is the message"),
	        @ApiResponse(code = 200, message = "Successful Hello World")
	    }
    )
	@GetMapping("/product/{name}")
	public Product findProductByName(@PathVariable String name) {
		return service.getProductByName(name);
	}
	
	@ApiOperation(value = "Update Product")
	@ApiResponses(
	    value = {
	        @ApiResponse(code = 100, message = "100 is the message"),
	        @ApiResponse(code = 200, message = "Successful Hello World")
	    }
    )
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}

	@ApiOperation(value = "Delete Product")
	@ApiResponses(
	    value = {
	        @ApiResponse(code = 100, message = "100 is the message"),
	        @ApiResponse(code = 200, message = "Successful Hello World")
	    }
    )
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}

}
