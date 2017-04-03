package com.syniaeva.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.syniaeva.dao.CategoryDao;
import com.syniaeva.dao.ProductDao;
import com.syniaeva.entity.Category;
import com.syniaeva.entity.MappedProduct;
import com.syniaeva.model.Product;
import com.syniaeva.services.ProductService;
import java.util.function.Supplier;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private CategoryDao categoryDao;

	@Transactional
	public void add(Product product) {
		MappedProduct mappedProduct = new MappedProduct();
		mappedProduct.setName(product.getName());
		mappedProduct.setDescription(product.getDescription());
		mappedProduct.setAvailable(product.isAvailable());
		productDao.save(mappedProduct);
	}

	public void delete(Product product) {
		MappedProduct mappedProduct = getByNameAndManufacturer(product.getName(), product.getManufacturer());
		productDao.delete(mappedProduct);
	}

	public void update(Product product) {
		MappedProduct mappedProduct = getByNameAndManufacturer(product.getName(), product.getManufacturer());
		productDao.update(mappedProduct);
	}

	// this variant of implementation was used to show how findByName() of CategoryDao is working
	@Override
	public List<Product> getByCategory(String categoryName) {
		Category category = categoryDao.findByName(categoryName);
		return productDao.findAll().stream().filter(product -> product.getCategory()
				.equals(category)).map(product -> new Product(product)).collect(Collectors.toList());
	}

	@Override
	public List<Product> getByManufacturer(String manufacturerName) {
		return productDao.findAll().stream().filter(product -> product.getManufacturer().getName()
				.equalsIgnoreCase(manufacturerName)).map(product -> new Product(product)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<Product> getAll() {
		List<MappedProduct> mappedProducts = productDao.findAll();
		List<Product> products = new ArrayList<Product>(mappedProducts.size());
		for (MappedProduct mappedProduct : mappedProducts) {
			Product product = new Product(mappedProduct);
			products.add(product);
		}
		return products;
	}

	private MappedProduct getByNameAndManufacturer(String productName, String manufacturerName) {
		return productDao.findAll().stream().filter(product -> product.getManufacturer().getName()
				.equalsIgnoreCase(manufacturerName)).filter(product -> product.getName()
				.equalsIgnoreCase(productName)).findFirst().get();
	}
}
