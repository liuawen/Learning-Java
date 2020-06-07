package cn.mldn.microboot.service;

import java.util.Map;
import java.util.Set;

import cn.mldn.microboot.vo.Member;

public interface IMemberService {
	public Member get(String mid) ;
	public Map<String,Set<String>> getRoleAndActionByMember(String mid) ;
}
