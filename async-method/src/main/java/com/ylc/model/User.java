package com.ylc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: tree
 * @version: 1.0
 * date: 2017/12/27 23:05
 * @description: xxx
 * own: Aratek
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String name;
    private String blog;
}
