package logsTest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TestLogs {

	private static final Logger logger = LogManager.getLogger(TestLogs.class); 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		logger.info("Test Step1");
		
		logger.debug("value");
		logger.info("this is info");
		
		
		logger.error("got some error");
	}

}
