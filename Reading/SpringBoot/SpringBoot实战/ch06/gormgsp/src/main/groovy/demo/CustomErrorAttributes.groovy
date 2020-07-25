package demo

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestAttributes

@Component
class CustomErrorAttributes extends DefaultErrorAttributes {

  Map<String, Object> getErrorAttributes(
      RequestAttributes requestAttributes, boolean includeStackTrace) {
    Map<String, Object> attributes = super.getErrorAttributes(requestAttributes, includeStackTrace)
    attributes["foo"] = "bar"
    attributes
  }
  
}
