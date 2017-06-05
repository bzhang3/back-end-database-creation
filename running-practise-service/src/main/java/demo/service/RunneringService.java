package demo.service;

import demo.domain.RunnerInformation;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by vagrant on 6/4/17.
 */
public interface RunneringService {
    List<RunnerInformation> saveRunnerInformation(List<RunnerInformation> runnerInformation);

    void deleteAll();

    Page<RunnerInformation> heartWarningLevel(double heartRate);
}
