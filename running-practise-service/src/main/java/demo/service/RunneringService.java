package demo.service;

import demo.domain.RunnerInformation;

/**
 * Created by vagrant on 6/4/17.
 */
public interface RunneringService {
    List<RunnerInformation> saveRunnerInformation(List<RunnerInformation> runnerInformation);

    void deleteAll();

    Page<RunnerInformation>
}
