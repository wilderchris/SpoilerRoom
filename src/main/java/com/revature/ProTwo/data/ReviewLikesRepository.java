package  com.revature.ProTwo.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.ProTwo.beans.ReviewLikes;
import com.revature.ProTwo.beans.ReviewLikesId;

@Repository
public interface ReviewLikesRepository extends CrudRepository<ReviewLikes, ReviewLikesId> {
	public int countByLiked(boolean liked);
}
