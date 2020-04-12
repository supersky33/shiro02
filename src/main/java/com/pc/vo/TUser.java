package com.pc.vo;

import java.io.Serializable;
import lombok.Data;

/**
 * t_user
 * @author 
 */
@Data
public class TUser implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private static final long serialVersionUID = 1L;
}