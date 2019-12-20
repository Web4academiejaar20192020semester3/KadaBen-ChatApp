package domain;

import java.util.ArrayList;
import java.util.List;

public class JSon {

    public static String statusToJSON(String status) {
        return "{\"status\": \"" + status +"\"}";
    }

    public static String friendsToJSON(List<Person> friends) {
        String result = "{\"friends\": [";

        for (Person p : friends) {
            result += "{\"user\":\""+p.getFirstName()+"\", \"status\":\""+p.getStatus()+"\", \"email\":\""+p.getUserId()+"\", \"id\": \""+p.getFullName()+"\"},";
        }

        result = result.replaceAll(",$", "");
        result += "]}";

        return result;
    }

    public static String messagesToJSON(ArrayList<String[]> messages) {
        String result = "{\"messages\": [";

        for (String[] msg : messages) {
            result += "{\"from\":\"" + msg[0] + "\", \"to\":\"" + msg[1] + "\", \"msg\":\"" + msg[2] + "\"}, ";
        }

        result = result.replaceAll(", $", "");
        result += "]}";
        System.out.println(result);

        return result;
    }

    public static String usersToJSON(List<Person> persons) {
        String result = "{\"users\": [";

        for (Person p : persons) {
            result += "{\"userId\":\""+p.getUserId()+"\", \"firstName\":\""+p.getFirstName()+"\", \"lastName\":\""+p.getLastName()+"\", \"status\":\""+p.getStatus()+"\", \"gender\":\""+p.getGeslacht()+"\", \"age\":\""+p.getLeeftijd()+"\"}, ";
        }

        result = result.replaceAll(", $", "");
        result += "]}";

        return result;
    }
}
