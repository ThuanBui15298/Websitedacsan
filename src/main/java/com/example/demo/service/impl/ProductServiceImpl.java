package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.validator.internal.engine.messageinterpolation.parser.MessageDescriptorFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.SearchProductObject;
import com.example.demo.entity.Category;
import com.example.demo.entity.Discaunt;
import com.example.demo.entity.Image;
import com.example.demo.entity.Producer;
import com.example.demo.entity.Product;
import com.example.demo.entity.Supplier;
import com.example.demo.model.CreateProductRequest;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.DiscauntRepository;
import com.example.demo.repository.ImageRepository;
import com.example.demo.repository.ProducerRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ImageRepository imageRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProducerRepository producerRepository;

	@Autowired
	private SupplierRepository supplierRepository;

	@Autowired
	private DiscauntRepository discauntRepositoryt;

	@Override
	public List<Product> getAllProduct() {
		return this.productRepository.findAll();
	}

	// chú ý: tất cả các khai báo dữ liệu id (ví dụ như category category...) từ
	// bảng liên kết đều phải làm như phần bên dưới để check dưc liệu xem có trùng
	// khớp hay không để thêm vào csdl và hiển thị dữ liệu
	@Transactional
	@Override
	public void createProduct(CreateProductRequest createProductRequest) throws Exception {
		Product product = new Product();
		Product productName = productRepository.getByFindName(createProductRequest.getName());
		// check dữ iêu trong DB xem có trùng khớp hay không
		if (null == productName) {
			if (createProductRequest.getCategoryId() != null) {
				Optional<Category> category = categoryRepository.findById(createProductRequest.getCategoryId());
				if (category.isPresent()) {
					product.setCategory(category.get());
				}
			} else {
				// thông báo khi bị lỗi
				throw new MessageDescriptorFormatException("Lỗi khong co category ");
			}

			if (createProductRequest.getProducerId() != null) {
				Optional<Producer> producer = producerRepository.findById(createProductRequest.getProducerId());
				if (producer.isPresent()) {
					product.setProducer(producer.get());
				}
			} else {
				throw new MessageDescriptorFormatException("Lỗi khong co producer");
			}

			if (createProductRequest.getSupplierId() != null) {
				Optional<Supplier> supplier = supplierRepository.findById(createProductRequest.getSupplierId());
				if (supplier.isPresent()) {
					product.setSupplier(supplier.get());
					;
				}
			} else {
				// thông báo khi bị lỗi
				throw new MessageDescriptorFormatException("Lỗi khong co supplier");
			}

			if (createProductRequest.getDiscauntId() != null) {
				Optional<Discaunt> discaunt = discauntRepositoryt.findById(createProductRequest.getDiscauntId());
				if (discaunt.isPresent()) {
					product.setDiscaunt(discaunt.get());
					;
				}
			} else {
				// thông báo khi bị lỗi
				throw new MessageDescriptorFormatException("Lỗi khong co discaunt");
			}

//			Optional<Discaunt> discaunt = discauntRepositoryt.findById(createProductRequest.getId());
//			product.setDiscaunt(discaunt.get());
				
			product.setName(createProductRequest.getName());
			product.setImage(createProductRequest.getImage());
			product.setDesciption(createProductRequest.getDesciption());
			product.setQuantity(createProductRequest.getQuantity());
			product.setPrice(createProductRequest.getPrice());
			product.setOrderInfo(createProductRequest.getOrderInfo());

			Product products = this.productRepository.save(product);
			List<Image> images = new ArrayList<Image>();
			for (Image imageItem : createProductRequest.getImage()) {
				imageItem.setProduct(products);
				images.add(imageItem);
			}
			imageRepository.saveAll(images);
		} else {
			System.out.println("da ton tai san pham");
			throw new MessageDescriptorFormatException("da ton tai san pham");
		}

	}

	@Transactional
	@Override
	public void updateProduct(CreateProductRequest createProductRequest) {
		Optional<Product> productItems = productRepository.findById(createProductRequest.getId());
		Product product = productItems.get();
		if (productItems.isPresent()) {

			Product productName = productRepository.getByFindName(createProductRequest.getName());
			// check dữ iêu trong DB xem có trùng khớp hay không
			if (null == productName) {
				if (createProductRequest.getCategoryId() != null) {
					Optional<Category> category = categoryRepository.findById(createProductRequest.getCategoryId());
					if (category.isPresent()) {
						product.setCategory(category.get());
					}
				} else {
					// thông báo khi bị lỗi
					throw new MessageDescriptorFormatException("Lỗi không có sự hiện diện của danh mục ");
				}

				if (createProductRequest.getProducerId() != null) {
					Optional<Producer> producer = producerRepository.findById(createProductRequest.getProducerId());
					if (producer.isPresent()) {
						product.setProducer(producer.get());
					}
				} else {
					throw new MessageDescriptorFormatException("Lỗi không có sự hiện diện của hãng sản xuất");
				}

				if (createProductRequest.getSupplierId() != null) {
					Optional<Supplier> supplier = supplierRepository.findById(createProductRequest.getSupplierId());
					if (supplier.isPresent()) {
						product.setSupplier(supplier.get());
						;
					}
				} else {
					// thông báo khi bị lỗi
					throw new MessageDescriptorFormatException("Lỗi không có sự hiện diện của nhà cung cấp");
				}

				if (createProductRequest.getDiscauntId() != null) {
					Optional<Discaunt> discaunt = discauntRepositoryt.findById(createProductRequest.getDiscauntId());
					if (discaunt.isPresent()) {
						product.setDiscaunt(discaunt.get());
						;
					}
				} else {
					// thông báo khi bị lỗi
					throw new MessageDescriptorFormatException("Lỗi khong co discaunt");
				}
				product.setName(createProductRequest.getName());
				product.setDesciption(createProductRequest.getDesciption());
				product.setImage(createProductRequest.getImage());
				product.setQuantity(createProductRequest.getQuantity());
				product.setPrice(createProductRequest.getPrice());
				product.setOrderInfo(createProductRequest.getOrderInfo());
				Product products = this.productRepository.save(product);
				List<Image> images = new ArrayList<Image>();
				for (Image imageItem : createProductRequest.getImage()) {
					imageItem.setProduct(products);
					images.add(imageItem);
				}
				imageRepository.saveAll(images);
			} else {
				//System.out.println("Sản phẩm đã tồn tại");
				throw new MessageDescriptorFormatException("Sản phẩm đã tồn tại");
			}

			productRepository.save(product);
		} else {
			System.out.println("Lỗi không update được CSDL");
		}
	}

	@Override
	public void deleteProductBySpringData(Long id) {
		// TODO Auto-generated method stub
		Optional<Product> product = productRepository.findById(id);
		product.ifPresent(productRepository::delete);
	}

	@Override
	public Product getProductById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> findName(String likeName) {
		return productRepository.findName(likeName);

	}

	@Transactional
	@Override
	public void deleteById(Long productId) {
		imageRepository.deleteImageProductId(productId);
		productRepository.deleteById(productId);

	}

	@Override
	public void updateById(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
	}

	@Override
	public Iterable<Product> getProductByNameProductWithoutPaginate(SearchProductObject obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Product> getProductByNameProduct(SearchProductObject obj, int page, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Product> findById(Long price) {
		// TODO Auto-generated method stub
		return productRepository.findPrice(price);
	}

	@Override
	public List<Product> findByCategory(Long categoryId) {
		// TODO Auto-generated method stub
		return productRepository.findByCategory(categoryId);
		 
	}
}
