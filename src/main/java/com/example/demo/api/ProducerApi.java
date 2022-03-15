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
import com.example.demo.entity.Producer;
import com.example.demo.model.CreateProducerRequest;
import com.example.demo.model.ProducerDatatablesModel;
import com.example.demo.service.ProducerService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/producer")
public class ProducerApi {

	 private final 	ProducerService producerService;
	    @GetMapping("/find-all")
	    public ProducerDatatablesModel getAll() {
	        return this.producerService.getAllProducer();
	    }

	    @PostMapping("/create")
	    public void createProducer(@RequestHeader String Authorization,
	    		@RequestBody CreateProducerRequest createProducerRequest) throws Exception {
	        this.producerService.createProducer(createProducerRequest);
	    }
	    @GetMapping("/update/{id}")
	    public void updateProducer(@RequestHeader String Authorization, @PathVariable("id") Long id , 
	    		@RequestBody CreateProducerRequest createProducerRequest) {
	    	createProducerRequest.setId(id);
	    	this.producerService.updateProducer(createProducerRequest);
	    }
	    
	    @PostMapping(value = "/producer")
	    private List<Producer> producer(@RequestHeader String Authorization, @RequestParam String name) {
		List<Producer> producer= producerService.findName(name);
			return producer;
		}
	    
	    @GetMapping("/delete/{id}")
		public String deleteProducer(@RequestHeader String Authorization, @PathVariable("id") Long id) {
	    	producerService.deleteById(id);
			return "OK !";
		}
}
