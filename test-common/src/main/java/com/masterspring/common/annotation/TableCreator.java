package com.masterspring.common.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lihuiyan on 2016/3/16.
 */
public class TableCreator {
    public static void main(String[] args) throws ClassNotFoundException {
        String[] clazzName = {"com.jd.travel.web.annotation.Member"};
        createTable(clazzName);
    }

    public static void createTable(String[] args) throws ClassNotFoundException {
        for (String className : args) {
            Class<?> clazz = Class.forName(className);
            DBTable dbTable = clazz.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("未发现注解：@dbtable");
                continue;
            }
            String dbName = dbTable.name();
            if (dbName == null) {
                dbName = clazz.getName().toUpperCase();
            }
            List<String> columnDefs = new ArrayList<String>();
            for (Field field : clazz.getDeclaredFields()) {
                String colunmName = field.getName();
                Annotation[] annotations = field.getAnnotations();
                if (annotations.length < 1) {
                    System.out.println("not a db colum");
                }
                if (annotations[0] instanceof SQLString) {
                    SQLString sqlString = (SQLString) annotations[0];
                    if (sqlString.name().length() < 1) {
                        colunmName = field.getName().toUpperCase();
                    }
                    className = sqlString.name();
                    columnDefs.add(colunmName + " varchar(" + sqlString.value() + ")" + getConstraints(sqlString.constraints()));
                }
                if (annotations[0] instanceof SQLInteger) {
                    SQLInteger sqlInteger = (SQLInteger) annotations[0];
                    if (sqlInteger.name().length() < 1) {
                        colunmName = field.getName().toUpperCase();
                    }
                    colunmName = sqlInteger.name();
                    columnDefs.add(colunmName + " INT " + getConstraints(sqlInteger.constraints()));
                }
            }

            System.out.println(dbName);
            for (String columnInfo : columnDefs) {
                System.out.println(columnInfo);
            }
        }
    }

    private static String getConstraints(Constraints constraints) {
        String contains = "";
        if (!constraints.allowNull()) {
            contains += " NOT NULL";
        }
        if (constraints.isPrimayKey()) {
            contains += " PRIMARY KEY";
        }
        if (constraints.unique()) {
            contains += " UNIQUE";
        }
        return contains;
    }
}
