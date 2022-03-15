package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.validator.internal.engine.messageinterpolation.parser.MessageDescriptorFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.Discaunt;
import com.example.demo.model.CreateDiscauntRequest;
import com.example.demo.model.DiscauntDatatablesModel;
import com.example.demo.repository.DiscauntRepository;
import com.example.demo.service.DiscauntService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiscauntServiceImpl implements DiscauntService {

	@Autowired
	private DiscauntRepository discauntRepository;

	@Override
	public DiscauntDatatablesModel getAllDiscaunt() {
		// TODO Auto-generated method stub
		return DiscauntDatatablesModel.converter(this.discauntRepository.findAll());
	}

	@Transactional
	@Override
	public void createDiscaunt(CreateDiscauntRequest createDiscauntRequest) throws Exception{
		Discaunt discaunt = new Discaunt();
		
		Discaunt discauntName = discauntRepository.getByFindName(createDiscauntRequest.getName());
		
		if (null == discauntName) {
			discaunt.setName(createDiscauntRequest.getName());
			discaunt.setDesciption(createDiscauntRequest.getDesciption());
			this.discauntRepository.save(discaunt);			
		} else {
			System.out.println("da ton tai san pham");
			throw new MessageDescriptorFormatException("da ton tai san pham");
		}			
	}

	@Transactional
	@Override
	public void updateDiscaunt(CreateDiscauntRequest createDiscauntRequest) {
		Optional<Discaunt> discauntItems  = discauntRepository.findById(createDiscauntRequest.getId());
		Discaunt discaunt = discauntItems.get();
		if (discauntItems.isPresent()) {
			
			Discaunt discauntName = discauntRepository.getByFindName(createDiscauntRequest.getName());
			
			if (null == discauntName) {
				discaunt.setName(createDiscauntRequest.getName());
				discaunt.setDesciption(createDiscauntRequest.getDesciption());
				this.discauntRepository.save(discaunt);			
			} else {
				System.out.println("da ton tai san pham");
				throw new MessageDescriptorFormatException("da ton tai san pham");
			}					
			discauntRepository.save(discaunt);  
		} else {
			System.out.println("Lỗi không update được CSDL");
		}		
	}


	@Override
	public List<Discaunt> findName(String likeName) {
		// TODO Auto-generated method stub
		return discauntRepository.findName(likeName);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		discauntRepository.deleteById(id);
		
	}

	@Override
	public void updateById(Discaunt discaunt) {
		// TODO Auto-generated method stub
	discauntRepository.save(discaunt);
	}

}
