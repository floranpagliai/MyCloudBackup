/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycloudbackup;

import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;


public class MySqlBackup {
    private String mysqlDumpExePath = "/Applications/MAMP/Library/bin/";

    /**
     * This method is used for backup the mysql database
     *
     * @param host - hostname - localhost/127.0.0.1
     * @param port - 3306
     * @param user - username
     * @param password - password
     * @param db - database name
     * @param backupfile - file path to backup from the current location ex/
     * "/backup/"
     * @return the status of the backup true/false
     */
    public boolean backupDatabase(String host, String port, String user, String password, String db, String backupfile) {
        Boolean status = false;
        String executeCmd = "/Applications/MAMP/Library/bin/mysqldump -u " + user + " -p" + password + " --opt " + db + " -r" + backupfile;

        Process runtimeProcess = null;
        try {
            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
            if (processComplete == 0) {
                status = true;
            } else {
                status = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return status;
    }

    /**
     * Restore the backup into a local database
     *
     * @param user - user name
     * @param password - password
     * @param dbname - database name
     * @param backupfile - backup file
     * @return the status true/false
     */
    public boolean restoreDatabase(String user, String password, String dbname,String backupfile) {
        Boolean status = false;

        //String executeCmd = "/Applications/MAMP/Library/bin/mysql" + " -u " + user + " -p" + password + " mypokerlab < " + backupfile;
        String[] executeCmd = new String[]{"/Applications/MAMP/Library/bin/mysql", dbname, "-u" + user, "-p" + password, "-e", " source " + backupfile};

        Process runtimeProcess;
        try {
            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
            if (processComplete == 0) {
                status = true;
            } else {
                status = false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return status;
    }
}
