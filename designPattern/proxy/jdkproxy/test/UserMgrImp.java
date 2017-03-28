package proxy.jdkproxy.test;

import proxy.jdkproxy.test.UserMgr;

public class UserMgrImp implements UserMgr {

	/*
	 * 这里的要求是插入user和插入log同时完成
	 */
	@Override
	public void addUser() {
		System.out.println("插入记录到user表");
		System.out.println("插入日志到log表");
	}

}
