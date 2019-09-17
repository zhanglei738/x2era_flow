package com.x2era.flow.utils;

import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * java调用sheet脚本工具类
 * */
public class RuntimeUtils {
    public static String exec(String command)
            throws IOException{
        StringBuilder result = new StringBuilder();
        Process process;
        try {
            process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            int exitValue = 0;
            exitValue = process.waitFor();
            while((line = reader.readLine())!= null){
                result.append(line);
                //System.out.println(line);
            }
            if (exitValue == 0){
                result.append( "successfully executed the linux command");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public static void callScript(String zippath,String hivepartition,String script, String args, String... workspace){
        Process process;
        try {
            String cmd = "sh " + script + " " + args;
//        	String[] cmd = {"sh", script, "4"};
            File dir = null;
            if(workspace[0] != null){
                dir = new File(workspace[0]);
                System.out.println(workspace[0]);
            }
            String[] evnp = {"zippath="+zippath, "hivepartition="+hivepartition};
            process = Runtime.getRuntime().exec(cmd, evnp, dir);
//            process = Runtime.getRuntime().exec(cmd);
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            input.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}