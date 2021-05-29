package com.example.demo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;

@Service
public class Hash {
    private final ApplicationArguments names;
    private File fileIn;

    public Hash(ApplicationArguments names) {
        this.names = names;
    }

    @PostConstruct
    public void init() {
        fileIn = new File(names.getNonOptionArgs().get(0));
        int hashData = 0;
        boolean fileIsCreated;
        try(FileReader reader = new FileReader(fileIn)){
            fileIsCreated = true;
            StringBuilder data = new StringBuilder();
            int c;
            while((c=reader.read())!=-1){
                data.append((char)c);
            }
            hashData = data.toString().hashCode();
        }catch (Exception e){
            fileIsCreated = false;
        }
        File fileOut = new File(names.getNonOptionArgs().get(1));
        try {
            fileOut.createNewFile();
            PrintWriter writer = new PrintWriter(fileOut);
            if(fileIsCreated){
                writer.write(hashData + "");
            }
            else{
                writer.write("null");
            }
            writer.close();
        }catch (Exception e){}
    }


    @PreDestroy
    public void destroy() {
        fileIn.delete();
    }
}
