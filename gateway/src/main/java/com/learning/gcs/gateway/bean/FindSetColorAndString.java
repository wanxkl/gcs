package com.learning.gcs.gateway.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Xull
 * @version 1.0
 * @email wanxkl@gmail.com
 * @created 2017/10/17 18:05
 * @description
 */
public class FindSetColorAndString {
    @JsonProperty("color_1")
    private String color1;
    @JsonProperty("string_1")
    private String string1;
    @JsonProperty("color_2")
    private String color2;
    @JsonProperty("string_2")
    private String string2;

    public String getColor1() {
        return color1;
    }

    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public String getColor2() {
        return color2;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }

    public String getString2() {
        return string2;
    }

    public void setString2(String string2) {
        this.string2 = string2;
    }
}
