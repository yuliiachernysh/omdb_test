package stepdefinitions;

import Data.Movies;
import clients.MovieClient;
import common.ResponseReader;
import configuration.ConfigProperties;
import configuration.ConfigurationProvider;
import dtos.ErrorDto;
import dtos.MovieDto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Movie;
import models.RequestParameters;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class Search {
    private ConfigProperties configuration;
    private MovieClient movieClient;
    private ResponseReader responseReader;

    private HttpResponse httpResponse;
    private RequestParameters requestParameters;
    private Movies testDataMovies;

    public Search(){
        configuration = ConfigurationProvider.getConfiguration();
        movieClient = new MovieClient(configuration.baseApiUrl(), configuration.apiKey());
        responseReader = new ResponseReader();
        requestParameters = new RequestParameters();
        testDataMovies = new Movies();
    }

    @Given("I set title={word}")
    public void GivenTitle(String title) {
        requestParameters.setTitle(title);
    }

    @Given("I set title={word} and year={int}")
    public void GivenTitleAndYear(String title, Integer year) {
        requestParameters.setTitle(title);
        requestParameters.setYear(year);
    }

    @Given("I set title={word} and plot={word}")
    public void GivenTitleAndPlotType(String title, String plotType) {
        requestParameters.setTitle(title);
        requestParameters.setPlot(plotType);
    }

    @Given("I set title={word} and plot={word} and year={int}")
    public void GivenTitleAndPlotTypeAndYear(String title, String plotType, Integer year) {
        requestParameters.setTitle(title);
        requestParameters.setPlot(plotType);
        requestParameters.setYear(year);
    }

    @Given("I set title={word} and format={word}")
    public void GivenTitleAndFormat(String title, String format) {
        requestParameters.setTitle(title);
        requestParameters.setResponseType(format);
    }

    @Given("I set title={word} and year={int} and format={word}")
    public void GivenTitleAndYearAndFormat(String title, Integer year, String format) {
        requestParameters.setTitle(title);
        requestParameters.setYear(year);
        requestParameters.setResponseType(format);
    }

    @Given("I set title={word} and plot={word} and format={word}")
    public void GivenTitleAndPlotTypeAndFormat(String title, String plotType, String format) {
        requestParameters.setTitle(title);
        requestParameters.setPlot(plotType);
        requestParameters.setResponseType(format);
    }

    @Given("I set title={word} and plot={word} and year={int} and format={word}")
    public void GivenTitleAndPlotTypeAndYearAndFormat(String title, String plotType, Integer year, String format) {
        requestParameters.setTitle(title);
        requestParameters.setPlot(plotType);
        requestParameters.setYear(year);
        requestParameters.setResponseType(format);
    }

    @When("Send GET http request for movie")
    public void WhenSendGetRequest() throws IOException {
        httpResponse = movieClient.getMovieResponse(requestParameters);
    }

    @Then("I receive valid response with movie id={word}")
    public void ThenReceiveMovieWithId(String id) throws IOException, JAXBException, XMLStreamException {
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

        Movie expectedMovie = testDataMovies.FindMovieByIdAndPlotType(id, "short");
        MovieDto receivedMovie = responseReader.Read(httpResponse, MovieDto.class, requestParameters.getResponseType());

        VerifyReceivedMovie(expectedMovie, receivedMovie);
    }

    @Then("I receive valid response with movie id={word} and plot type={word}")
    public void ThenReceiveMovieWithIdAndPlotType(String id, String plotType) throws IOException, JAXBException, XMLStreamException {
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

        Movie expectedMovie = testDataMovies.FindMovieByIdAndPlotType(id, plotType);
        MovieDto receivedMovie = responseReader.Read(httpResponse, MovieDto.class, requestParameters.getResponseType());

        VerifyReceivedMovie(expectedMovie, receivedMovie);
    }


    @Then("I receive error response")
    public void ThenReceiveNoMovie() throws IOException, JAXBException, XMLStreamException {
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

        ErrorDto errorDto = responseReader.Read(httpResponse, ErrorDto.class, requestParameters.getResponseType());
        Assert.assertEquals("False", errorDto.Response);
        Assert.assertEquals( "Movie not found!", errorDto.Error);
    }

    private void VerifyReceivedMovie(Movie expectedMovie, MovieDto receivedMovie) {
        Assert.assertEquals(expectedMovie.getId(), receivedMovie.imdbID);
        Assert.assertEquals(expectedMovie.getTitle(), receivedMovie.Title);
        Assert.assertEquals(expectedMovie.getYear(), receivedMovie.Year);
        Assert.assertEquals(expectedMovie.getPlot(), receivedMovie.Plot);
    }
}
