package com.ylc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * author: tree
 * version: 1.0
 * date: 2017/12/29 15:31
 * description: xxx
 * own: Aratek
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserTest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
}
