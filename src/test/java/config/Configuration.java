package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Config.Sources({"system:properties", "classpath:general.properties", "classpath:local.properties"})
public interface Configuration extends Config {

  @Key("target")
  String target();

  @Key("browser")
  String browser();

  @Key("url.base")
  String url();

  @Key("timeout")
  int timeout();

  @Key("headless")
  Boolean headless();
}
