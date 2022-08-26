package logsTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class LoggerEx {

	private static final Logger logger = LogManager.getLogger(LoggerEx.class);  
	@Test
	public void testLogs() {
		logger.debug("debug message");
		logger.info("Sample log");
		logger.info("Hi");
	}
	
}
