package test;

public class TestResult {
    
    String oriTestLabel;
    String formattedTestLabel;
    
    String oriCandidateLabel;
    String formattedCandidateLabel;
    
    
    public TestResult(String oriTestLabel, String formattedTestLabel, String oriCandidateLabel,
            String formattedCandidateLabel) {
        this.oriTestLabel = oriTestLabel;
        this.formattedTestLabel = formattedTestLabel;
        this.oriCandidateLabel = oriCandidateLabel;
        this.formattedCandidateLabel = formattedCandidateLabel;
    }
    /**
     * @return the oriTestLabel
     */
    public String getOriTestLabel() {
        return oriTestLabel;
    }
    /**
     * @param oriTestLabel the oriTestLabel to set
     */
    public void setOriTestLabel(String oriTestLabel) {
        this.oriTestLabel = oriTestLabel;
    }
    /**
     * @return the formattedTestLabel
     */
    public String getFormattedTestLabel() {
        return formattedTestLabel;
    }
    /**
     * @param formattedTestLabel the formattedTestLabel to set
     */
    public void setFormattedTestLabel(String formattedTestLabel) {
        this.formattedTestLabel = formattedTestLabel;
    }
    /**
     * @return the oriCandidateLabel
     */
    public String getOriCandidateLabel() {
        return oriCandidateLabel;
    }
    /**
     * @param oriCandidateLabel the oriCandidateLabel to set
     */
    public void setOriCandidateLabel(String oriCandidateLabel) {
        this.oriCandidateLabel = oriCandidateLabel;
    }
    /**
     * @return the formattedCandidateLabel
     */
    public String getFormattedCandidateLabel() {
        return formattedCandidateLabel;
    }
    /**
     * @param formattedCandidateLabel the formattedCandidateLabel to set
     */
    public void setFormattedCandidateLabel(String formattedCandidateLabel) {
        this.formattedCandidateLabel = formattedCandidateLabel;
    }
    
    

}
