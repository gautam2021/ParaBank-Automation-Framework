package utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class LoggerUtil {

    private LoggerUtil() {
	// so no one can create any object
    }

    public static Logger getLogger(Class<?> clazz) {
	return LogManager.getLogger(clazz);
    }

}
