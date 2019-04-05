package main.dataBaseHelper;

import java.sql.SQLException;
import java.sql.Statement;

import static main.dataBaseHelper.dataBaseConVars.*;

public class DBEvaluationExamReport {
    String examID = null, histogramID= null,hardQ1= null,hardQ2= null,
            hardQ3= null,hardQ4= null,hardQ5= null;
    String tableName = "DBEvaluationExamReport";
    public int add(DBEvaluationExamReport dbEvaluationExamReport) {
        try {
            startConnection();
            String query = String.format("insert into %s (examID, histogramID, hardQ1, hardQ2, hardQ3, hardQ4, hardQ5)" +
                    "values ('%s','%s','%s','%s','%s','%s','%s')",tableName,dbEvaluationExamReport.examID,dbEvaluationExamReport.histogramID,dbEvaluationExamReport.hardQ1,dbEvaluationExamReport.hardQ2,dbEvaluationExamReport.hardQ3,dbEvaluationExamReport.hardQ4,dbEvaluationExamReport.hardQ5);
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName());
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
                System.out.println("query error " + new Throwable().getStackTrace()[0].getMethodName());
            }
            close();
            return tem;
    }
}
