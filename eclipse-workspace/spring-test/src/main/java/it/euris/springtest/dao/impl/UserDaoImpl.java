package it.euris.springtest.dao.impl;

import org.springframework.stereotype.Component;

import it.euris.springtest.dao.UserDao;

@Component
public class UserDaoImpl implements UserDao {

	@Override
	public Integer getId(String username) {
		Integer res = null;
		switch(username) {
		case "mario":
			res = 1;
			break;
		case "giovanni":
			res = 2;
			break;
		}
		return res;
	}

}
