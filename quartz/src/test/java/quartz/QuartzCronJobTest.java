package quartz;

import static org.junit.jupiter.api.Assertions.assertTrue;

import lab.schedule.ScheduleLog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:application-context.xml")
@ActiveProfiles("cron")
public class QuartzCronJobTest {

	@BeforeEach
	public void setUp() {
		ScheduleLog.clear();
	}

	@Test
	public void testCronJob() {
		try {
			Thread.sleep(5000);
			assertTrue(ScheduleLog.getStringValue().contains("I'm printing job..."));
			System.out.println("1: " + ScheduleLog.getStringValue());

			int logLength = ScheduleLog.getStringValue().length();

			Thread.sleep(4000);
			System.out.println("2: " + ScheduleLog.getStringValue());
			assertTrue(ScheduleLog.getStringValue().length() > logLength);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void tearDown() throws Exception {
		ScheduleLog.clear();
	}

}