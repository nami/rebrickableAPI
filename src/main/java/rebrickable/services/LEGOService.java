package rebrickable.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import rebrickable.mappers.LEGOMapper;
import rebrickable.model.LEGO.*;
import rebrickable.model.db.Parts;

@org.springframework.stereotype.Service
public class LEGOService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LEGOMapper mapper;

    // put API key & USER_TOKEN in for easy access
    private final String API_KEY = "***+";
    private final String USER_TOKEN = "****";

    // search Rebrickable for themes and map it to persist results
    public ThemesRoot getLegoThemes(String persist) {

        // create URL of API request, and put keyword
        String url = "https://rebrickable.com/api/v3/lego/themes/?key=" + API_KEY;

        // restTemplate connects to APIs for us, gets response and maps it to ThemesRoot
        ThemesRoot<ThemesResults> response = restTemplate.getForObject(url, ThemesRoot.class);

        // if user passes in persist = true (Ignorecase), then we call the method persistResults
        if (persist.equalsIgnoreCase("true")) {
            // pass the response that they got
            persistThemeResults(response);
        }

        return response;
    }

    // persist the results into the DB
    private void persistThemeResults(ThemesRoot data) {

        // for each theme get results
        for (ThemesResults result : data.getResults()) {

            // insert results into the DB
            mapper.insertThemeResult(result);
        }
    }

    // search Rebrickable for sets and map it to persist results
    public SetsRoot getLegoSets(String persist) {

        // create URL of API request, and put keyword
        String url = "https://rebrickable.com/api/v3/lego/sets/?key=" + API_KEY;

        // restTemplate connects to APIs for us, gets response and maps it to SetsRoot
        SetsRoot response = restTemplate.getForObject(url, SetsRoot.class);

        // if user passes in persist = true (Ignorecase), then we call the method persistResults
        if (persist.equalsIgnoreCase("true")) {
            // pass the response they got
            persistSetsResults(response);
        }
        return response;
    }

    // persist the results into the DB
    private void persistSetsResults(SetsRoot data) {

        // for each set get results
        for (SetsResults results : data.getResults()) {

            // insert result into DB
            mapper.insertSetResult(results);

        }
    }

    public PartsRoot searchParts(String keyword, String persist) {

        // create URL of API request, and put keyword
        String url = "https://rebrickable.com/api/v3/lego/parts/?key=" + API_KEY + "&search=" + keyword;

        // restTemplate connects to APIs for us, gets response and maps it to PartsRoot
        PartsRoot response = restTemplate.getForObject(url, PartsRoot.class);

        // if user passes in persist = true (Ignorecase), then we call the method persistResults
        if (persist.equalsIgnoreCase("true")) {
            // pass the response that they got
            persistResults(response);
        }
        return response;
    }

    private void persistResults(PartsRoot data) {

        // for each partsresults  element in the results[] response
        for (PartsResults parts : data.getResults()) {

            // create object to insert into DB
            Parts p = new Parts();

            // set parts values
            p.setName(parts.getName());
            p.setPart_num(parts.getPart_num());
            p.setPart_url(parts.getPart_url());

            // insert parts into DB
            mapper.insertRecord(p);
        }
    }

    // POST method to get a user token
    public ResponseEntity<UserToken> getToken(String key) {

        // create url of API request
        String url = "https://rebrickable.com/api/v3/users/_token/";

        // to get authorisation for the API
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", "key " + API_KEY);

        // content body (username & password)
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("username", "****");
        map.add("password", "****");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        ResponseEntity<UserToken> response = restTemplate.postForEntity(url, request, UserToken.class);

        return response;
    }

    // GET method to get all my lego set
    public MySetsRoot getMySets() {

        // create URL of API request
        String url = "https://rebrickable.com/api/v3/users/" + USER_TOKEN + "/sets/?key=" + API_KEY;

        // restTemplate connects to APIs for us, gets response and maps it to ThemesRoot
        MySetsRoot response = restTemplate.getForObject(url, MySetsRoot.class);

        return response;
    }

    // POST method to add a lego set
    public MySetsRoot addSet() {

        // set you want to add
        String set = "8053-1";

        // create url of API request
        String url = "https://rebrickable.com/api/v3/users/" + USER_TOKEN + "/sets/";

        // to get authorisation for the API by using headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", "key " + API_KEY);

        // content body (set number)
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("set_num", set);
        map.add("quantity", "1");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        ResponseEntity<MySetsRoot> response = restTemplate.postForEntity(url, request, MySetsRoot.class);

        // GET Request to show the posted set to user after adding set
        String uri = "https://rebrickable.com/api/v3/users/" + USER_TOKEN + "/sets/?key=" + API_KEY + "&search=" + set;

        // restTemplate connects to APIs for us, gets response and maps it to ThemesRoot
        MySetsRoot getresponse = restTemplate.getForObject(uri, MySetsRoot.class);

        return getresponse;
    }

    // PUT method to change quantity of sets (this can delete & add too)
    public MySetsRoot updateSet() {

        // set you want to update
        String set = "71012-7";

        // create url of API request (include user token & set you want to update
        String url = "https://rebrickable.com/api/v3/users/" + USER_TOKEN + "/sets/" + set + "/";

        // to get authorisation for the API by using headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("Authorization", "key " + API_KEY);

        // content body (set number)
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("set_num", set);
        map.add("quantity", "2");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        ResponseEntity<MySetsRoot> response = restTemplate.exchange(url, HttpMethod.PUT, request, MySetsRoot.class);

        // GET Request to show the posted set to user after adding set
        String uri = "https://rebrickable.com/api/v3/users/" + USER_TOKEN + "/sets/?key=" + API_KEY + "&search=" + set;

        // restTemplate connects to APIs for us, gets response and maps it to ThemesRoot
        MySetsRoot getresponse = restTemplate.getForObject(uri, MySetsRoot.class);

        return getresponse;
    }

}


