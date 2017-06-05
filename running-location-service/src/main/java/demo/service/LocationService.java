package demo.service;

import demo.domain.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by vagrant on 5/31/17.
 */
public interface LocationService {
    List<Location> saveRunningLocation(List<Location> runningLocation);

    void deleteAll();

    Page<Location> findByRunnerMovementType(String movementType, Pageable pageable);

    Page<Location> findByRunnerId(String runningId, Pageable pageable);
}
