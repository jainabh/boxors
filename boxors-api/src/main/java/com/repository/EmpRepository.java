package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import com.domain.EmpDO;

@Component("empDao")
public interface EmpRepository extends PagingAndSortingRepository<EmpDO, Long>{

	@Query("SELECT p FROM EmpDO p ")
	List<EmpDO> findEmpList();
}
