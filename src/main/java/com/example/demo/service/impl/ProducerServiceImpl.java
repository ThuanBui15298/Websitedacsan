package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.validator.internal.engine.messageinterpolation.parser.MessageDescriptorFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.Producer;
import com.example.demo.model.CreateProducerRequest;
import com.example.demo.model.ProducerDatatablesModel;
import com.example.demo.repository.ProducerRepository;
import com.example.demo.service.ProducerService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {

	@Autowired
	private ProducerRepository producerRepository;

	@Override
	public ProducerDatatablesModel getAllProducer() {
		// TODO Auto-generated method stub
		return ProducerDatatablesModel.converter(this.producerRepository.findAll());
	}

	@Transactional
	@Override
	public void createProducer(CreateProducerRequest createProducerRequest)  throws Exception  {
		Producer producer = new Producer();
		Producer producerName = producerRepository.getByFindName(createProducerRequest.getName());

		if (null == producerName) {
			producer.setName(createProducerRequest.getName());
			producer.setDescipsion(createProducerRequest.getDescipsion());
			this.producerRepository.save(producer);
		} else {
			System.out.println("da ton tai san pham");
			throw new MessageDescriptorFormatException("da ton tai san pham");
		}
	}

	@Transactional
	@Override
	public void updateProducer(CreateProducerRequest createProducerRequest) {
		Optional<Producer> producerItems = producerRepository.findById(createProducerRequest.getId());
		Producer producer = producerItems.get();
		if (producerItems.isPresent()) {
			Producer producerName = producerRepository.getByFindName(createProducerRequest.getName());

			if (null == producerName) {
				producer.setName(createProducerRequest.getName());
				producer.setDescipsion(createProducerRequest.getDescipsion());
				this.producerRepository.save(producer);
			} else {
				System.out.println("da ton tai san pham");
				throw new MessageDescriptorFormatException("da ton tai san pham");
			}
			
			producerRepository.save(producer);
		} else {
			System.out.println("Lỗi không update được CSDL");
		}
	}

	@Override
	public List<Producer> findName(String likeName) {
		return producerRepository.findName(likeName);
	}

	@Override
	public void deleteById(Long id) {
		producerRepository.deleteById(id);
	}

	@Override
	public void updateById(Producer producer) {
		producerRepository.save(producer);
	}

}
