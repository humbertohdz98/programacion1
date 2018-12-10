/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classicmodels.Dao;

import com.classicmodels.Model.OfficesModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Humberto Hdz
 */
public class OfficesDaoImpl implements OfficesDao {

    Conexion con = new Conexion();

    @Override
    public String createOffice(OfficesModel newOffice) {

        String ServerAnswer = null;
        try {
            PreparedStatement preparedStatement = con.getConection().prepareStatement("INSERT INTO OFFICES(officeCode,city,phone,addressLine1,addressLine2,state,country,postalCode,territory) VALUES (?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, newOffice.getOfficeCode());
            preparedStatement.setString(2, newOffice.getCity());
            preparedStatement.setString(3, newOffice.getPhone());
            preparedStatement.setString(4, newOffice.getAnddressLine1());
            preparedStatement.setString(5, newOffice.getAnddressLine2());
            preparedStatement.setString(6, newOffice.getState());
            preparedStatement.setString(7, newOffice.getCountry());
            preparedStatement.setString(8, newOffice.getPostalCode());
            preparedStatement.setString(9, newOffice.getTerritory());

            int numAffectedRows = preparedStatement.executeUpdate();
            if (numAffectedRows > 0) {
                ServerAnswer = "the office was insert";

            }

        } catch (SQLException e) {
            System.out.print("ERROR" + e.getMessage());
            ServerAnswer = "There was an error";
        }
        return ServerAnswer;
    }

    @Override
    public ArrayList<OfficesModel> readOffices() {
        ArrayList<OfficesModel> officesList = new ArrayList();
        OfficesModel auxOffice;

        try {
            PreparedStatement preparedStatement = con.getConection().prepareCall("select * from offices");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                auxOffice = new OfficesModel();

                auxOffice.setOfficeCode(resultSet.getString(1));
                auxOffice.setCity(resultSet.getString(2));
                auxOffice.setPhone(resultSet.getString(3));
                auxOffice.setAddressLine1(resultSet.getString(4));
                auxOffice.setAddressLine2(resultSet.getString(5));
                auxOffice.setState(resultSet.getString(6));
                auxOffice.setCountry(resultSet.getString(7));
                auxOffice.setPostalCode(resultSet.getString(8));
                auxOffice.setTerritory(resultSet.getString(9));

                officesList.add(auxOffice);

            }

        } catch (SQLException e) {
            System.out.print("Error" + e.getLocalizedMessage());
        }

        return officesList;
    }

    @Override
    public String updateOffice(OfficesModel auxOffice) {

        String ServerAnswer = null;
        try {
            Statement preparedStatement = con.getConection().createStatement();

            System.out.println("UPDATE OFFICES SET(officeCode='" + auxOffice.getOfficeCode() + "',city='" + auxOffice.getCity() + "',phone='" + auxOffice.getPhone() + "',addressLine1='" + auxOffice.getAnddressLine1() + "',addressLine2='" + auxOffice.getAnddressLine2() + "',state='" + auxOffice.getState() + "',country='" + auxOffice.getCountry() + "',postalCode='" + auxOffice.getPostalCode() + "',territory='" + auxOffice.getTerritory() + "') where officeCode = '" + auxOffice.getOfficeCode() + "'");

            int numAffectedRows = preparedStatement.executeUpdate("UPDATE OFFICES SET officeCode='" + auxOffice.getOfficeCode() + "',city='" + auxOffice.getCity() + "',phone='" + auxOffice.getPhone() + "',addressLine1='" + auxOffice.getAnddressLine1() + "',addressLine2='" + auxOffice.getAnddressLine2() + "',state='" + auxOffice.getState() + "',country='" + auxOffice.getCountry() + "',postalCode='" + auxOffice.getPostalCode() + "',territory='" + auxOffice.getTerritory() + "' where officeCode = '" + auxOffice.getOfficeCode() + "'");
            if (numAffectedRows > 0) {
                ServerAnswer = "the office was update";

            }

        } catch (SQLException e) {
            System.out.print("ERROR" + e.getMessage());
            ServerAnswer = "There was an error";
        }
        return ServerAnswer;
    }

    @Override
    public String deleteOffice(String officeCode) {
        //DELETE FROM offices WHERE officeCode = 'hj'
        String ServerAnswer = null;
        try {
            Statement preparedStatement = con.getConection().createStatement();

            System.out.println("DELETE FROM offices WHERE officeCode = '" + officeCode + "'");

            preparedStatement.executeUpdate("DELETE FROM offices WHERE officeCode = '" + officeCode + "'");

        } catch (SQLException ex) {
            Logger.getLogger(OfficesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ServerAnswer;
    }

    }
