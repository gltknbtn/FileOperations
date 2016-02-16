package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    
    private static final int TEST_INPUT_SIZE = 3143;
    
    public static void main(String[] args) {
        
      mergeTestResults("resources/input.csv" ,"resources/input2.csv","resources/out.csv");
        
    }
    
    public static void mergeTestResults(String testInputFilePath,String testResultPath, String outputFilePath){
        
        try {
            
            BufferedReader testInputFileReader = new BufferedReader(new FileReader(new File(testInputFilePath)));

            List<LabelData> testInputList = new ArrayList<LabelData>();
            String line = "";
            while ((line = testInputFileReader.readLine()) != null) {
                String oriTestLabel = line;
                String[] strArr1 = line.split("_");
                
                String formattedTestLabel ="";
                for (int i = 0; i < (strArr1.length-1); i++) {
                    if(i < (strArr1.length-2)){
                        formattedTestLabel += strArr1[i] + "_";
                    }else{
                        formattedTestLabel += strArr1[i];
                    }
                }
                LabelData labelData = new LabelData(oriTestLabel, formattedTestLabel);
                
                testInputList.add(labelData);
            }
            testInputFileReader.close();
            
            
            
            BufferedReader testResultFileReader = new BufferedReader(new FileReader(new File(testResultPath)));
            List<LabelData> testResultList = new ArrayList<LabelData>();
            String line2 = "";
            while ((line2 = testResultFileReader.readLine()) != null) {
                String oriCandidateLabel = line2;
                
                String[] strArr2 = line2.split("_");
                String formattedCandidateLabel ="";
                for (int i = 0; i < (strArr2.length-1); i++) {
                    if(i < (strArr2.length-2)){
                        formattedCandidateLabel += strArr2[i] + "_";
                    }else{
                        formattedCandidateLabel += strArr2[i];
                    }
                }
                
                LabelData labelData = new LabelData(oriCandidateLabel, formattedCandidateLabel);
                
                testResultList.add(labelData);
            }
            testResultFileReader.close();
            
            ///comparing
            
          BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(outputFilePath)));
          double rank1TrueCount = 0; 
          double rank5TrueCount = 0; 
          double rank10TrueCount = 0; 
            
            for (int i = 0; i < testInputList.size(); i++) {
                  List<LabelData> subList = testResultList.subList(i*10, (i+1)*10);
                  String testlabel = testInputList.get(i).getFormattedLabel();
                  
                  String formattedCandidateLabel = "";
                  String oriCandidateLabel = "";
                  
                  boolean match = false;
                  for (int j = 0; j < subList.size(); j++) {
                      formattedCandidateLabel = subList.get(j).getFormattedLabel();
                      oriCandidateLabel = subList.get(j).getOriLabel();
                      
                      if (testlabel.equals(formattedCandidateLabel)) {
                        match = true;
                        if (j == 0) {
                            rank1TrueCount++;
                            rank5TrueCount++;
                            rank10TrueCount++;
                        }else if(j>0 && j<=4 ){
                            rank5TrueCount++;
                            rank10TrueCount++;
                        }else if(j>4 && j<=9 ){
                            rank10TrueCount++;
                        }
                        break;
                    }else{
                        match = false;
                        oriCandidateLabel ="";
                    }
                }
                  System.out.println(testlabel + ": " + match);
                  bufferedWriter.write(testInputList.get(i).getOriLabel() + ";" + testInputList.get(i).getFormattedLabel()+ ";"+oriCandidateLabel +";"+formattedCandidateLabel+";"+ match+"\n");
                  
          }
            Double dblRank1TrueCount = Double.valueOf(rank1TrueCount);
            Double dblRank5TrueCount = Double.valueOf(rank5TrueCount);
            Double dblRank10TrueCount = Double.valueOf(rank10TrueCount);
            
            Double dblTestInputSize = Double.valueOf(TEST_INPUT_SIZE);
            
            double testScoreRank1 = dblRank1TrueCount / dblTestInputSize ;
            System.out.println("Rank1: " + testScoreRank1);
            
            bufferedWriter.write("\n\n\n Rank1: " + testScoreRank1);
            
            double testScoreRank5 = dblRank5TrueCount / dblTestInputSize ;
            System.out.println("Rank5: " + testScoreRank5);
            
            bufferedWriter.write("\n Rank5: " + testScoreRank5);
            
            double testScoreRank10 = dblRank10TrueCount / dblTestInputSize ;
            System.out.println("Rank5: " + testScoreRank10);
            
            bufferedWriter.write("\n Rank5: " + testScoreRank10);
            
            bufferedWriter.close();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
