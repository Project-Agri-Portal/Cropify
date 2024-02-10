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
		
		// Storing the current session connection to perform select query operation
		Connection connection = session.connection();
		try {
			// Converting the Object type to Prefixable so that we can use the respective methods
			Prefixable entity = (Prefixable) object;
			String prefix = entity.getPrefix();			// To fetch the prefix needed to apply to ID
			String tableName = entity.getTableName();	// To fetch the tablename to add in select query
			String idColName = entity.getIdColName();	// To fetch the column name of the primary key of respective tablename
			
			Statement stmt = connection.createStatement();
			// Executing this select query to get the count of rows in the table and based on that allot the
			// necessary ID number and concatenate it with the respective prefix
			ResultSet rs = stmt.executeQuery("select count(" + idColName + ") as id from " + tableName);
			if (rs.next()) {
				// rs.getInt(1) -> '1' specifies the column which we are acting on, here it is the primary key column
				// this will return us the count of rows, and hence adding 1 to the count to allot next ID
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
