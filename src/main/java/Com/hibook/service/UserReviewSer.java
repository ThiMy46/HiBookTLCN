package Com.hibook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.hibook.dao.UserReviewDAO;
import Com.hibook.entity.UserReview;
import Com.hibook.imp.UserReviewImp;

@Service
public class UserReviewSer implements UserReviewImp{

	@Autowired UserReviewDAO userReviewDAO;

	public List<UserReview> getAllUserReview() {
		return userReviewDAO.getAllUserReview();
	}

	public boolean deleteUserReview(int idReview) {
		return userReviewDAO.deleteUserReview(idReview);
	}
}
