package config;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * 
 * @author Rafal Slowik
 * @date 9 Mar 2017
 *
 */
public class ConfigProperties {

	private ConfigProperties() {
	}

	private static final ResourceBundle bundle = ResourceBundle.getBundle("config");

	public String findByKey(String key) {
		return bundle.getString(key);
	}

	public String formatProperty(String key, Object... argumentsToReplace) {
		String pattern = findByKey(key);
		return MessageFormat.format(pattern, argumentsToReplace);
	}

	public static ConfigProperties getInstance() {
		return SingletonHelper.INSTANCE;
	}

	private static class SingletonHelper {
		private static ConfigProperties INSTANCE = new ConfigProperties();
	}
}
