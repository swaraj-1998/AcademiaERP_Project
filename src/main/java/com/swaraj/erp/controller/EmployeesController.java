package com.swaraj.erp.controller;

import com.swaraj.erp.bean.Employees;
import com.swaraj.erp.service.EmployeesService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Path("login")
public class EmployeesController {
    EmployeesService employeesService = new EmployeesService();

    @POST
    @Path("/verify")
    @Produces(MediaType.APPLICATION_JSON) //return type
    @Consumes(MediaType.APPLICATION_JSON) //parameter
    public Response verifyEmployee(Employees e) throws URISyntaxException {
        boolean verified = employeesService.verifyEmployee(e);
        System.out.println(verified);
        if (verified == true)
            return Response.ok().entity(e).build();
        else
            return Response.status(203).build();
    }


}
