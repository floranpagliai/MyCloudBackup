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
@RequestMapping("/")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) throws IOException, InterruptedException {
        String dbName = "rocketchef";
        String dbUser = "root";
        String dbPass = "root";

        MySqlBackup backup = new MySqlBackup();
        return String.valueOf(backup.backupDatabase("localhost", "8889", "root", "root", "rocketchef", "/Users/floran/Dropbox/Projets/MyCloudBackup/test.sql"));

    }
}