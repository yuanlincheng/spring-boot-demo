package com.ylc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * author: tree
 * version: 1.0
 * date: 2017/12/27 15:41
 * description: xxx
 * own: Aratek
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @NotNull
    @Size(min = 2,max = 30)
    private String name;
    @NotNull
    @Min(18)
    private int age;
}
