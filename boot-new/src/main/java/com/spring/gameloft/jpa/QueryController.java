package com.spring.gameloft.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;


@RestController
public class QueryController {

    @Autowired
    private QueryService queryService;

    @PostMapping("/run-query")
    public void runQuery(@RequestParam("queryString") String queryString,
            @RequestParam("query") String query, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        queryService.runQuery(query, queryString,  out);
    }
}
