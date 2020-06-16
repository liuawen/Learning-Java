package cn.mldn.mldnboot.actuator;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
@Component
public class MicroServiceInfoContributor implements InfoContributor {
	@Override
	public void contribute(Builder builder) {
		builder.withDetail("company.name", "www.mldn.cn") ;
		builder.withDetail("version", "V1.0") ;
		builder.withDetail("author", "李兴华") ;
	}
}

