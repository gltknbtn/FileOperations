package test;

public class LabelData {
    
    String oriLabel;
    String formattedLabel;
    
    
    public LabelData(String oriLabel, String formattedLabel) {
        this.oriLabel = oriLabel;
        this.formattedLabel = formattedLabel;
    }
    /**
     * @return the oriLabel
     */
    public String getOriLabel() {
        return oriLabel;
    }
    /**
     * @param oriLabel the oriLabel to set
     */
    public void setOriLabel(String oriLabel) {
        this.oriLabel = oriLabel;
    }
    /**
     * @return the formattedLabel
     */
    public String getFormattedLabel() {
        return formattedLabel;
    }
    /**
     * @param formattedLabel the formattedLabel to set
     */
    public void setFormattedLabel(String formattedLabel) {
        this.formattedLabel = formattedLabel;
    }
    
    

}
