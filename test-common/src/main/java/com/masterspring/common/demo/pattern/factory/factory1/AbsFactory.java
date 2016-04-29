package com.masterspring.common.demo.pattern.factory.factory1;

public abstract class AbsFactory {
	private ISuperProduct isp;

	public abstract ISuperProduct getIsp();

	public AbsFactory() {
		isp = this.getIsp();
	}

	public void save(Long userId) {
		isp.delInfo(userId);
	}

	public void delInfo(Long userId) {
		// TODO Auto-generated method stub
		isp.delInfo(userId);
	}

}
