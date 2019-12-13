package domain;

public class Status {
    private String label;

    public Status(String text){
        setLabel(text);
    }

    private void setLabel(String text) {
        if(text == null || text.trim().isEmpty()){
            throw new DomainException("Status can't be empty");
        }
        else this.label = text;
    }

    public String getLabel(){
        return this.label;
    }
}
