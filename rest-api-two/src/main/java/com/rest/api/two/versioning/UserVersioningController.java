package com.rest.api.two.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserVersioningController {

//    i -> URI versioning

    @GetMapping("v1/user")
    public UserV1 userV1() {
        return new UserV1("Himanshu Kumar");
    }

    @GetMapping("v2/user")
    public UserV2 userV2() {
        return new UserV2(new Name("Himanshu ", "Kumar"));
    }

    //  ii-> Request Parameter versioning

    // from postman or etc
    // 8080/user/param?version=1
    @GetMapping(value = "/user/param", params = "version=1")
    public UserV1 paramV1() {
        return new UserV1("Himanshu Kumar");
    }

    @GetMapping(value = "/user/param", params = "version=2")
    public UserV2 paramV2() {
        return new UserV2(new Name("Himanshu ", "Kumar"));
    }

    // iii -> Header versioning
    // from postman 8080/user/header
    // From Headers section key => X-API-VERSION, value = 1

    @GetMapping(value = "/user/header", headers = "X-API-VERSION=1")
    public UserV1 headerV1() {
        return new UserV1("Himanshu Kumar");
    }

    @GetMapping(value = "/user/header", headers = "X-API-VERSION=2")
    public UserV2 headerV2() {
        return new UserV2(new Name("Himanshu ", "Kumar"));
    }

    // iv -> MimeType
    // from postman Accept and then produces value
    @GetMapping(value = "/user/produces", produces = "application/vnd.company.app-v1+json")
    public UserV1 producesV1() {
        return new UserV1("Himanshu Kumar");
    }

    @GetMapping(value = "/user/produces", produces = "application/vnd.company.app-v2+json")
    public UserV2 producesV2() {
        return new UserV2(new Name("Himanshu ", "Kumar"));
    }

}
