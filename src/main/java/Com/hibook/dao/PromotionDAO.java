package Com.hibook.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import Com.hibook.entity.Promotion;
import Com.hibook.imp.PromotionImp;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class PromotionDAO implements PromotionImp{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Promotion> getAllPromotion() {
		Session session=sessionFactory.getCurrentSession();
		List<Promotion> promotions= session.createQuery("from promotion").getResultList();
		return promotions;
	}

}
