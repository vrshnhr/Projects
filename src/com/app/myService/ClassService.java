package com.app.myService;

import com.app.myDao.InterfaceDao;
import com.app.pojos.Admin;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.app.pojos.Vendor;

@Service("dao_based_service")
@Transactional
public class ClassService implements InterfaceService {

	@Autowired
	private InterfaceDao dao;
	public ClassService() {
	System.out.println("in service class CTOR");
	}
	@Override
	public Admin ValidateAdmin(String em, String ps) {
		return dao.ValidateAdmin(em, ps);
	}

}
