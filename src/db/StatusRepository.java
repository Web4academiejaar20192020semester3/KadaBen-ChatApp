package db;

import domain.DomainException;
import domain.Status;

import java.util.ArrayList;
import java.util.List;

public class StatusRepository {
    private List<Status> statuses;

    public StatusRepository(){
        this.statuses = new ArrayList<>();
        this.addStatus(new Status("Offline"));
        this.addStatus(new Status("Away"));
        this.addStatus(new Status("Online"));
    }

    public List<Status> getAllStatuses() {
        return statuses;
    }

    public String getStatus(String text){
        for (Status s:this.getAllStatuses()) {
            if(s.getLabel().equals(text)){return s.getLabel();}
        }
        Status x = new Status(text);
        this.addStatus(x);
        return x.getLabel();
    }

    private void addStatus(Status s){
            this.statuses.add(s);
    }
}
