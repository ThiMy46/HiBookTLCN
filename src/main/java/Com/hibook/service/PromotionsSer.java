package Com.hibook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.hibook.dao.PromotionDAO;
import Com.hibook.entity.Promotion;
import Com.hibook.imp.PromotionImp;

@Service
public class PromotionsSer implements PromotionImp{

	@Autowired
	PromotionDAO promotionDAO;
	
	public List<Promotion> getAllPromotion() {
		return promotionDAO.getAllPromotion();
	}

}
