package com.example.demo.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.Supplier;
import com.example.demo.model.CreateSupplierRequest;
import com.example.demo.model.SupplierDatatablesModel;



public interface SupplierService {

	SupplierDatatablesModel getAllSupplier();

	@Transactional
    void createSupplier(CreateSupplierRequest createSupplierRequest) throws Exception;

    void updateSupplier(CreateSupplierRequest createSupplierRequest);

	List <Supplier> findName(String likeName);
	
	void deleteById(Long id);
	
	void updateById(Supplier supplier);
}
