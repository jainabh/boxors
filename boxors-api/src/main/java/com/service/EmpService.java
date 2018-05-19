package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.domain.EmpDO;
import com.repository.EmpRepository;

@Component
@Transactional
public class EmpService {

	@Autowired
	private EmpRepository empDao;

	public List<EmpDO> getEmpList() {
		return empDao.findEmpList();
	}

	public EmpDO saveEmp(EmpDO empDO) {
		empDao.save(empDO);
		return empDO;
	}
	
	public void deleteEmp(EmpDO empDO){
		empDao.delete(empDO);
	}
	
	public EmpDO getEmpById(String empId){
		return empDao.findOne(Long.valueOf(empId));
	}
}
