package com.sda;

import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

public class Writer {
    public String sayHello(String name) {
        String[] names = name != null ? name.split(",") : new String[1];
        String nameSection = names.length == 1 ? name : convertToMessage(names);
        String greeting = "Hello";
//        if (nameSection == null || "".equals(nameSection)) {
//            nameSection = "my friend";
//        }
        if (StringUtils.isBlank(nameSection)) {
            nameSection = "my friend";
        }
        if (StringUtils.isAllUpperCase(nameSection)) {
            greeting = StringUtils.upperCase(greeting);

        }
        String output = greeting + ", " + nameSection + "!";
        return isAllUppercase(names) ? StringUtils.upperCase(output) : output;
    }

    private String convertToMessage(String[] names) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < names.length; i++) {
            stringBuilder.append(names[i]);
            if (i < names.length - 2) {
                stringBuilder.append(", ");
            } else if (i == names.length - 2) {
                stringBuilder.append(" and ");
            }
        }
        return stringBuilder.toString();
    }

    private boolean isAllUppercase(String[] names){
        return Stream.of(names)
                .allMatch(e -> StringUtils.isAllUpperCase(e));
    }
}
