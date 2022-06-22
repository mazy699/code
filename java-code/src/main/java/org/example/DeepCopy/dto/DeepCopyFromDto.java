package org.example.DeepCopy.dto;

import java.util.List;

/**
 * @author mzy
 */
public class DeepCopyFromDto {
    private List<FromDto> dtoList;
    private List<String> stringList;
    private String str;

    @Override
    public String toString() {
        return "DeepCopyFromDto{" +
                "dtoList=" + dtoList +
                ", stringList=" + stringList +
                ", string='" + str + '\'' +
                '}';
    }

    public List<FromDto> getDtoList() {
        return dtoList;
    }

    public void setDtoList(List<FromDto> dtoList) {
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
