package com.mycloudbackup;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
@RequestMapping("/")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) throws IOException, InterruptedException {
        model.addAttribute("message", "Hello world!");
        String dbName = "wineot";
        String dbUser = "root";
        String dbPass = "root";
        String executeCmd = "";
        executeCmd = "mysqldump -u " + dbUser + " -p" + dbPass + " " + dbName + " -r backup.sql";

        Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
        int processComplete = runtimeProcess.waitFor();
        if (processComplete == 0) {
            return "Backup taken successfully";
        } else {
            return "Could not take mysql backup";
        }
    }
}