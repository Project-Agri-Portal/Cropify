package com.cropify.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomIdGenerator implements IdentifierGenerator {
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
		Connection connection = session.connection();
		try {
			Prefixable entity = (Prefixable) object;
			String prefix = entity.getPrefix();
			String tableName = entity.getTableName();
			String idColName = entity.getIdColName();
			
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select count(" + idColName + ") as id from " + tableName);
			if (rs.next()) {
				int id = rs.getInt(1) + 1;
				String generatedId = prefix + id;
				return generatedId;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
