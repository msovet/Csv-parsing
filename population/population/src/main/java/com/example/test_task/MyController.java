package com.example.test_task;

import com.example.test_task.model.PopulationmainEntity;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/testTask")
public class MyController {
    @Autowired
    PopRepos popRepos;


    @RequestMapping("/allCountry")
    @ResponseBody
    public List<String> getCountries() {
        List<String> countries = popRepos.getAllByCountry();
        return countries;
    }

    ArrayList<String> arrCountry = new ArrayList<>();

    public ArrayList<String> withoutCopy() {
        for (String s : getCountries()) {
            if (!arrCountry.contains(s)) {
                arrCountry.add(s);
            }
        }
        return arrCountry;
    }


    Map<String, List<Object[][]>> myMap=null;
    List<Object[][]> listCities = null;
    @RequestMapping("/getDataFromDB")
    @ResponseBody
    public Map<String, List<Object[][]>> getAscByPopNumber() {
        myMap = (Map<String, List<Object[][]>>) new HashMap<String, List<Object[][]>>();
        for (String s : withoutCopy()) {
            listCities = popRepos.getCitiesByPop(s);
            myMap.put(s,listCities);
        }
        return myMap;
    }


    private static final String FILE_NAME = "/C:/Users/Merey/population.xlsx";
    @RequestMapping("/create")
    @ResponseBody
    public void createExcelFile() {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Population");
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("City");
        header.createCell(1).setCellValue("Country");
        header.createCell(2).setCellValue("Population");

        int rowNum = 1;
        System.out.println("Creating excel");
        Row row = null;
        for(String country:myMap.keySet()){
                for (Object[] cities2 : myMap.get(country)) {
                    row = sheet.createRow(rowNum++);
                    int colNum0 = 0;
                    int colNum1 = 1;
                    int colnum2 = 2;
                    Cell cell0 = row.createCell(colNum0);
                    cell0.setCellValue((String) cities2[0]);
                    Cell cell2 = row.createCell(colNum1);
                    cell2.setCellValue((String) country);
                    Cell cell3 = row.createCell(colnum2);
                    cell3.setCellValue((String) cities2[1]);

            }
        }


        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }







    }

