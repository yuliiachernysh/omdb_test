package configuration;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"file:${env}.properties"})
public interface ConfigProperties extends Config {
	String baseApiUrl();
	String apiKey();
}