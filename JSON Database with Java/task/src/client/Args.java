package client;

import com.beust.jcommander.Parameter;
import com.google.gson.Gson;


public class Args {

    @Parameter(names = {"--type", "-t"})
    String type;
    @Parameter(names = {"--key", "-k"})
    String key;

    @Parameter(names = {"--value", "-v"})
    String value;

    public Args(String input){
        Gson gson = new Gson();
        Args args = gson.fromJson(input, Args.class);
        this.type = args.getType();
        this.key  = args.getKey();
        this.value = args.getValue();
    }

    public Args(){

    }

//    @Override
//    public String toString() {
//        return String.format("%s %s %s", replaceNull(type), replaceIndex(key), replaceNull(myValue));
//    }


    public String toJSON() {
        Gson gson = new Gson();

        return gson.toJson(this);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String replaceIndex(int index) {
        if (index == 0) {
            return "";
        }
        return String.valueOf(index);
    }

    private String replaceNull(String value) {
        if (value == null) {
            return "";
        }
        return value;
    }
}
