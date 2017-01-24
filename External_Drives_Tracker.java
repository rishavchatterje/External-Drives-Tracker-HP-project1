/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.File;
import java.util.*;
/**
 *
 * @author ALOKE DIP
 */
class EDT{
    private  File[] drive=File.listRoots();
    private static int flag=0;
    private int temp=0;
    void listDrive(){
        while(true){
            drive=File.listRoots();
            temp=drive.length;
            if(drive!=null && drive.length>0 && flag!=temp){
                if(temp>flag){System.out.println("some device is plugged in");}
                else if(temp<flag){System.out.println("some device is unplugged");}
            for (File drive1 : drive) {
                try {
                    System.out.println("drive : " + drive1.toString());
                    flag=temp;
                }catch(Exception e){
                    System.out.println("ERROR : "+e);
                }
            }
        }
        }
    }
    void totalSpace(String s){
        if(valid_drive(s)){
            File f=new File(s);
            long space=f.getTotalSpace();
            System.out.println("the size of the drive : "+" s = "+((space/(Math.pow(2,30))))+"GB");
        }
        else
            System.out.println("not a valid drive");
    }
    void freeSpace(String s){
        if(valid_drive(s)){
            File f=new File(s);
            System.out.println(" free space for drive : "+s+" = "+(f.getFreeSpace()/Math.pow(2, 30))+" GB");
            System.out.println(" used space for drive : "+s+" = "+((f.getTotalSpace()-f.getFreeSpace())/Math.pow(2, 30))+" GB");
        }
        else
            System.out.println("not a valid drive");
    }
    void list_file(String s){
        File f= new File(s);
        File[] list=f.listFiles();
        for(int i=0;i<list.length;i++){
            try{
                if(list[i].isFile()){
                System.out.println(i+1+"-------- "+list[i].getAbsolutePath());
            }
                else if(list[i].isDirectory()){
                    System.out.println("************************* FOLDER **************************** "+list[i].toString());
                   list_file(list[i].getAbsolutePath());
                }
            }
            catch(Exception e){
                //System.out.println(e);
            }
        }
    }
    boolean valid_drive(String s){
        boolean stat=false;
        for (File drive1 : drive) {
            if (drive1.toString().equals(s)) {
                stat=true;
                break;
            }
        }
        return stat;
    }
}

public class External_Drives_Tracker {
    public static void main(String[] args) {
        EDT e=new EDT();
        System.out.println("1 : for listing all plugged in drives");
        System.out.println("2 : for finding total space used space of a drive");
        System.out.println("3 : for listing all files and subfolders of an directory");
        int choise;
        Scanner sc=new Scanner(System.in);
        choise=sc.nextInt();
        String s;
        switch(choise){
            case 1:
                e.listDrive();
                break;
            case 2:
                System.out.println("enter the name of the directory in capital letter");
                s=sc.next();
                e.totalSpace(s);
                e.freeSpace(s);
                break;
            case 3:
                System.out.println("enter the name of the directory in capital letter");
                s=sc.next();
                if(e.valid_drive(s)){
                    e.list_file(s);
                    break;
                }
                else
                    System.out.println("not a valid drive");
                break;
        }
    }
}