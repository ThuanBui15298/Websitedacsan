package com.example.demo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.example.demo.entity.Campaign;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CampaignDatatablesModel {
	 private List<List<String>> data;

	    public static CampaignDatatablesModel converter(List<Campaign> campaigns) {
	        List<List<String>> datas = new ArrayList<>();
	        campaigns.forEach(campaign -> datas.add(Arrays.asList(campaign.getId().toString(),
	        		campaign.getName(),
	        		campaign.getDesciption(),
	        		campaign.getImages())));
	        return CampaignDatatablesModel.builder().data(datas).build();
	    }

}
