package Database;

import java.util.HashMap;

import Bean.MemberInfo;

public class naver {

	HashMap<String, String> map = new HashMap<String, String>();

	public naver() {
		super();
	}

	public void InsertMember(MemberInfo minf) {

		map.put(minf.getId(), minf.getPassword());
	}

	public boolean MemberCheck(MemberInfo minf) {

		if (map.get(minf.getId()) == null) return false;
		else return (map.get(minf.getId()).equals((String) minf.getPassword()));
		

	}

}
