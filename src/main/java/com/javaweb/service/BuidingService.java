package com.javaweb.service;

import java.util.List;

import com.javaweb.model.BuidingDTO;



public interface BuidingService {
	public List<BuidingDTO> findAll(String name);
}
