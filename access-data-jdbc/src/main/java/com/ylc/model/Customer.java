package com.ylc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author: tree
 * version: 1.0
 * date: 2017/12/26 17:13
 * description: xxx
 * own: Aratek
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private long id;
    private String firstName,lastName;
}
