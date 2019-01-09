package Com.hibook.imp;

import java.util.List;

import Com.hibook.entity.UserReview;

public interface UserReviewImp {

	List<UserReview> getAllUserReview();
	boolean deleteUserReview(int idReview);
}
