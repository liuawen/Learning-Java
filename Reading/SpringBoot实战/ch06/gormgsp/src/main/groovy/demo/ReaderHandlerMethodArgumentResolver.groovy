package demo

import org.springframework.core.MethodParameter
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer

@Component
class ReaderHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

  boolean supportsParameter(MethodParameter parameter) {
    Reader.class.isAssignableFrom(parameter.getParameterType())
  }

  def resolveArgument(MethodParameter parameter,
      ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
      WebDataBinderFactory binderFactory) throws Exception {

    Authentication auth = (Authentication) webRequest.getUserPrincipal()
    auth != null && auth.getPrincipal() instanceof Reader ? auth.getPrincipal() : null
  }

}
