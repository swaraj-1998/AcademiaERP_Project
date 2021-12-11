package com.swaraj.erp.controller;

import com.swaraj.erp.bean.Courses;
import com.swaraj.erp.service.CourseService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;

@Path("course")
public class CourseController {

    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN) //return type
    @Consumes(MediaType.APPLICATION_JSON) //parameter
    public Response addCourse(Courses course) throws URISyntaxException {
        boolean val = new CourseService().addCourse(course); //in service
        if (val == true)
            return Response.ok().build();
        else
            return Response.status(203).build();
    }

    @GET
    @Path("/getCourses")
    @Produces(MediaType.APPLICATION_JSON) //return type
    @Consumes(MediaType.APPLICATION_JSON) //parameter
    public Response getCourses() throws URISyntaxException {
        List<Courses> courses = new CourseService().getCourses(); //in service
        return Response.ok().entity(courses).build();
    }
}
