package com.javaweb.service.imp;

import java.util.ArrayList;
import java.util.List;

import com.javaweb.model.BuidingDTO;
import com.javaweb.repository.BuidingRepository;
import com.javaweb.repository.entity.BuidingEntity;
import com.javaweb.repository.imp.BuidingRepositoryImp;
import com.javaweb.service.BuidingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuidingServiceImpl implements BuidingService {
	public BuidingServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private BuidingRepository buidingRepository;
//	private BuidingRepositoryImp buidingRepositoryImp = new BuidingRepositoryImp();

	@Override
	public List<BuidingDTO> findAll(String name) {
		List<BuidingEntity> buidingEntities = buidingRepository.findAll(name);

		List<BuidingDTO> buidingDTOs = new ArrayList<>();

		for (BuidingEntity item : buidingEntities) {
			BuidingDTO buidingDTO = new BuidingDTO();
			buidingDTO.setName(item.getName());
			buidingDTO.setAddress(item.getStreet() + "," + item.getWard());
			buidingDTO.setNumberOfBasement(item.getNumberOfBasement());
			buidingDTOs.add(buidingDTO);
		}

		return buidingDTOs;
	}

}
