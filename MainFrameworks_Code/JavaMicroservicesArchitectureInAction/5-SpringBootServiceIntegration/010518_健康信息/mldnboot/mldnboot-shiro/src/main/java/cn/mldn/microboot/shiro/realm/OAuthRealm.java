package cn.mldn.microboot.shiro.realm;

import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthBearerClientRequest;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.client.response.OAuthResourceResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.mldn.microboot.service.IMemberService;
import cn.mldn.microboot.shiro.token.OAuthToken;

public class OAuthRealm extends AuthorizingRealm {
	@Resource
	private IMemberService memberService;
	private String clientId; 			// 应该由客户服务器申请获得
	private String clientSecret; 		// 应该由客户服务器申请获得
	private String redirectUri; 		// 返回地址
	private String accessTokenUrl; 		// 进行Token操作的地址定义
	private String memberInfoUrl; 		// 获得用户信息的路径

	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof OAuthToken; // 只有该类型的Token可以执行此Realm
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 此方法主要是实现用户的认证处理操作
		System.err.println("=========== 1、进行用户认证处理操作（doGetAuthenticationInfo()） ===========");
		OAuthToken oAuthToken = (OAuthToken) token; // 强制转型为自定义的OAuthToken，里面有code
		String authCode = (String) oAuthToken.getCredentials(); // 获取OAuth返回的Code数据
		String mid = this.getMemberInfo(authCode);
		return new SimpleAuthenticationInfo(mid, authCode, "memberRealm");
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 此方法主要用于用户的授权处理操作，授权一定要在认证之后进行
		System.err.println("=========== 2、进行用户授权处理操作（doGetAuthorizationInfo()） ===========");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(); // 返回授权的信息
		String mid = (String) principals.getPrimaryPrincipal(); // 获得用户名
		Map<String, Set<String>> map = this.memberService.getRoleAndActionByMember(mid);
		info.setRoles(map.get("allRoles")); // 将所有的角色信息保存在授权信息中
		info.setStringPermissions(map.get("allActions")); // 保存所有的权限
		return info;
	}
	private String getMemberInfo(String code) { // 获取用户的信息
		String mid = null;
		try {
			OAuthClient oauthClient = new OAuthClient(new URLConnectionClient());
			OAuthClientRequest accessTokenRequest = OAuthClientRequest.tokenLocation(this.accessTokenUrl) // 设置Token的访问地址
					.setGrantType(GrantType.AUTHORIZATION_CODE).setClientId(this.clientId)
					.setClientSecret(this.clientSecret).setRedirectURI(this.redirectUri).setCode(code)
					.buildQueryMessage();
			// 构建了一个专门用于进行Token数据回应处理的操作类对象，获得Token的请求是POST
			OAuthJSONAccessTokenResponse oauthResponse = oauthClient.accessToken(accessTokenRequest,
					OAuth.HttpMethod.POST);
			String accessToken = oauthResponse.getAccessToken(); // 获得Token
			// 获得AccessToken设计目的是为了能够通过此Token获得mid的信息，所以此时应该继续构建第二次请求
			// 如果要想获得请求操作一定要设置有accessToken处理信息
			OAuthClientRequest memberInfoRequest = new OAuthBearerClientRequest(this.memberInfoUrl)
					.setAccessToken(accessToken).buildQueryMessage(); // 创建一个请求操作
			// 要进行指定用户信息请求的回应处理项
			OAuthResourceResponse resouceResponse = oauthClient.resource(memberInfoRequest, OAuth.HttpMethod.GET,
					OAuthResourceResponse.class); 
			mid = resouceResponse.getBody(); // 获取mid的信息
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mid; 
	}
	public void setMemberInfoUrl(String memberInfoUrl) {
		this.memberInfoUrl = memberInfoUrl;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}
	public void setAccessTokenUrl(String accessTokenUrl) {
		this.accessTokenUrl = accessTokenUrl;
	}
}
