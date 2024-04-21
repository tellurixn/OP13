package com.example.op.models;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.*;

public class XlsBook {
    private Workbook workbook;

    private FileOutputStream fileOut;

    public Workbook getWorkbook() {
        return workbook;
    }

    public void setWorkbook(Workbook workbook) {
        this.workbook = workbook;
    }

    public FileOutputStream getFileOut() {
        return fileOut;
    }

    public void setFileOut(FileOutputStream fileOut) {
        this.fileOut = fileOut;
    }

    public XlsBook(String dir){
        try (FileInputStream fileIn = new FileInputStream("op-13.xls")) {
            this.workbook = new HSSFWorkbook(fileIn); // Загружаем существующий документ Excel

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.fileOut = new FileOutputStream(dir);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void setOrganizationName(String orgName){
        writeValue(orgName,5,0);
    }
    public void setSubdivision(String subdivision){
        writeValue(subdivision,7,0);
    }
    public void setNumber(int number){
        writeValue(number,15,16);
    }
    public void setOKPO(int okpo){
        writeValue(okpo,5,42);
    }
    public void setTypeOfOperation(int type){
        writeValue(type,9, 42);
    }
    public void setTypeOfDeal(int type){
        writeValue(type,8, 42);
    }
    public void setPeriodStart(String time){
        writeValue(time, 15, 28);
    }
    public void setPeriodReceipt(String time){
        writeValue(time, 15,32);
    }
    public void setResearchDate(String time){
        writeValue(time, 15,22);
    }
    private void writeValue(String value, int rowIndex, int cellIndex){
        Sheet sheet = workbook.getSheetAt(0);

        // Получаем объединенную ячейку
        Cell cell = sheet.getRow(rowIndex).getCell(cellIndex);

        // Создаем стиль для выравнивания по центру
        CellStyle centeredStyle = workbook.createCellStyle();
        centeredStyle.setAlignment(HorizontalAlignment.CENTER);

        // Устанавливаем новое значение для ячейки
        cell.setCellValue(value);
        cell.setCellStyle(centeredStyle); // Применяем стиль


    }

    private void writeValue(int value, int rowIndex, int cellIndex){
        Sheet sheet = workbook.getSheetAt(0);

        // Получаем объединенную ячейку
        Cell cell = sheet.getRow(rowIndex).getCell(cellIndex);

        // Создаем стиль для выравнивания по центру
        CellStyle centeredStyle = workbook.createCellStyle();
        centeredStyle.setAlignment(HorizontalAlignment.CENTER);

        // Создаем объект шрифта и задаем размер
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 9); // Задаем размер шрифта

        // Применяем шрифт к стилю
        centeredStyle.setFont(font);

        // Устанавливаем новое значение для ячейки
        cell.setCellValue(value);
        cell.setCellStyle(centeredStyle); // Применяем стиль


    }

    public void save(){
        try {
            workbook.write(this.fileOut);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
