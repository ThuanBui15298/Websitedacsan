package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.validator.internal.engine.messageinterpolation.parser.MessageDescriptorFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.Supplier;
import com.example.demo.model.CreateSupplierRequest;
import com.example.demo.model.SupplierDatatablesModel;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.SupplierService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService{
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	@Override
	public SupplierDatatablesModel getAllSupplier() {
		// TODO Auto-generated method stub
		return SupplierDatatablesModel.converter(this.supplierRepository.findAll());
	}

	@Override
	public void createSupplier(CreateSupplierRequest createSupplierRequest)  throws Exception{
		// TODO Auto-generated method stub
		Supplier supplier = new Supplier();
		Supplier supplierName = supplierRepository.getByFindName(createSupplierRequest.getName());
		
		if (null == supplierName) {
			supplier.setName(createSupplierRequest.getName());
			supplier.setDesciption(createSupplierRequest.getDesciption());
			this.supplierRepository.save(supplier);
		} else {
			System.out.println("da ton tai san pham");
			throw new MessageDescriptorFormatException("da ton tai san pham");
		}
	}
	

	@Transactional
	@Override
	public void updateSupplier(CreateSupplierRequest createSupplierRequest) {
		Optional<Supplier> supplierItems = supplierRepository.findById(createSupplierRequest.getId());
		Supplier supplier = supplierItems.get();
		if (supplierItems.isPresent()) {						
			
			Supplier supplierName = supplierRepository.getByFindName(createSupplierRequest.getName());

			if (null == supplierName) {
				supplier.setName(createSupplierRequest.getName());
				supplier.setDesciption(createSupplierRequest.getDesciption());								
				this.supplierRepository.save(supplier);
			} else {
				System.out.println("da ton tai san pham");
				throw new MessageDescriptorFormatException("da ton tai san pham");
			}
			supplierRepository.save(supplier);
		} else {
			System.out.println("Lỗi không update được CSDL");
		}
	}

	@Override
	public List<Supplier> findName(String likeName) {
		// TODO Auto-generated method stub
		return supplierRepository.findName(likeName);
	}

	@Override
	public void deleteById(Long id) {
	supplierRepository.deleteById(id);		
	}

	@Override
	public void updateById(Supplier supplier) {
		// TODO Auto-generated method stub
	supplierRepository.save(supplier);
	}
	
}
