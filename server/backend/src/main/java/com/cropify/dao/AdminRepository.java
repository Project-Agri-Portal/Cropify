package com.cropify.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cropify.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
