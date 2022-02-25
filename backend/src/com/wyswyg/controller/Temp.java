package com.wyswyg.controller;

import java.sql.Connection;

import com.wyswyg.utils.DbConnector;

public class Temp {

	public static void main(String[] args) {
		Connection dbCon = DbConnector.getConnection();
		System.out.println(dbCon);
	}

}
