package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.validator.internal.engine.messageinterpolation.parser.MessageDescriptorFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.Campaign;
import com.example.demo.model.CampaignDatatablesModel;
import com.example.demo.model.CreateCampaignRequest;
import com.example.demo.repository.CampaignRepository;
import com.example.demo.service.CampaignService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CampaignServiceImpl implements CampaignService {

	@Autowired
	private CampaignRepository campaignRepository;

	@Override
	public CampaignDatatablesModel getAllCampaign() {
		// TODO Auto-generated method stub
		return CampaignDatatablesModel.converter(this.campaignRepository.findAll());
	}

	// creat
	@Transactional
	@Override
	public void createCampaign(CreateCampaignRequest createCampaignRequest) throws Exception{
		Campaign campaign = new Campaign();

		Campaign campaignName = campaignRepository.getByFindName(createCampaignRequest.getName());

		if (null == campaignName) {
			campaign.setName(createCampaignRequest.getName());
			campaign.setDesciption(createCampaignRequest.getDesciption());
			campaign.setImages(createCampaignRequest.getImages());
			this.campaignRepository.save(campaign);
		} else {
			System.out.println("da ton tai san pham");
			throw new MessageDescriptorFormatException("da ton tai san pham");
		}

	}

	// update
	@Transactional
	@Override
	public void updateCampaign(CreateCampaignRequest createCampaignRequest) {
		Optional<Campaign> campaignItems = campaignRepository.findById(createCampaignRequest.getId());
		Campaign campaign = campaignItems.get();
		if (campaignItems.isPresent()) {
			Campaign campaignName = campaignRepository.getByFindName(createCampaignRequest.getName());

			if (null == campaignName) {
				campaign.setName(createCampaignRequest.getName());
				campaign.setDesciption(createCampaignRequest.getDesciption());
				campaign.setImages(createCampaignRequest.getImages());
				this.campaignRepository.save(campaign);
			} else {
				System.out.println("da ton tai san pham");
				throw new MessageDescriptorFormatException("da ton tai san pham");
			}

			campaignRepository.save(campaign);

		} else {
			System.out.println("Lỗi không update được CSDL");
		}
	}

//	@Override
//	public void deleteCampaignBySpringData(Long id) {
//		// TODO Auto-generated method stub
//		Optional<Campaign> campaign = campaignRepository.findById(id);
//		campaign.ifPresent(campaignRepository::delete);
//	}

//	@Override
//	public Campaign getCampaignById(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public List<Campaign> findName(String likeName) {
		return campaignRepository.findName(likeName);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		campaignRepository.deleteById(id);
	}

	@Override
	public void updateById(Campaign campaign) {
		// TODO Auto-generated method stub
		campaignRepository.save(campaign);
	}

}
