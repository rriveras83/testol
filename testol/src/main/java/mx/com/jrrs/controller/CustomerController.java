package mx.com.jrrs.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import mx.com.jrrs.service.CustomerService;
import mx.com.jrrs.vo.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

@Component
@Path("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerVO> fetchAllCustomers() {
        return customerService.fetchAllCustomers();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response createCustomer(CustomerVO customerVO){
    	customerService.createCustomer(customerVO);
    	return Response.created(URI.create("http://localhost:8080/services/customer")).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    public Response updateCustomer(CustomerVO customerVO){
    	customerService.updateCustomer(customerVO);
    	return Response.ok(customerVO).build();
    }
    
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response deleteCustomer(@PathParam("id") Integer id){
    	customerService.deleteCustomer(id);
    	return Response.noContent().build();
    }
    
    
    
    
    
    
    
    
    
    
}