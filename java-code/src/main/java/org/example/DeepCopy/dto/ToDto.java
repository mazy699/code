package org.example.DeepCopy.dto;

import java.util.List;

public class ToDto {
    private List<TDto> dtoList;

    @Override
    public String toString() {
        return "ToDto{" +
                "dtoList=" + dtoList +
                ", stringList=" + stringList +
                ", str='" + str + '\'' +
                '}';
    }

    public List<TDto> getDtoList() {
        return dtoList;
    }

    public void setDtoList(List<TDto> dtoList) {
        this.dtoList = dtoList;
    }

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

    private List<String> stringList;
    private String str;
}
