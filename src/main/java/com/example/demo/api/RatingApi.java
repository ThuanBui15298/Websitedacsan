package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.JwtProvider;
import com.example.demo.entity.Rating;
import com.example.demo.model.RatingDatatablesModel;
import com.example.demo.service.RatingService;
import com.example.demo.service.impl.UserDetailsServiceImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/rating")
public class RatingApi {
	@Autowired
	JwtProvider jwtProvider;
	
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	RatingService ratingService;

	@GetMapping("/find-all")
	public RatingDatatablesModel getAll() {
		return this.ratingService.getAllRating();
	}

	@PostMapping(value = "/rating")
	private List<Rating> rating(@RequestHeader String authorization, @RequestParam Long productId) {
		String token = authorization.substring(7);
		String username = jwtProvider.getUserNameFromJwtToken(token);
		UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);
		List<Rating> rating = ratingService.findName(userDetails.getUsername(), productId);
		return rating;
	}

	@GetMapping("/delete/{id}")
	public String deleteCampaign(@RequestHeader String Authorization, @PathVariable("id") Long id) {
		ratingService.deleteById(id);
		return "OK !";
	}
}
