package com.example.demo.service;


import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.Campaign;
import com.example.demo.model.CampaignDatatablesModel;
import com.example.demo.model.CreateCampaignRequest;

public interface CampaignService {

	CampaignDatatablesModel getAllCampaign();

	@Transactional
    void createCampaign(CreateCampaignRequest createCampaignRequest) throws Exception;

    void updateCampaign(CreateCampaignRequest createCampaignRequest);

//	void deleteCampaignBySpringData(Long id);
//	
//	Campaign getCampaignById(Long id);
	
	List <Campaign> findName(String likeName);
	
	void deleteById(Long id);
	
	void updateById(Campaign campaign);
	
}
