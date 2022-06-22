package org.example.DeepCopy;

import org.example.DeepCopy.dto.*;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mzy
 */
public class DeepCopy {
    public static final int LOOP = 3;
    public static final int LENGTH_TWO = 2;
    private static final int LENGTH_ONE = 1;
    private static final List<Class> WRAPPER_CLASS = new ArrayList<>();

    static {
        WRAPPER_CLASS.add(Boolean.class);
        WRAPPER_CLASS.add(Character.class);
        WRAPPER_CLASS.add(Byte.class);
        WRAPPER_CLASS.add(Short.class);
        WRAPPER_CLASS.add(Integer.class);
        WRAPPER_CLASS.add(String.class);
        WRAPPER_CLASS.add(Long.class);
        WRAPPER_CLASS.add(Float.class);
        WRAPPER_CLASS.add(Double.class);
    }

    public static void main(String[] args) {
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
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static Object getValue(Object dto, String methodName) {
        return getValue(dto, methodName, null);
    }

    private static Object getValue(Object dto, String methodName, Object defaultValue) {
        if (null == dto) {
            return defaultValue;
        }
        try {
            Method method = dto.getClass().getMethod(methodName);
            return method.invoke(dto);
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }

    private static void setValue(Object dto, String methodName, Class<?> setType, Object setValue) {
        if (null == dto) {
            return;
        }
        try {
            Method method = dto.getClass().getMethod(methodName, setType);
            method.invoke(dto, setValue);
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static String toFirstUpperCase(String value) {
        return concat(value.substring(0, 1).toUpperCase(), value.substring(1));
    }

    private static String concat(String... values) {
        if (LENGTH_ONE == values.length) {
            return values[0];
        } else if (LENGTH_TWO == values.length) {
            return values[0] + values[1];
        }
        StringBuilder builder = new StringBuilder();
        for (String value : values) {
            builder.append(value);
        }
        return builder.toString();
    }

    private void printValue(Object object, Class<?> objClass) {
        if (DeepCopyFromDto.class.equals(objClass)) {
            List<DeepCopyFromDto> listDeepCopyFromDto = (List<DeepCopyFromDto>) object;
            for (DeepCopyFromDto deepCopyFromDto : listDeepCopyFromDto) {
                for (FromDto fromDto : deepCopyFromDto.getDtoList()) {
                    for (FDto fDto : fromDto.getDtoList()) {
                        for (String str : fDto.getStringList()) {
                            System.out.println(str);
                        }
                        for (Integer integer : fDto.getIntList()) {
                            System.out.println("FDto.ListInteger.Integer:" + integer);
                        }
                        for (Boolean boo : fDto.getBooleanList()) {
                            System.out.println("FDto.ListBoolean.Boolean:" + boo);
                        }
                        System.out.println(fDto.getStr());
                    }
                    for (String str : fromDto.getStringList()) {
                        System.out.println(str);
                    }
                    System.out.println(fromDto.getStr());
                }
                for (String str : deepCopyFromDto.getStringList()) {
                    System.out.println(str);
                }
                System.out.println(deepCopyFromDto.getStr());
            }
        } else {
            List<DeepCopyToDto> listDeepCopyToDto = (List<DeepCopyToDto>) object;
            for (DeepCopyToDto deepCopyToDto : listDeepCopyToDto) {
                for (ToDto toDto : deepCopyToDto.getDtoList()) {
                    for (TDto tDto : toDto.getDtoList()) {
                        for (String str : tDto.getStringList()) {
                            System.out.println(str);
                        }
                        for (Integer integer : tDto.getIntList()) {
                            System.out.println("FDto.ListInteger.Integer:" + integer);
                        }
                        for (Boolean boo : tDto.getBooleanList()) {
                            System.out.println("FDto.ListBoolean.Boolean:" + boo);
                        }
                        System.out.println(tDto.getStr());
                    }
                    for (String str : toDto.getStringList()) {
                        System.out.println(str);
                    }
                    System.out.println(toDto.getStr());
                }
                for (String str : deepCopyToDto.getStringList()) {
                    System.out.println(str);
                }
                System.out.println(deepCopyToDto.getStr());
            }
        }
    }

    private List<DeepCopyFromDto> setDtoValue() {
        List<DeepCopyFromDto> listDeepCopyFromDto = new ArrayList<>();
        for (int i = 0; i < LOOP; i++) {
            listDeepCopyFromDto.add(setDeepCopyFromDto(new DeepCopyFromDto(), i));
        }
        return listDeepCopyFromDto;
    }

    private DeepCopyFromDto setDeepCopyFromDto(DeepCopyFromDto deepCopyFromDto, int index) {
        List<FromDto> listFromDto = new ArrayList<>();
        for (int i = 0; i < LOOP; i++) {
            listFromDto.add(setFromDto(new FromDto(), i));
        }
        List<String> listString = new ArrayList<>();
        for (int i = 0; i < LOOP; i++) {
            listString.add("DeepCopyFromDto.ListString.String:" + index + ":" + i);
        }
        deepCopyFromDto.setDtoList(listFromDto);
        deepCopyFromDto.setStringList(listString);
        deepCopyFromDto.setStr("DeepCopyFromDto.String.String:" + index);
        return deepCopyFromDto;
    }

    private FromDto setFromDto(FromDto fromDto, int index) {
        List<FDto> listFDto = new ArrayList<>();
        for (int i = 0; i < LOOP; i++) {
            listFDto.add(setFDto(new FDto(), i));
        }
        List<String> listString = new ArrayList<>();
        for (int i = 0; i < LOOP; i++) {
            listString.add("FromDto.ListString.String:" + index + ":" + i);
        }
        fromDto.setDtoList(listFDto);
        fromDto.setStringList(listString);
        fromDto.setStr("FromDto.String.String:" + index);
        return fromDto;
    }

    private FDto setFDto(FDto fDto, int index) {
        List<String> listString = new ArrayList<>();
        List<Integer> listInteger = new ArrayList<>();
        List<Boolean> listBoolean = new ArrayList<>();
        for (int i = 0; i < LOOP; i++) {
            listString.add("FDto.ListString.String:" + index + ":" + i);
        }
        for (int i = 0; i < LOOP; i++) {
            listInteger.add(i);
        }
        for (int i = 0; i < LOOP; i++) {
            if (i % 2 == 0) {
                listBoolean.add(true);
            } else {
                listBoolean.add(false);
            }
        }
        fDto.setIntList(listInteger);
        fDto.setBooleanList(listBoolean);
        fDto.setStringList(listString);
        fDto.setStr("FDto.String.String:" + index);
        return fDto;
    }

    @SuppressWarnings("unchecked")
    private Object getDeepCopy(Object from, Object to) throws ClassNotFoundException {
        if (from == null) {
            return null;
        }
        //getCopy(from, to);
        for (Field field : from.getClass().getDeclaredFields()) {
            for (Field fieldTo : to.getClass().getDeclaredFields()) {
                if (fieldTo.getName().equals(field.getName())) {
                    if (field.getType().equals(List.class)) {
                        ParameterizedType pt = (ParameterizedType) fieldTo.getGenericType();
                        Type[] ts = pt.getActualTypeArguments();
                        List list = (List) getValue(from, "get" + toFirstUpperCase(field.getName()));
                        List listTo = new ArrayList<>();
                        if (WRAPPER_CLASS.contains(Class.forName(ts[0].getTypeName()))) {
                            listTo.addAll(list);
                        } else {
                            listTo = getDeepCopyList(list, Class.forName(ts[0].getTypeName()));
                        }
                        setValue(to, "set" + toFirstUpperCase(fieldTo.getName()), List.class, listTo);
                    } else if (field.getType().equals(String.class)) {
                        String str = (String) getValue(from, "get" + toFirstUpperCase(field.getName()));
                        setValue(to, "set" + toFirstUpperCase(fieldTo.getName()), String.class, str);
                    }
                }
            }
        }
        return to;
    }

    @SuppressWarnings("unchecked")
    public final <E> List<E> getDeepCopyList(List<E> list, Class<?> dtoClass) {
        if (list == null) {
            return null;
        }

        List<E> dataList = new ArrayList<>();

        for (E dto : list) {
            try {
                dataList.add((E) getDeepCopy(dto, dtoClass.getDeclaredConstructor().newInstance()));
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return new ArrayList<>(dataList);
    }
}
