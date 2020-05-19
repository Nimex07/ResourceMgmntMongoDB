package com.faith.app.service;

import java.util.List;

import com.faith.app.model.RoleDetails;

public interface IRoleDetailsService {

	public List<RoleDetails> listRole();

	public RoleDetails addRole(RoleDetails roleDetails);
}
