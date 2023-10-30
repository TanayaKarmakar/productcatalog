package com.app.product.productcatalog.security;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class JwtObject {
    private Long userId;
    private String email;
    private Date expiredAt;
    private Date createdAt;
    private List<Role> roles;

}
