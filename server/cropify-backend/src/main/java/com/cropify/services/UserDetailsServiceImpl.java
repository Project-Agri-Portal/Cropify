package com.cropify.services;

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

import com.cropify.dao.UserDetailsRepository;
import com.cropify.entity.UserDetails;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService1 {
	
	@Autowired
	private UserDetailsRepository detailsRepository;
	
	@Override
	public List<UserDetails> getAllUsers() {
		return detailsRepository.findAll();
	}

}
