package com.example.demo.api;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Supplier;
import com.example.demo.model.CreateSupplierRequest;
import com.example.demo.model.SupplierDatatablesModel;
import com.example.demo.service.SupplierService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/supplier")
public class SupplierApi {
	
	private final SupplierService supplierService;
    @GetMapping("/find-all")
    public SupplierDatatablesModel getAll() {
        return this.supplierService.getAllSupplier();
    }

    @PostMapping("/create")
    public void createSupplier(@RequestHeader String Authorization, @RequestBody CreateSupplierRequest createSupplierRequest) throws Exception {
        this.supplierService.createSupplier(createSupplierRequest);
    }
    
    @GetMapping("/update/{id}")
    public void updateSupplier(@RequestHeader String Authorization, @PathVariable("id") Long id , @RequestBody CreateSupplierRequest createSupplierRequest) {
    	createSupplierRequest.setId(id);
    	this.supplierService.updateSupplier(createSupplierRequest);	    
    }
    
    @PostMapping(value = "/supplier")
    private List<Supplier> supplier(@RequestHeader String Authorization, @RequestParam String name) {
	List<Supplier> supplier= supplierService.findName(name);
		return supplier;
	}
    
    @GetMapping("/delete/{id}")
	public String deleteSupplier(@RequestHeader String Authorization, @PathVariable("id") Long id) {
    	supplierService.deleteById(id);
		return "OK !";
	}
}
