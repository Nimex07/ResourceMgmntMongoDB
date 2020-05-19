package com.faith.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.app.model.RoleDetails;
import com.faith.app.model.User;
import com.faith.app.repository.IRoleDetailsRepo;

@Service
public class RoleDetailsService implements IRoleDetailsService {

	@Autowired
	IRoleDetailsRepo roleRepo;
	
	@Autowired
	private ISequenceGenerator sequenceGenerator;

	@Override
	public List<RoleDetails> listRole() {
		return roleRepo.findAll();
	}

	@Override
	public RoleDetails addRole(RoleDetails roleDetails) {
		roleDetails.setRoleId(sequenceGenerator.generateSequence(User.SEQUENCE_NAME));
		return roleRepo.save(roleDetails);
	}

}
