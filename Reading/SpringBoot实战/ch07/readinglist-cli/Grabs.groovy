@Grab("h2")
@Grab("spring-boot-starter-thymeleaf")
@Grab("spring-boot-starter-remote-shell")
// The remote-shell starter transitively grabs the actuator starter
// @Grab("spring-boot-starter-actuator")
class Grabs {}