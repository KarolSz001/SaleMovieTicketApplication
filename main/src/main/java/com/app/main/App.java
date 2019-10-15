package com.app.main;


import com.app.repository.CustomerRepository;
import com.app.repository.LoyaltyCardRepository;
import com.app.repository.MovieRepository;
import com.app.repository.SalesStandRepository;
import com.app.services.ControlAppService;
import com.app.services.CustomerService;
import com.app.services.MovieService;
import com.app.services.SaleTicketService;
import com.app.valid.CustomerValidator;

public class App {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        sb.append(" ----------------------------------------------------------------------------- \n");
        sb.append(" movieTicketSale v1.3 11.10.2019 \n ");
        sb.append(" Karol Szot \n");
        sb.append(" ----------------------------------------------------------------------------- \n");
        System.out.println(sb.toString());

        var movieRepository = new MovieRepository();
        var customerRepository = new CustomerRepository();
        var customerValidator = new CustomerValidator();
        var salesStandRepository = new SalesStandRepository();
        var loyaltyCardRepository = new LoyaltyCardRepository();
        var saleTicketService = new SaleTicketService();

        var customerService = new CustomerService(
                movieRepository, customerRepository, customerValidator, salesStandRepository, loyaltyCardRepository);
        var movieService = new MovieService(customerRepository, customerValidator, salesStandRepository, loyaltyCardRepository, movieRepository);

        var controlAppService = new ControlAppService(customerService,movieService,saleTicketService);
        controlAppService.controlLoop();
    }
}
