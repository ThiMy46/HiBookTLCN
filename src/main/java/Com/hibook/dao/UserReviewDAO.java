package Com.hibook.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Com.hibook.entity.UserReview;
import Com.hibook.imp.UserReviewImp;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class UserReviewDAO implements UserReviewImp{

	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public List<UserReview> getAllUserReview() {
		Session session=sessionFactory.getCurrentSession();
		List<UserReview> uReviews= session.createQuery("from userreview").getResultList();
		return uReviews;
	}
	
	@Transactional
	public boolean deleteUserReview(int idReview) {
		Session session=sessionFactory.getCurrentSession();
		Query de= session.createQuery("delete userreview where idReview = :idReview");
		de.setParameter("idReview", idReview);
		
		try{
			de.executeUpdate();
		}catch (Exception e) {
			return false;
		}
		return true;
	}

}
