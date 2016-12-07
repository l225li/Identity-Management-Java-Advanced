 package com.linli.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.linli.datamodel.Identity;

public class IdentityService {
	private Connection connection;
	private PreparedStatement preparedStatement;

	public IdentityService() {
		connection = new com.linli.service.MyConnection().getMyConnection();

	}

	public boolean addIdentity(Identity identity) {
		try {
			preparedStatement = connection.prepareStatement("insert into identityTable "
					+ "(firstName,lastName,sex,email,birthDate)"
					+ "values(?,?,?,?,?)");
			
			preparedStatement.setString(1, identity.getFirstName());
			preparedStatement.setString(2, identity.getLastName());
			preparedStatement.setByte(3, identity.getSex());
			preparedStatement.setString(4, identity.getEmail());
			preparedStatement.setString(5, identity.getBirthDate());
			
			preparedStatement.executeUpdate();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	public ArrayList<Identity> queryAllIdentity(){
		ArrayList<Identity> identityList = new ArrayList<Identity>();
		try {
			preparedStatement = connection.prepareStatement("select * from identityTable");
			ResultSet rSet = preparedStatement.executeQuery();
			while(rSet.next()){
				Identity identity = new Identity();
				identity.setUID(rSet.getInt(1));
				identity.setFirstName(rSet.getString(2));
				identity.setLastName(rSet.getString(3));
				identity.setSex(rSet.getByte(4));
				identity.setEmail(rSet.getString(5));
				identity.setBirthDate(rSet.getString(6));
				identityList.add(identity);
			}
			return identityList;
		} catch (SQLException e) {
			// TODO: handle exception
			return null;
		}
		
		
	}
	
	public Identity queryIdentityByID(int id){
		//ArrayList<Identity> identityList = new ArrayList<Identity>();
		try {
			preparedStatement = connection.prepareStatement("select * from identityTable where uid=?");
			preparedStatement.setInt(1, id);
			ResultSet rSet = preparedStatement.executeQuery();
			if(rSet.next()){
				Identity identity = new Identity();
				identity.setUID(rSet.getInt(1));
				identity.setFirstName(rSet.getString(2));
				identity.setLastName(rSet.getString(3));
				identity.setSex(rSet.getByte(4));
				identity.setEmail(rSet.getString(5));
				identity.setBirthDate(rSet.getString(6));
				return identity;
			}
			return null;
		} catch (SQLException e) {
			// TODO: handle exception
			return null;
		}		
	}
	
	public boolean updateIdentity(Identity identity){
		
		try {
			preparedStatement = connection.prepareStatement("update identityTable set firstName=?,lastName=?,"
					+ "sex=?,email=?,birthDate=? where uid=?");
			preparedStatement.setString(1, identity.getFirstName());
			preparedStatement.setString(2, identity.getLastName());
			preparedStatement.setByte(3, identity.getSex());
			preparedStatement.setString(4, identity.getEmail());
			preparedStatement.setString(5, identity.getBirthDate());
			preparedStatement.setInt(6, identity.getUID());
			preparedStatement.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public boolean deleteIdentity(int id){
		try {
			
			preparedStatement = connection.prepareStatement("delete from identityTable where uid=?");
			preparedStatement.setInt(1, id);
			
			preparedStatement.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO: handle exception
			return false;
		}
		
	}
	
	

}
