package com.example.demo.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.Producer;
import com.example.demo.model.CreateProducerRequest;
import com.example.demo.model.ProducerDatatablesModel;

public interface ProducerService {

	ProducerDatatablesModel getAllProducer();

	@Transactional
    void createProducer(CreateProducerRequest createProducerRequest) throws Exception;

    void updateProducer(CreateProducerRequest createProducerRequest);

	List <Producer> findName(String likeName);
	
	void deleteById(Long id);	

	void updateById(Producer producer);
}
