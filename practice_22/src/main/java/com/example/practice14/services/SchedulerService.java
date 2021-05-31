package com.example.practice14.services;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

@Service
@RequiredArgsConstructor
@ManagedResource(objectName = "pr22MBeans:category=MBeans,name=SchedulerService")
public class SchedulerService{
    @Value("${data.path.scheduler}")
    private String pathToDataFolder;
    private final CardService cardService;
    private final BankService bankService;

    private <E> void  writeToFile(String fileName, List<E> list){
        PrintWriter writer;
        try {
            writer = new PrintWriter(pathToDataFolder+"/"+fileName, "UTF-8");
            StringBuilder data = new StringBuilder();
            for(Object o : list){
                data.append(o.toString()).append("\n");
            }
            writer.print(data);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Scheduled(fixedRate = 1800000)
    @ManagedOperation
    public void saveDataFromDBToFolder() {
        File folder = new File(pathToDataFolder);
        File[] files = folder.listFiles();
        if(files!=null) {
            for (File file : files)
                file.delete();
        };
        writeToFile("cards", cardService.getCards());
        writeToFile("banks", bankService.getBanks());
    }
}