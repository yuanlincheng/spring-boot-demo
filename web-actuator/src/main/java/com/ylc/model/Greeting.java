package com.ylc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author: tree
 * version: 1.0
 * date: 2017/12/27 16:52
 * description: xxx
 * own: Aratek
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Greeting {
    private long id;
    private String content;
}
