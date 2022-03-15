package com.example.demo.service;


import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.Discaunt;
import com.example.demo.model.CreateDiscauntRequest;
import com.example.demo.model.DiscauntDatatablesModel;


public interface DiscauntService {

	DiscauntDatatablesModel getAllDiscaunt();

	@Transactional
    void createDiscaunt(CreateDiscauntRequest createDiscauntRequest) throws Exception;

    void updateDiscaunt(CreateDiscauntRequest createDiscauntRequest);
	
	List <Discaunt> findName(String likeName);
	
	void deleteById(Long id);
	
	void updateById(Discaunt discaunt);
	
}
