package cn.mldn.mldnboot.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicator implements HealthIndicator {
	@Override
	public Health health() {
		int errorCode = 100 ;		// 这个错误的码是通过其它程序获得的
		if (errorCode != 0) {
			return Health.down().withDetail("Error Code", errorCode).build();
		}
		return Health.up().build() ;
	}
}
