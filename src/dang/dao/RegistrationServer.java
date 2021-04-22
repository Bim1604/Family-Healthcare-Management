/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dang.dao;

import dang.dto.RegistrationDTO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 *
 * @author Admin
 */
public class RegistrationServer extends UnicastRemoteObject implements RegistrationInterface {

    private String filename;
    private ArrayList<RegistrationDTO> registrationList;

    public ArrayList<RegistrationDTO> getRegistrationList() {
        return registrationList;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public RegistrationServer(String filename) throws RemoteException {
        super();
        this.filename = filename;
    }

    public RegistrationServer() throws RemoteException {
        super();
        filename = "";
    }

    @Override
    public boolean createRegistration(RegistrationDTO dto) {
        FileWriter f;
        BufferedWriter bf;
        PrintWriter pw = null;
        try {
            f = new FileWriter(filename, true);
            bf = new BufferedWriter(f);
            pw = new PrintWriter(bf);
            pw.println(dto.toString());
        } catch (IOException e) {
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
        return true;
    }

    @Override
    public RegistrationDTO findByRegistrationID(String id) {
        FileReader f;
        BufferedReader bf;
        try {
            f = new FileReader(filename);
            bf = new BufferedReader(f);
            String line;
            StringTokenizer str;
            registrationList = new ArrayList<>();
            while ((line = bf.readLine()) != null) {
                str = new StringTokenizer(line, ",");
                String registrationID = str.nextToken().trim();
                String fullName = str.nextToken().trim();
                int age = Integer.parseInt(str.nextToken().trim());
                boolean gender = Boolean.parseBoolean(str.nextToken().trim());
                String email = str.nextToken().trim();
                String phone = str.nextToken().trim();
                String address = str.nextToken().trim();
                String replaceAddress = address.replaceAll(".!.!", "\n");
                int numberOfMember = Integer.parseInt(str.nextToken().trim());
                int numberOfChildren = Integer.parseInt(str.nextToken().trim());
                int numberOfAdults = Integer.parseInt(str.nextToken().trim());
                RegistrationDTO registrationDTO = new RegistrationDTO(registrationID, fullName, age, gender, email, phone, replaceAddress, numberOfMember, numberOfChildren, numberOfAdults);
                if (registrationDTO.getRegistrationID().equals(id)) {
                    return registrationDTO;
                }
            }
        } catch (IOException | NumberFormatException e) {
        }
        return null;
    }

    @Override
    public ArrayList<RegistrationDTO> findAllRegistrations() {
        FileReader f;
        BufferedReader bf;
        try {
            f = new FileReader(filename);
            bf = new BufferedReader(f);
            String line;
            StringTokenizer str;
            registrationList = new ArrayList<>();
            while ((line = bf.readLine()) != null) {
                str = new StringTokenizer(line, ",");
                String registrationID = str.nextToken().trim();
                String fullName = str.nextToken().trim();
                int age = Integer.parseInt(str.nextToken().trim());
                boolean gender = Boolean.valueOf(str.nextToken().trim());
                String email = str.nextToken().trim();
                String phone = str.nextToken().trim();
                String address = str.nextToken().trim();
                String replaceAddress = address.replaceAll(".!.!", "\n");
                int numberOfMember = Integer.parseInt(str.nextToken().trim());
                int numberOfChildren = Integer.parseInt(str.nextToken().trim());
                int numberOfAdults = Integer.parseInt(str.nextToken().trim());
                RegistrationDTO registrationDTO = new RegistrationDTO(registrationID, fullName, age, gender, email, phone, replaceAddress, numberOfMember, numberOfChildren, numberOfAdults);
                this.registrationList.add(registrationDTO);
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        return registrationList;
    }

    @Override
    public boolean removeRegistration(String id) {
        PrintWriter pw = null;
        registrationList = findAllRegistrations();
        RegistrationDTO removeObj = null;
        boolean remove = false;
        for (RegistrationDTO registrationDTO : registrationList) {
            if (registrationDTO.getRegistrationID().equals(id)) {
                removeObj = registrationDTO;
            }
        }
        registrationList.remove(removeObj);
        try {
            pw = new PrintWriter(filename);
            for (RegistrationDTO registrationDTO : registrationList) {
                pw.println(registrationDTO.toString());
            }
            remove = true;
        } catch (FileNotFoundException e) {
            remove = false;
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
        return remove;
    }

    @Override
    public boolean updateRegistration(RegistrationDTO dto) {
        PrintWriter pw = null;
        registrationList = findAllRegistrations();
        boolean update = false;
        for (RegistrationDTO registrationDTO : registrationList) {
            if (registrationDTO.getRegistrationID().equals(dto.getRegistrationID())) {
                registrationDTO.setFullName(dto.getFullName());
                registrationDTO.setAge(dto.getAge());
                registrationDTO.setGender(dto.isGender());
                registrationDTO.setEmail(dto.getEmail());
                registrationDTO.setPhone(dto.getPhone());
                registrationDTO.setAddress(dto.getAddress());
                registrationDTO.setNumberOfMember(dto.getNumberOfMember());
                registrationDTO.setNumberOfChildren(dto.getNumberOfChildren());
                registrationDTO.setNumberOfAdults(dto.getNumberOfAdults());
            }
        }
        try {
            pw = new PrintWriter(filename);
            for (RegistrationDTO registrationDTO : this.registrationList) {
                pw.println(registrationDTO.toString());
            }
            update = true;
        } catch (FileNotFoundException e) {
            update = false;
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
        return update;
    }

    public ArrayList<RegistrationDTO> searchByRegistrationName(String searchValue) {
        ArrayList<RegistrationDTO> searchList = new ArrayList<>();
        for (RegistrationDTO registrationDTO : findAllRegistrations()) {
            if (registrationDTO.getFullName().contains(searchValue)) {
                searchList.add(registrationDTO);
            }
        }
        return searchList;
    }

    public void sortAscendingByRegistrationName() {
        registrationList = findAllRegistrations();
        Collections.sort(registrationList, new Comparator<RegistrationDTO>(){
            @Override
            public int compare(RegistrationDTO t, RegistrationDTO t1) {
                return t.getFullName().compareTo(t1.getFullName());
            }
            
        });
    }
    
    public void sortDescendingByRegistrationName(){
        registrationList = findAllRegistrations();
        Collections.sort(registrationList, new Comparator<RegistrationDTO>(){
            @Override
            public int compare(RegistrationDTO t, RegistrationDTO t1) {
                return t1.getFullName().compareTo(t.getFullName());
            }
        });        
    }
}
