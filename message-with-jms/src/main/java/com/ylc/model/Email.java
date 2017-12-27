package com.ylc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author: tree
 * version: 1.0
 * date: 2017/12/27 17:29
 * description: xxx
 * own: Aratek
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    private String to;
    private String body;
}
