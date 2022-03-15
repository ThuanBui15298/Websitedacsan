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
import com.example.demo.entity.Discaunt;
import com.example.demo.model.CreateDiscauntRequest;
import com.example.demo.model.DiscauntDatatablesModel;
import com.example.demo.service.DiscauntService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/discaunt")
public class DiscauntApi {

	 private final DiscauntService discauntService;
	    @GetMapping("/find-all")
	    public DiscauntDatatablesModel getAll() {
	        return this.discauntService.getAllDiscaunt();
	    }

	    @PostMapping("/create")
	    public void createDiscaunt(@RequestHeader String Authorization, @RequestBody CreateDiscauntRequest createDiscauntRequest) throws Exception {
	        this.discauntService.createDiscaunt(createDiscauntRequest);
	    }

		@GetMapping("/update/{id}")
		public void updateDiscaunt(@RequestHeader String Authorization, @PathVariable("id") Long id,
				@RequestBody CreateDiscauntRequest createDiscauntRequest) {
			createDiscauntRequest.setId(id);
			this.discauntService.updateDiscaunt(createDiscauntRequest);
		}

		@PostMapping(value = "/discaunt")
		private List<Discaunt> discaunt(@RequestHeader String Authorization, @RequestParam String name) {
			List<Discaunt> discaunt = discauntService.findName(name);
			return discaunt;
		}

		@GetMapping("/delete/{id}")
		public String deleteDiscaunt(@RequestHeader String Authorization, @PathVariable("id") Long id) {
			discauntService.deleteById(id);
			return "OK !";
		}
}
