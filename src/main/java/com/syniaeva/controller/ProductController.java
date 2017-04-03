package com.syniaeva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.syniaeva.entity.Category;
import com.syniaeva.entity.Manufacturer;
import com.syniaeva.model.Product;
import com.syniaeva.services.CategoryService;
import com.syniaeva.services.ManufacturerService;
import com.syniaeva.services.ProductService;

/**
 * (c) Swissquote 1/18/16
 * @author Denys Skalenko
 */
@RestController
@EnableWebMvc
@RequestMapping(value = "/products",  headers="Accept=*/*")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ManufacturerService manufacturerService;

	@RequestMapping(method = RequestMethod.POST,
			consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public void add(@RequestBody Product product) {
		productService.add(product);
	}

	@RequestMapping(method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
			consumes =  {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<Product> getAllProducts() {
		return productService.getAll();
	}

	@RequestMapping(value = "/categories", method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
			consumes =  {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<Category> getAllCategories() {
		return categoryService.getAll();
	}

	@RequestMapping(value = "/categories/del", method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
			consumes =  {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody void deleteCategory(@RequestParam("categoryName") String categoryName) {
		categoryService.delete(categoryName);
	}

	@RequestMapping(value = "/manufacturers", method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
			consumes =  {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<Manufacturer> getAllManufacturers() {
		return manufacturerService.getll();
	}

}
