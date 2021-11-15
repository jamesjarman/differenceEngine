import com.opencsv.bean.CsvToBeanBuilder;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main{



    public static void main(String[] args) throws IOException {

        String fileName = "c:\\test\\csv\\employees.csv";

        // converts records in a csv into a list of employees
        List<Employee> beans =  new CsvToBeanBuilder(new FileReader(fileName))
                .withType(Employee.class)
                .build()
                .parse();

        // create map of records with key
        Map<String, Employee> employeesMap = beans.stream()
                .collect( Collectors.toMap(Employee::getId,
                        Function.identity()) );

        // TODO create a method to return the map elements which are in Map A but not in Map B by comparing keysets
        System.out.println(employeesMap.keySet());
    }
}