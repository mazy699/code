package org.example.DeepCopy.dto;

import java.util.List;

public class DeepCopyToDto {
    @Override
    public String toString() {
        return "DeepCopyToDto{" +
                "dtoList=" + dtoList +
                ", stringList=" + stringList +
                ", str='" + str + '\'' +
                '}';
    }

    public List<ToDto> getDtoList() {
        return dtoList;
    }

    public void setDtoList(List<ToDto> dtoList) {
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

    private List<ToDto> dtoList;
    private List<String> stringList;
    private String str;
}
