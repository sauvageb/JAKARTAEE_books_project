package com.book.project.demo.api;

import com.book.project.demo.dao.entity.Book;
import com.book.project.demo.dao.entity.DaoFactory;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/books")
public class BookRessource {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Book> books = DaoFactory.getBookDao().findAll();
        return Response.ok(books).build();
    }

}
