package com.cropify.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.cropify.dao.MachineryRepository;
import com.cropify.entity.Machinery;
import com.cropify.services.MachineryService;

@Service
@Transactional
public class MachineryServiceImpl implements MachineryService {
	
	@Autowired
	private MachineryRepository machineryRepository;
	
	@Override
	public List<Machinery> getAllMachine() {
		return machineryRepository.findAll();
	}

	@Override
	public void addMachine(Machinery machinery) {
		machineryRepository.save(machinery);
	}
	
//	@Override
//	public void updateMachine(String name, String id) {
//		machineryRepository.UpdateMachine(name, id);
//	}
	
}
