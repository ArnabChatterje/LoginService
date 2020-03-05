package com.example.LoginService.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LoginService.Model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {
	
	public List<Login> findByUsernameAndPassword(String username,String password);

}
