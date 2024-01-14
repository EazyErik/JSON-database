package client;

import com.beust.jcommander.Parameter;

public class Args {

    @Parameter(names={"--type", "-t"})
    String type;
    @Parameter(names={"--index", "-i"})
    int index;

    @Parameter(names={"--myValue","-m"})
    String myValue;

    @Override
    public String toString() {
        return String.format("%s %s %s",replaceNull(type),replaceIndex(index),replaceNull(myValue));
    }

    public String replaceIndex(int index){
        if(index == 0){
            return "";
        }
        return String.valueOf(index);
    }

    private String replaceNull(String value){
        if(value == null){
            return "";
        }
        return value;
    }
}
