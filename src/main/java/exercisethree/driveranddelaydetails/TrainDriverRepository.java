package exercisethree.driveranddelaydetails;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Repository for storing/searching for TrainDriverDetails entities.
 */
public interface TrainDriverRepository extends MongoRepository<TrainDriverDetails, String> {

    public List<TrainDriverDetails> findByTrainId(String trainId);
}
