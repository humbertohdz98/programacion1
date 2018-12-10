/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classicmodels.Dao;

import com.classicmodels.Model.OfficesModel;
import java.util.ArrayList;

/**
 *
 * @author Humberto Hdz
 */
public interface OfficesDao {
//recibe un objeto de tipo officeModel y crea 
    //una nueva oficina en la base de datos  
    public String createOffice(OfficesModel newOffice);
    // devuelve un listado en las oficinas almacenadas
    // en la tabla  offices
    public ArrayList<OfficesModel> readOffices();
    //recibe un objeto de tipo officemodels y 
    //actualizar una oficina
    public String updateOffice(OfficesModel auxOffice);
    // borra una oficina de la tabla offices 
    // de acuerdo al id recibido 
    public String deleteOffice(String officeCode);
}
