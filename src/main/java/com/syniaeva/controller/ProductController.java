package com.syniaeva.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
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
 *
 * @author Denys Skalenko
 */
@RestController
@EnableWebMvc
@RequestMapping(value = "/products", headers = "Accept=*/*")
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
			consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public
	@ResponseBody
	List<Product> getAllProducts() {
		return productService.getAll();
	}

	@RequestMapping(value = "/categories", method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
			consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public
	@ResponseBody
	List<Category> getAllCategories() {
		return categoryService.getAll();
	}

	@RequestMapping(value = "/categories/del/{categoryCode}", method = RequestMethod.POST,
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
			consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody void deleteCategory(@PathVariable("categoryCode") String categoryCode) {
		System.out.println(categoryCode);
		for (String name: getCategoriesToDelete(categoryCode)) {
			System.out.println(name);
		}
		Arrays.stream(getCategoriesToDelete(categoryCode)).forEach(categoryName -> categoryService.delete(categoryName));
	}

	@RequestMapping(value = "/manufacturers", method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
			consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<Manufacturer> getAllManufacturers() {
		return manufacturerService.getll();
	}

	private String[] getCategoriesToDelete(String categoryCode) {
		switch (categoryCode) {
			case "1":
				return new String[] {"Крупная бытовая техника", "Холодильники", "Стиральные машины", "Газовые плиты"};
			case "1.1":
				return new String[] {"Холодильники"};
			case "1.2":
				return new String[] {"Стиральные машины"};
			case "1.3":
				return new String[] {"Холодильники"};
			case "2":
				return new String[] {"Мелкая бытовая техника", "Пылесосы", "Электрочайники"};
			case "2.1":
				return new String[] {"Пылесосы"};
			case "2.2":
				return new String[] {"Электрочайники"};
			case "3":
				return new String[] {"Телевизоры и аксессуары", "Телевизоры", "Акустика Hi-Fi", "Домашние кинотеатры",
						"DVD/HD-медиаплееры", "Аксессуары"};
			case "3.1":
				return new String[] {"Телевизоры"};
			case "3.2":
				return new String[] {"Акустика Hi-Fi"};
			case "3.3":
				return new String[] {"Домашние кинотеатры"};
			case "3.4":
				return new String[] {"DVD/HD-медиаплееры"};
			case "3.5":
				return new String[] {"Аксессуары"};
			default:
				return new String[0];
		}
	}

}
