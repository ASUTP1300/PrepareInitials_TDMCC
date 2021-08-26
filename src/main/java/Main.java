import entity.Calculation;
import io.github.millij.poi.SpreadsheetReadException;
import io.github.millij.poi.ss.reader.XlsReader;
import io.github.millij.poi.ss.reader.XlsxReader;
import org.apache.log4j.BasicConfigurator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/*
    ...
    final File xlsxFile = new File("<path_to_file>");
    final XlsReader reader = new XlsReader();
    List<Employee> employees = reader.read(Employee.class, xlsxFile);
    ...
 */
public class Main {


    public static void main(String[] args) throws IOException, SpreadsheetReadException {
        String sourceCs = " E=0.662E6;";
        String sourceSb = " E= \n" +
                "  3.5489E+04,\n" +
                "  1.7631E+05,\n" +
                "  3.8045E+05,\n" +
                "  4.2787E+05,\n" +
                "  4.6337E+05,\n" +
                "  6.0060E+05,\n" +
                "  6.0671E+05,\n" +
                "  6.3595E+05,\n" +
                "  6.71E+05 \n" +
                " (D=  \n" +
                "  4.3749E-02,\n" +
                "  6.8406E-02,\n" +
                "  1.5167E-02,\n" +
                "  2.9600E-01,\n" +
                "  1.0493E-01,\n" +
                "  1.7648E-01,\n" +
                "  4.9817E-02,\n" +
                "  1.1218E-01,\n" +
                "  1.79E-02);";
        String sourceRn = " BL1 P1 R3;\n" +
                " E = 5.1186E+05, 6.1622E+05, 6.2193E+05, 8.7349E+05, 1.0504E+06, 1.1281E+06\n" +
                " (D = 2.0400E-01, 7.5480E-03, 9.9348E-02, 4.3860E-03, 1.5586E-02, 4.0392E-03);\n";
        String[] sourcesDis = {sourceCs, sourceSb, sourceRn};
        String[] sourcesName = {"CS", "SB", "RN"};


        String path = "C:\\TDMC\\WORK\\2DDXXXX\\";



//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path + "1DDXXX2"));


        for (int i = 0; i < sourcesDis.length; i++) {
            File file = new File(path +"\\"+"2DD"+sourcesName[i]+"XX");
            file.mkdir();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path + "2DDXXXX"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path +"\\"+"2DD"+sourcesName[i]+"XX"+"\\"+ "2DD"+sourcesName[i]+"XX"));
            String str;
            bufferedReader.readLine();
            while ((str = bufferedReader.readLine()) != null) {
                if (str.contains("SORC")) {
                    str = sourcesDis[i];
                }
                if(str.contains("DEV:")){
                    str = " #  DEV: 1;  SOURCE: "+ sourcesName[i]+ "; #";
                }
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
            bufferedReader.close();
            bufferedWriter.close();

        }
    }
}