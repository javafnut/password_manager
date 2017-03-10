package com.ibexsys.pwd.test;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.springframework.stereotype.Component;

import com.ibexsys.pwd.domain.Customer;
import com.ibexsys.pwd.domain.Customers;

@Component
@Path("/test")
public class CustomerResource {
	
	private static Map<Integer, Customer> customerDB = new ConcurrentHashMap<Integer, Customer>();
	private static AtomicInteger idCounter = new AtomicInteger();

	static {
		System.out.println("CustomerResource created");
		Customer customer = new Customer();
		customer.setId(idCounter.incrementAndGet());
		customer.setFirstName("Tom");
		customer.setLastName("Jones");
		customer.setStreet("263 jacon Street");
		customer.setCity("Maimi");
		customer.setState("FL");
		customer.setZip("55556");
		customer.setCountry("USA");
		customerDB.put(customer.getId(), customer);

		customer = new Customer();
		customer.setId(idCounter.incrementAndGet());
		customer.setFirstName("John");
		customer.setLastName("Mary");
		customer.setStreet("111 Dream Street");
		customer.setCity("LA");
		customer.setState("CA");
		customer.setZip("12345");
		customer.setCountry("USA");
		customerDB.put(customer.getId(), customer);
	}

	@GET
	@Produces({  "application/json" })
	public Customers getCustomers() {

		ArrayList<Customer> customerList = new ArrayList<Customer>();
		synchronized (customerDB) {
			for (Customer customer : customerDB.values()) {
				customerList.add(customer);
			}
		}

		Customers customers = new Customers();
		customers.setCustomers(customerList);
		return customers;
	}

	@GET
	@Path("{id}")
	@Produces({ "application/xml", "application/json" })
	public Customer getCustomer(@PathParam("id") int id) {

		Customer customer = customerDB.get(id);
		if (customer == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return customer;
	}

	@Context
	UriInfo uriInfo;

	@POST
    @Consumes({ "application/xml", "application/json" })
	public Response createCustomer(Customer customer) {
		customer.setId(idCounter.incrementAndGet());
		customerDB.put(customer.getId(), customer);
		UriBuilder uriBuilder = UriBuilder.fromUri(uriInfo.getRequestUri());
		uriBuilder.path("{id}");
		return Response.created(uriBuilder.build(customer.getId())).build();

	}

	@PUT
	@Path("{id}")
	@Consumes({ "application/xml", "application/json" })
	public Response updateCustomer(@PathParam("id") int id, Customer update) {
		Customer customer = customerDB.get(id);
		if (customer == null)
			throw new WebApplicationException(Response.Status.NOT_FOUND);

		customer.setFirstName(update.getFirstName());
		customer.setLastName(update.getLastName());
		customer.setStreet(update.getStreet());
		customer.setState(update.getState());
		customer.setZip(update.getZip());
		customer.setCountry(update.getCountry());
		customerDB.put(id, customer);

		UriBuilder uriBuilder = UriBuilder.fromUri(uriInfo.getRequestUri());
		uriBuilder.path("{id}");
		return Response.status(204).build();
	}

	@DELETE
	@Path("{id}")
	public Response deleteCustomer(@PathParam("id") int id) {

		Customer customer = customerDB.get(id);
		if (customer == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		customerDB.remove(id);
		Response.ResponseBuilder builder = Response.ok();
		return builder.build();
	}
	
    @GET
    @Path("numerOfCustomers")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        int count = customerDB.size();
        return String.valueOf(count);
    }
}
