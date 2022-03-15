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
import com.example.demo.entity.Campaign;
import com.example.demo.model.CampaignDatatablesModel;
import com.example.demo.model.CreateCampaignRequest;
import com.example.demo.service.CampaignService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/campaign")
public class CampaignApi {

	 private final CampaignService campaignService;
	 
	    @GetMapping("/find-all")
	    public CampaignDatatablesModel getAll() {
	        return this.campaignService.getAllCampaign();
	    }

	    @PostMapping("/create")
	    public void createCampaign(@RequestHeader String Authorization, @RequestBody CreateCampaignRequest createCampaignRequest) throws Exception {
	        this.campaignService.createCampaign(createCampaignRequest);
	    }
	    @GetMapping("/update/{id}")
	    public void updateCampaign(@RequestHeader String Authorization,  @PathVariable("id") Long id , @RequestBody CreateCampaignRequest createCampaignRequest) {
	    	createCampaignRequest.setId(id);
	    	this.campaignService.updateCampaign(createCampaignRequest);
	    }
	    
	    
	    @PostMapping(value = "/campaign")
	    private List<Campaign> campaign(@RequestHeader String Authorization, @RequestParam String name) {
		List<Campaign> campaign= campaignService.findName(name);
			return campaign;
		}
	    
	    @GetMapping("/delete/{id}")
		public String deleteCampaign(@RequestHeader String Authorization, @PathVariable("id") Long id) {
	    	campaignService.deleteById(id);
			return "OK !";
		}
}
