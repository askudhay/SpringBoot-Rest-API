package com.springboot.ex.HateoasExample.Rest;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.springboot.ex.HateoasExample.Model.Product;

/**
 * Rest Controller Class
 * 
 * @author Udhay
 *
 */
@RestController
@RequestMapping("/product")
public class RestApi {

	static Product product;
	
	/**
	 * Method process GET request
	 * 
	 * @return
	 */
	@GetMapping(value="/")
	public Product getProduct(){		
		return product;
	}
	
	/**
	 * Method process POST request; Also creates Hypermedia link (HATEOAS
	 * constraint) for getting saved product(GET: /)
	 * 
	 * @param prod
	 * @return
	 */
	@PostMapping(value="/")
	public Resource<Product> saveProduct(@RequestBody Product prod){
		
		product = new Product();	
		product.setProductID(prod.getProductID());
		product.setProductName(prod.getProductName());
		
		Resource<Product> resource = new Resource<Product>(product); 		
		
		ControllerLinkBuilder link =  linkTo(methodOn(this.getClass()).getProduct());
		
		resource.add(link.withRel("get-all-products"));
		
		return resource;
	}
}
