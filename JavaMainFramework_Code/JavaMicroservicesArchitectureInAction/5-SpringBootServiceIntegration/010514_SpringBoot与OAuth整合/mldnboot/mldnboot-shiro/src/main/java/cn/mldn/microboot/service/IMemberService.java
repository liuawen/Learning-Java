package cn.mldn.microboot.service;

import java.util.Map;
import java.util.Set;

public interface IMemberService {
	public Map<String,Set<String>> getRoleAndActionByMember(String mid) ;
}
