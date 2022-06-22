package org.example.DeepCopy;

import org.example.DeepCopy.dto.DeepCopyFromDto;
import org.example.DeepCopy.dto.DeepCopyToDto;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class DeepCopyTest {

    @Test
    public void testGetDeepCopy() {
        DeepCopy deepCopy = new DeepCopy();
        List<DeepCopyFromDto> listDeepCopyFromDto;
        List<DeepCopyToDto> listDeepCopyToDto = new ArrayList<>();
        listDeepCopyFromDto = deepCopy.setDtoValue();
        try {
            for (DeepCopyFromDto deepCopyFromDto : listDeepCopyFromDto) {
                listDeepCopyToDto.add((DeepCopyToDto) deepCopy.getDeepCopy(deepCopyFromDto, DeepCopyToDto.class.getDeclaredConstructor().newInstance()));
            }
            System.out.println("----------------------------------------------------From----------------------------------------------------");
            deepCopy.printValue(listDeepCopyFromDto, DeepCopyFromDto.class);
            System.out.println("-----------------------------------------------------To-----------------------------------------------------");
            deepCopy.printValue(listDeepCopyToDto, DeepCopyToDto.class);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
