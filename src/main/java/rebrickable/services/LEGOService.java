package rebrickable.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import rebrickable.mappers.LEGOMapper;
import rebrickable.model.LEGO.LEGORoot;
import rebrickable.model.LEGO.ThemesResults;

@org.springframework.stereotype.Service
public class LEGOService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LEGOMapper mapper;

    // put API key in for easy access
    private final String API_KEY = "d132d542ea1889b0454c8444576dff81";

    // search Rebrickable with keyword and map it to persist results
    public LEGORoot getLegoThemes (String persist){

        // create URL of API request, and put keyword
        String url = "https://rebrickable.com/api/v3/lego/themes/?key=" + API_KEY;

        // restTemplate connects to APIs for us, gets response and maps it to NTYResponse
        LEGORoot<ThemesResults> response = restTemplate.getForObject(url, LEGORoot.class);

        // if user passes in persist = true (Ignorecase), then we call the method persistResults
        if (persist.equalsIgnoreCase("true")){
            // pass the response that they got
            persistThemeResults(response);
        }

        return response;
    }

    // persist the results into the DB
    private void persistThemeResults(LEGORoot data){

        // since result is generic we use the object class as a type
        // data gets a generic array of results back
        for (ThemesResults result : data.getResults()){

            // cast the result into ThemesResults to map tr to results
//            ThemesResults tr = (ThemesResults) result;

            // insert tr into the DB
                mapper.insertThemeResult(result);
        }
    }

    public ThemesResults addNew(ThemesResults themes) {
        mapper.insertThemeResult(themes);
        return themes;
    }
}
