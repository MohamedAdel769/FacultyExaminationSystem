package main.dataBaseHelper;

import java.sql.SQLException;
import java.sql.Statement;

import static main.dataBaseHelper.dataBaseConVars.*;

public class DBEvaluationExamReport {
    String examID = null, histogramID= null,hardQ1= null,hardQ2= null,
            hardQ3= null,hardQ4= null,hardQ5= null;
    final String tableName = "EvaluationExamReport";

    public DBEvaluationExamReport() {
    }

    public DBEvaluationExamReport(String examID, String histogramID, String hardQ1, String hardQ2, String hardQ3, String hardQ4, String hardQ5) {
        this.examID = examID;
        this.histogramID = histogramID;
        this.hardQ1 = hardQ1;
        this.hardQ2 = hardQ2;
        this.hardQ3 = hardQ3;
        this.hardQ4 = hardQ4;
        this.hardQ5 = hardQ5;
    }

    public int add(DBEvaluationExamReport dbEvaluationExamReport) {
        try {
            startConnection();
            String query = String.format("insert into %s (examID, histogramID, hardQ1, hardQ2, hardQ3, hardQ4, hardQ5)" +
                    "values ('%s','%s','%s','%s','%s','%s','%s')",tableName,dbEvaluationExamReport.examID,dbEvaluationExamReport.histogramID,dbEvaluationExamReport.hardQ1,dbEvaluationExamReport.hardQ2,dbEvaluationExamReport.hardQ3,dbEvaluationExamReport.hardQ4,dbEvaluationExamReport.hardQ5);
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("add error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex );
        }finally {
            close();
        }
        return OK;
    }
    public DBEvaluationExamReport getByExamId(String id){
        startConnection();
        DBEvaluationExamReport tem = new DBEvaluationExamReport();
            try {
                String query = String.format("select * from %s where examID = '%s'",tableName, id);
                dBResult = stmt.executeQuery(query);
                while (dBResult.next()) {
                    tem.examID = dBResult.getString("examID");
                    tem.histogramID = dBResult.getString("histogramID");
                    tem.hardQ1 = dBResult.getString("hardQ1");
                    tem.hardQ2 = dBResult.getString("hardQ2");
                    tem.hardQ3 = dBResult.getString("hardQ3");
                    tem.hardQ4 = dBResult.getString("hardQ4");
                    tem.hardQ5 = dBResult.getString("hardQ5");
                }
            } catch (SQLException ex) {
                System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName() + " " + ex );
            }
            close();
            return tem;
    }
}
