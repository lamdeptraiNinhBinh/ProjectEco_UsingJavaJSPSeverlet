package com.javaweb.repository;


import java.util.List;

import com.javaweb.repository.entity.BuidingEntity;

public interface BuidingRepository {
	public List<BuidingEntity> findAll(String name);
}
