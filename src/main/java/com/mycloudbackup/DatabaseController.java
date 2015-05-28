package com.mycloudbackup;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.sql.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class DatabaseController {

    @RequestMapping("/dump")
    public String dumpDatabase(ModelMap model) {
        MySqlBackup backup = new MySqlBackup();

        Boolean res = backup.backupDatabase("localhost", "8889", "root", "root", "chazel2", "/Users/floran/Dropbox/Projets/MyCloudBackup/test.sql");
        if (res) {
            model.addAttribute("message", "Database dumped");
        } else {
            model.addAttribute("message", "Error");
        }
        return  "hello";

    }

    @RequestMapping("/restore")
    public String restoreDatabase(ModelMap model) throws IOException, InterruptedException {
        MySqlBackup backup = new MySqlBackup();

        Boolean res = backup.restoreDatabase("root", "root", "/Users/floran/Dropbox/Projets/MyCloudBackup/test.sql");
        if (res) {
            model.addAttribute("message", "Database restored");
        } else {
            model.addAttribute("message", "Error");
        }
        return  "hello";

    }
}