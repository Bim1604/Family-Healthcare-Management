/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dang.view;

import dang.dao.RegistrationServer;
import dang.dto.RegistrationDTO;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class RegistrationFullModel extends AbstractTableModel {

    RegistrationServer registrationServer;

    public RegistrationFullModel() {
        super();
    }

    public RegistrationFullModel(RegistrationServer registrationServer) {
        this.registrationServer = registrationServer;
    }

    public RegistrationServer getRegistrationServer() {
        return registrationServer;
    }

    @Override
    public int getRowCount() {
        if (registrationServer.getRegistrationList() == null){
            return 0;
        }
        return registrationServer.getRegistrationList().size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int column) {
        String columnName = "";
        switch (column) {
            case 0:
                columnName = "Registration ID";
                break;
            case 1:
                columnName = "Full Name";
                break;
            case 2:
                columnName = "Age";
                break;
            case 3:
                columnName = "Gender";
                break;
            case 4:
                columnName = "Phone";
                break;
            case 5:
                columnName = "Address";
                break;
        }
        return columnName;
    }

    @Override
    public Object getValueAt(int row, int column) {
        RegistrationDTO registrationDTO = registrationServer.getRegistrationList().get(row);
        Object obj = null;
        switch (column) {
            case 0:
                obj = registrationDTO.getRegistrationID();
                break;
            case 1:
                obj = registrationDTO.getFullName();
                break;
            case 2:
                obj = registrationDTO.getAge();
                break;
            case 3:
                obj = registrationDTO.isGender();
                break;
            case 4:
                obj = registrationDTO.getPhone();
                break;
            case 5:
                obj = registrationDTO.getAddress();
                break;
            case 6:
                obj = registrationDTO.getEmail();
                break;
            case 7:
                obj = registrationDTO.getNumberOfMember();
                break;
            case 8:
                obj = registrationDTO.getNumberOfChildren();
                break;
            case 9:
                obj = registrationDTO.getNumberOfAdults();
                break;
        }
        return obj;
    }
}
