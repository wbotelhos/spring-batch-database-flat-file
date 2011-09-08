package br.com.wbotelhos.spring.batch.writer;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StopWatch;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:dbToCSVJob.xml")
public class PagamentoRowMapperTest {

	private final static Logger logger = Logger.getLogger(PagamentoRowMapperTest.class);

	@Autowired private JobLauncher launcher;
	@Autowired private Job job;

	private JobParameters jobParameters = new JobParameters();

	@Test
	public void testLaunchJob() throws Exception {
		StopWatch sw = new StopWatch();

		sw.start();
		launcher.run(job, jobParameters);
		sw.stop();

		logger.info("TIME ELAPSED: " + sw.prettyPrint());
	}

}