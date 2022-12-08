package com.administrator.model;
import java.util.List;


public class AdministratorService {

	private AdministratorDAO_interface dao;

	public AdministratorService() {
		dao = new AdministratorJDBCDAO();
	}

	public AdministratorVO updateAd(Integer storeAuditStatus) {

		AdministratorVO AdministratorVO = new AdministratorVO();
		AdministratorVO.setStoreAuditStatus(storeAuditStatus);

		dao.update(AdministratorVO);

		return AdministratorVO;
	}


	public AdministratorVO getOneAd(Integer memberID) {
		return dao.selectMemberID(memberID);
	}

	public List<AdministratorVO> getAll() {
		return dao.getAll();
	}
}
