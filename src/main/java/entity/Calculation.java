package entity;



/*
@Sheet
public class Employee {
    // Pick either field or its accessor methods to apply the Column mapping.
    ...
    @SheetColumn("Age")
    private Integer age;
    ...
    @SheetColumn("Name")
    public String getName() {
        return name;
    }
    ...
}



 */


import io.github.millij.poi.ss.model.annotations.Sheet;
import io.github.millij.poi.ss.model.annotations.SheetColumn;

@Sheet
public class Calculation {

    @SheetColumn("В")
    private String h;

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }
}

