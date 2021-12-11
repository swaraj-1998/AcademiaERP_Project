package com.swaraj.erp.controller;

import com.swaraj.erp.bean.Departments;
import com.swaraj.erp.service.DepartmentsService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("departments")
public class DepartmentsController {
    DepartmentsService departmentService= new DepartmentsService();

    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDepartment(Departments dept) {
        boolean flag = departmentService.addDepartment(dept);
        return Response.ok().entity(dept).build();
    }

}
