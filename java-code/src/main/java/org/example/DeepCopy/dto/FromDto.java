package org.example.DeepCopy.dto;

import java.util.List;

/**
 * @author mzy
 */
public class FromDto {
    private List<FDto> dtoList;
    private List<String> stringList;
    private String str;

    @Override
    public String toString() {
        return "FromDto{" +
                "dtoList=" + dtoList +
                ", stringList=" + stringList +
                ", str='" + str + '\'' +
                '}';
    }

    public List<FDto> getDtoList() {
        return dtoList;
    }

    public void setDtoList(List<FDto> dtoList) {
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
}
