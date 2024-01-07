package com.javaweb.repository.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javaweb.repository.BuidingRepository;
import com.javaweb.repository.entity.BuidingEntity;

import org.springframework.stereotype.Repository;

@Repository
public class BuidingRepositoryImp implements BuidingRepository{
	
	public BuidingRepositoryImp() {
		//TODO Auto-generated constructor stub
	}
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	static final String USER = "root";
	static final String PASS = "lamlam276762";
	@Override
	public List<BuidingEntity> findAll(String name) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM estatebasic.building where name like '%"+ name + "%';";
		
		List<BuidingEntity> result = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				BuidingEntity buiding = new BuidingEntity();
				
				buiding.setName(rs.getString("name"));
				buiding.setStreet(rs.getString("street"));
				buiding.setWard(rs.getString("ward"));
				buiding.setNumberOfBasement(rs.getInt("numberofbasement"));
				
				result.add(buiding);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connected database failed...");
		}
		return result;
	}
    
}
