package org.example.DeepCopy.dto;

import java.util.List;

public class TDto {
    private List<String> stringList;
    private List<Integer> intList;
    private List<Boolean> booleanList;

    @Override
    public String toString() {
        return "TDto{" +
                "stringList=" + stringList +
                ", intList=" + intList +
                ", booleanList=" + booleanList +
                ", str='" + str + '\'' +
                '}';
    }

    public List<Integer> getIntList() {
        return intList;
    }

    public void setIntList(List<Integer> intList) {
        this.intList = intList;
    }

    public List<Boolean> getBooleanList() {
        return booleanList;
    }

    public void setBooleanList(List<Boolean> booleanList) {
        this.booleanList = booleanList;
    }

    private String str;

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
