package api.Owners.data;

import api.common.ApiClient;
import api.common.ApiRequest;
import api.common.ApiResponse;
import api.common.exception.InvalidResponseException;
import com.google.gson.GsonBuilder;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.http.Method;
import io.restassured.internal.mapping.GsonMapper;
import io.restassured.mapper.ObjectMapperType;

import java.util.List;

public class OwnersApiClient extends ApiClient {

    public OwnersApiClient(String baseUrl) {
        super(baseUrl, "/api/owners");

        ObjectMapperConfig config = new ObjectMapperConfig(ObjectMapperType.GSON)
                .gsonObjectMapperFactory((type, s) -> new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create());
        setObjectMapper(new GsonMapper(config.gsonObjectMapperFactory()));
    }

    public List<Owner> getOwners() throws InvalidResponseException {

        ApiResponse<Owner> response = caller.executeRequest(getRequest(), Method.GET, Owner.class);
        return (List<Owner>) response.getContent();

    }
    public Owner createOwner(Owner owner) throws InvalidResponseException {
        ApiRequest request = getRequest().withBody(owner).withHeader("Content-Type", "application/json");
        ApiResponse<Owner> response = caller.executeRequest(request, Method.POST, Owner.class);
        return response.getContent();
    }
   /* public List<Service> getServices() throws InvalidResponseException {
        ApiResponse<ServiceResponse> response = caller.executeRequest(getRequest(), Method.GET, ServiceResponse.class);
        return response.getContent().getServices();
    }
*/
   /* public Service createService(Service service) throws InvalidResponseException {
        ApiRequest request = getRequest().withBody(service).withHeader("Content-Type", "application/json");
        ApiResponse<Service> response = caller.executeRequest(request, Method.POST, Service.class);
        return response.getContent();
    }

    public List<Service> getServicesByQuery(String query) throws InvalidResponseException {
        String[] queryParams = query.split("=");
        ApiRequest request = getRequest().withQueryParam(queryParams[0], queryParams[1]);
        ApiResponse<ServiceResponse> response = caller.executeRequest(getRequest(), Method.GET, ServiceResponse.class);
        return response.getContent().getServices();
    }*/
}
