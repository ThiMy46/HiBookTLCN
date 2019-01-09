package Com.hibook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Com.hibook.entity.Promotion;
import Com.hibook.service.PromotionsSer;

@RestController
@RequestMapping(value = "/api")
public class PromotionAPIController {

	@Autowired
	PromotionsSer promotionsSer;
	@GetMapping(value = "/manager-promotion")
	public ResponseEntity<List<Promotion>> loadPromotion(){
		List<Promotion> listPromotion=promotionsSer.getAllPromotion();
		List<Promotion> loadlist=new ArrayList<Promotion>();
		for (Promotion uPro : listPromotion) {
			Promotion promotion =new Promotion();
			promotion.setIdPromotion(uPro.getIdPromotion());
			promotion.setTitlePromotion(uPro.getTitlePromotion());
			promotion.setContentPromotion(uPro.getContentPromotion());
			promotion.setTimeStart(uPro.getTimeStart());
			promotion.setTimeEnd(uPro.getTimeEnd());
			promotion.setPicPromotion(uPro.getPicPromotion());
			promotion.setSaleOff(uPro.getSaleOff());
			
			loadlist.add(promotion);
		}
		if(loadlist.isEmpty()) {
			return new ResponseEntity<List<Promotion>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<Promotion>>(loadlist,HttpStatus.OK);
		
	}
}
