package mk.finki.ukim.mk.labs.web.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.labs.service.MovieService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name="movie-list-servlet",urlPatterns = "/movies")
public class MovieListServlet extends HttpServlet {

    private final MovieService movieService;
    private final SpringTemplateEngine springTemplateEngine;
    public MovieListServlet(MovieService movieService,SpringTemplateEngine springTemplateEngine) {
        this.movieService = movieService;
        this.springTemplateEngine=springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(req.getServletContext())
                .buildExchange(req, resp);
        WebContext webContext = new WebContext(webExchange);

        String search_movieName=req.getParameter("search_movieName");
        String search_movieRating=req.getParameter("search_movieRating");

        if(search_movieName==null && search_movieRating==null){
            webContext.setVariable("movies", movieService.findAll());
        }
        else if(search_movieName==null){
            //int rating=Integer.parseInt(search_movieRating);
            webContext.setVariable("movies",movieService.searchByRating(search_movieRating));
        }
        else if(search_movieRating==null || search_movieRating.isEmpty()){
            webContext.setVariable("movies",movieService.searchByTitle(search_movieName));
        }
        else{
            //int rating=Integer.parseInt(search_movieRating);
            webContext.setVariable("movies",movieService.searchMoviesByTitleAndRating(search_movieName,search_movieRating));
        }

        this.springTemplateEngine.process("listMovies.html",webContext,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title=req.getParameter("title");
        int numTickets=Integer.parseInt(req.getParameter("numTickets"));
        resp.sendRedirect("/ticketOrder");
    }
}